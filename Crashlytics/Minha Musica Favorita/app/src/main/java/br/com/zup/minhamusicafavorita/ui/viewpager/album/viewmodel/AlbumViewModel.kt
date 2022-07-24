import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.minhamusicafavorita.domain.model.Album
import br.com.zup.minhamusicafavorita.ui.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AlbumViewModel(application: Application) : AndroidViewModel(application) {
    private val albumUseCase = AlbumUseCase(application)
    val albumListState = MutableLiveData<ViewState<List<Album>>>()

    fun albumAdd(listAlbum: List<Album>){
        viewModelScope.launch {
            try {
                albumUseCase.insertAlbumsDB(listAlbum)
            } catch (ex: Exception){
                Log.i("Error", "Erro-----> ${ex.message}")
            }
        }
    }

    fun getAlbumList() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    albumUseCase.getAllAlbums()
                }
                albumListState.value = response
            } catch (ex: Exception) {
                albumListState.value =
                    ViewState.Error(Throwable("Tivemos um problema! Tente mais tarde."))
            }
        }
    }
}
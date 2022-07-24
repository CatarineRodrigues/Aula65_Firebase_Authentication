import android.app.Application
import br.com.zup.minhamusicafavorita.data.datasource.local.AlbumDatabase
import br.com.zup.minhamusicafavorita.domain.model.Album
import br.com.zup.minhamusicafavorita.ui.viewstate.ViewState

class AlbumUseCase(application: Application) {
    private val albumDao = AlbumDatabase.getDatabase(application).albumDao()
    private val albumRepository = AlbumRepository(albumDao)

    suspend fun insertAlbumsDB(listAlbum: List<Album>): ViewState<List<Album>> {
        return try {
            albumRepository.insertAlbumsDB(listAlbum)
            ViewState.Success(listAlbum)
        } catch (ex: Exception) {
            ViewState.Error(Exception("Não foi possível inserir o album!"))
        }
    }

    suspend fun getAllAlbums(): ViewState<List<Album>> {
        return try {
            val listAlbum = albumRepository.getAllAlbums()
            ViewState.Success(listAlbum)
        } catch (ex: Exception) {
            ViewState.Error(Exception("Não foi possível carregar a lista de albuns!"))
        }
    }
}
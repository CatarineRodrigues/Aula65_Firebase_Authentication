package br.com.zup.exerciciofirebaseauthentication.ui.favorite.viewmodel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.exerciciofirebaseauthentication.domain.repository.FavoriteRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class FavoriteViewModel : ViewModel() {
    private val favoriteRepository = FavoriteRepository()

    private var _favoriteListState = MutableLiveData<List<String>>()
    val favoriteListState: LiveData<List<String>> = _favoriteListState

    private var _messageState = MutableLiveData<String>()
    val messageState: LiveData<String> = _messageState

    fun getListMessageFavorited() {
        favoriteRepository.getListMessageFavorited()
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    val favoriteList = mutableListOf<String>()

                    for (resultSnapshot in snapshot.children) {
                        val favoriteResponse = resultSnapshot.getValue(String::class.java)
                        favoriteResponse?.let { favoriteList.add(it) }
                    }
                    _favoriteListState.value = favoriteList
                }

                override fun onCancelled(error: DatabaseError) {
                    _messageState.value = error.message
                }
            })
    }

    fun removeMessageFavorite(message: String) {
        val uri: Uri = Uri.parse(message)
        val pathImage: String? = uri.lastPathSegment?.replace(".jpg", "")
        favoriteRepository.getDatabaseReference().child("$pathImage").removeValue()
    }
}
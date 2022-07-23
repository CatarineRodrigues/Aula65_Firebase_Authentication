package br.com.zup.exerciciofirebaseauthentication.ui.createmessage.viewmodel

import androidx.lifecycle.ViewModel
import br.com.zup.exerciciofirebaseauthentication.domain.repository.FavoriteRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class CreateMessageViewModel : ViewModel() {
    private val favoriteRepository = FavoriteRepository()

    fun saveMessageFavorited(message: String) {
      favoriteRepository.getDatabaseReference().ref.push().setValue(message)
    }

}
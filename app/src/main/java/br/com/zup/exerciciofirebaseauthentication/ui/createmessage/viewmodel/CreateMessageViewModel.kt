package br.com.zup.exerciciofirebaseauthentication.ui.createmessage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.exerciciofirebaseauthentication.domain.repository.FavoriteRepository

class CreateMessageViewModel : ViewModel() {
    private val favoriteRepository = FavoriteRepository()

    private var _messageState = MutableLiveData<String>()
    val messageState: LiveData<String> = _messageState

    private var _errorState = MutableLiveData<String>()
    val errorState: LiveData<String> = _errorState

    fun saveMessageFavorited(message: String) {
        favoriteRepository.getDatabaseReference().ref.push().setValue(message) { error, _ ->
            if (error != null) {
                _errorState.value = error.message
            }
            _messageState.value = "Mensagem Favoritada"
        }
    }
}
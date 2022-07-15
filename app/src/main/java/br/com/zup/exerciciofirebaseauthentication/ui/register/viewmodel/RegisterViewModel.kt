package br.com.zup.exerciciofirebaseauthentication.ui.register.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.exerciciofirebaseauthentication.domain.model.User
import br.com.zup.exerciciofirebaseauthentication.domain.repository.AuthenticationRepository

class RegisterViewModel: ViewModel() {
    private val authenticationRepository = AuthenticationRepository()

    private var _registerResponse = MutableLiveData<User>()
    val registerResponse: LiveData<User> = _registerResponse

    private var _errorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String> = _errorResponse

    fun validateDataUser(user: User) {
        when {
            user.name.isEmpty() -> {
                _errorResponse.value = "Preencha seu nome"
            }
            user.email.isEmpty() -> {
                _errorResponse.value = "Insira seu email"
            }
            user.password.isEmpty() -> {
                _errorResponse.value = "Insira qual será sua senha"
            }
            else -> {
                registerUser(user)
            }
        }
    }

    private fun registerUser(user: User) {
        try {
            authenticationRepository.registerUser(
                user.email,
                user.password
            ).addOnSuccessListener {

                authenticationRepository.updateUserProfile(user.name)?.addOnSuccessListener {
                    _registerResponse.value = user
                }

            }.addOnFailureListener {
                _errorResponse.value = "Ops! Ocorreu um erro ao criar o usuário!" + it.message
            }
        } catch (ex: Exception) {
            _errorResponse.value = ex.message
        }
    }

}
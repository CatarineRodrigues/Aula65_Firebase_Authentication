package br.com.zup.exerciciofirebaseauthentication.ui.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.zup.exerciciofirebaseauthentication.R
import br.com.zup.exerciciofirebaseauthentication.databinding.ActivityLoginBinding
import br.com.zup.exerciciofirebaseauthentication.domain.model.User
import br.com.zup.exerciciofirebaseauthentication.ui.home.view.HomeActivity
import br.com.zup.exerciciofirebaseauthentication.ui.login.viewmodel.LoginViewModel
import br.com.zup.exerciciofirebaseauthentication.ui.register.view.RegisterActivity
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setClickButtonLogin()
//        goToRegistration()
//        initObservers()
    }

    private fun goToHomePage(user: User) {
        val intent = Intent(this, HomeActivity::class.java).apply {
            putExtra("user key", user)
        }
        startActivity(intent)
    }

    private fun initObservers() {
        viewModel.loginResponse.observe(this) {
            goToHomePage(it)
        }
        viewModel.errorResponse.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun goToRegistration(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun setClickButtonLogin(){
        binding.btnLogin.setOnClickListener {
            val user =  getDataUser()
            viewModel.validateDataUser(user)
        }
    }

    private fun getDataUser(): User {
        return User(
            email = binding.etEmail.text.toString(),
            password = binding.etPassword.text.toString()
        )
    }
}
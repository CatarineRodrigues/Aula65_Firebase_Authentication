package br.com.zup.exerciciofirebaseauthentication.ui.register.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.zup.exerciciofirebaseauthentication.databinding.ActivityRegisterBinding
import br.com.zup.exerciciofirebaseauthentication.domain.model.User
import br.com.zup.exerciciofirebaseauthentication.ui.home.view.HomeActivity
import br.com.zup.exerciciofirebaseauthentication.ui.register.viewmodel.RegisterViewModel
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this)[RegisterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        getDataUser()
        setClickButtonFinishRegistration()
        initObserver()
    }

    private fun getDataUser(): User {
        return User(
            name = binding.etUsername.text.toString(),
            email = binding.etUseremail.text.toString(),
            password = binding.etPassword.text.toString()
        )
    }

    private fun initObserver() {
        viewModel.registerResponse.observe(this) {
            goToHomePage(it)
        }
        viewModel.errorResponse.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun setClickButtonFinishRegistration(){
        binding.btnRegistration.setOnClickListener {
            val user = getDataUser()
            viewModel.validateDataUser(user)
        }
    }

    private fun goToHomePage(user: User) {
        val intent = Intent(this, HomeActivity::class.java).apply {
            putExtra("user key", user)
        }
        startActivity(intent)
    }
}
package br.com.zup.exerciciofirebaseauthentication.ui.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.exerciciofirebaseauthentication.R
import br.com.zup.exerciciofirebaseauthentication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
    }
}
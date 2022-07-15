package br.com.zup.exerciciofirebaseauthentication.ui.register.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.exerciciofirebaseauthentication.R
import br.com.zup.exerciciofirebaseauthentication.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
    }
}
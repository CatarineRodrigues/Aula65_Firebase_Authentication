package br.com.zup.exerciciofirebaseauthentication.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.exerciciofirebaseauthentication.R
import br.com.zup.exerciciofirebaseauthentication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
    }
}
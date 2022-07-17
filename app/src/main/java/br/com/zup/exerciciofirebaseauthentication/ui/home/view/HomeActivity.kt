package br.com.zup.exerciciofirebaseauthentication.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import br.com.zup.exerciciofirebaseauthentication.R
import br.com.zup.exerciciofirebaseauthentication.databinding.ActivityHomeBinding
import br.com.zup.exerciciofirebaseauthentication.domain.model.User
import br.com.zup.exerciciofirebaseauthentication.ui.home.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item1_exit -> {
                viewModel.logoutUser()
                this.finish()
//                goToLogin()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getRegisterUser(){
        val user = intent?.getParcelableExtra<User>("user key")
        user?.let {

        }
    }
}
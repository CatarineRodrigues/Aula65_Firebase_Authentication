package br.com.zup.exerciciofirebaseauthentication.ui.login.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import br.com.zup.exerciciofirebaseauthentication.R
import br.com.zup.exerciciofirebaseauthentication.data.datasource.remote.MyFirebaseMessagingService
import br.com.zup.exerciciofirebaseauthentication.databinding.ActivityLoginBinding
import br.com.zup.exerciciofirebaseauthentication.domain.model.User
import br.com.zup.exerciciofirebaseauthentication.ui.home.view.HomeActivity
import br.com.zup.exerciciofirebaseauthentication.ui.login.viewmodel.LoginViewModel
import br.com.zup.exerciciofirebaseauthentication.ui.register.view.RegisterActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.ktx.remoteMessage

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickButtonLogin()
        setClickButtonNewRegister()
        initObservers()
        showToken()
        LocalBroadcastManager.getInstance( this ).registerReceiver(messageReceiver, IntentFilter( "MyData" ))
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

    private fun setClickButtonNewRegister(){
        binding.tvNewRegister.setOnClickListener {
            goToRegistration()
        }
    }

    private fun setClickButtonLogin(){
        binding.btnLogin?.setOnClickListener {
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

    private fun showToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(
            OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    return@OnCompleteListener
                }
                val token = task.result
                binding.tvToken.text = token
//                binding.tvTitleNotification.text = FirebaseMessaging.getInstance().isAutoInitEnabled.toString()

//                binding.tvTitleNotification.text = FirebaseMessaging.getTransportFactory().toString()

            }
        )
    }

    private  val messageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override  fun  onReceive (context: Context?, intent: Intent ) {
            binding.tvTitleNotification.text = intent.extras?.getString( "message" )
        }
    }

}
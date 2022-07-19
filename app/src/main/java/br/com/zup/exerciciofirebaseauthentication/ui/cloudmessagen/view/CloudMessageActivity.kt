package br.com.zup.exerciciofirebaseauthentication.ui.cloudmessagen.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.exerciciofirebaseauthentication.data.datasource.remote.MyFirebaseMessagingService
import br.com.zup.exerciciofirebaseauthentication.databinding.ActivityCloudMessageBinding

class CloudMessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCloudMessageBinding
    private val message = MyFirebaseMessagingService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCloudMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.tvToken.text = message.onMessageReceived(co)

    }



}
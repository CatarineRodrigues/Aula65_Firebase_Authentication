package br.com.zup.exerciciofirebaseauthentication.ui.createmessage.view

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.exerciciofirebaseauthentication.databinding.ActivityCreateMessageBinding
import br.com.zup.exerciciofirebaseauthentication.ui.createmessage.viewmodel.CreateMessageViewModel
import br.com.zup.exerciciofirebaseauthentication.ui.favorite.view.FavoriteActivity

class CreateMessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateMessageBinding
    private var messageList = mutableListOf<String>()

    private val adapter: CreateMessageAdapter by lazy {
        CreateMessageAdapter(arrayListOf(), ::favoriteMessage)
    }

    private val viewModel: CreateMessageViewModel by lazy {
        ViewModelProvider(this)[CreateMessageViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        addNewMessage()
        setRecyclerView()
        goToFavoriteList()
        intObserver()
    }

    private fun addNewMessage() {
        binding.bvAdicionar.setOnClickListener {
            val text = binding.etMessageText.text
            text?.let {
                if (text.isNotBlank()) {
                    messageList.add(text.toString())
                    adapter.updateMessageList(messageList)
                    Toast.makeText(this, "Mensagem adicionada a lista", Toast.LENGTH_LONG).show()
                    clearEditText()
                } else {
                    Toast.makeText(this, "Escreva uma mensagem primeiro", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun favoriteMessage(message: String) {
        viewModel.saveMessageFavorited(message)
    }

    private fun clearEditText() {
        binding.etMessageText.text.clear()
    }

    private fun setRecyclerView() {
        binding.rvMessagelist.adapter = adapter
        binding.rvMessagelist.layoutManager = LinearLayoutManager(this)
    }

    private fun goToFavoriteList() {
        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this, FavoriteActivity::class.java))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun intObserver() {
        viewModel.messageState.observe(this) {
            Toast.makeText(this, "Mensagem Favoritada!", Toast.LENGTH_LONG).show()
        }

        viewModel.errorState.observe(this) {
            Toast.makeText(this, "Não foi possível favoritar a mensagem", Toast.LENGTH_LONG).show()
        }
    }
}
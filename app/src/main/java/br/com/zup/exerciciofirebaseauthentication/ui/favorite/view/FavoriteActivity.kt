package br.com.zup.exerciciofirebaseauthentication.ui.favorite.view

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.exerciciofirebaseauthentication.databinding.ActivityFavoriteBinding
import br.com.zup.exerciciofirebaseauthentication.ui.favorite.viewmodel.FavoriteViewModel

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding

    private val viewModel: FavoriteViewModel by lazy {
        ViewModelProvider(this)[FavoriteViewModel::class.java]
    }

    private val adapter: FavoriteAdapter by lazy {
        FavoriteAdapter(arrayListOf(), ::removeFavoriteMessage
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        viewModel.getListMessageFavorited()
        setUpRecyclerView()
        initObservers()
    }

    private fun setUpRecyclerView() {
        binding.rvMessagelist.layoutManager = LinearLayoutManager(this)
        binding.rvMessagelist.adapter = adapter
    }

    private fun initObservers() {
        viewModel.favoriteListState.observe(this) {
            adapter.updateMessageList(it.toMutableList())
        }

        viewModel.messageState.observe(this) {
            loadMessage(it)
        }
    }

    private fun loadMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun removeFavoriteMessage(message: String) {
        viewModel.removeMessageFavorite(message)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
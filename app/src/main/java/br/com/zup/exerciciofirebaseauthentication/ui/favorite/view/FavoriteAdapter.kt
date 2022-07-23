package br.com.zup.exerciciofirebaseauthentication.ui.favorite.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.exerciciofirebaseauthentication.databinding.MessageItemBinding
import com.squareup.picasso.Picasso

class FavoriteAdapter (
    private var favoriteList: MutableList<String>,
    private val onDisfavorCLick: (message: String) -> Unit
) :
    RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MessageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = favoriteList[position]
        holder.showMessage(message)
        holder.binding.icFavorite.setOnClickListener {
            onDisfavorCLick(message)
        }
    }

    override fun getItemCount() = favoriteList.size

    fun updateMessageList(newList: MutableList<String>) {
        favoriteList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: MessageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun showMessage(message: String) {
            binding.tvMessageBody.text = message
        }
    }
}
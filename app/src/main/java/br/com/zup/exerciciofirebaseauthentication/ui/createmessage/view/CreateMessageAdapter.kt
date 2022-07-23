package br.com.zup.exerciciofirebaseauthentication.ui.createmessage.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.exerciciofirebaseauthentication.databinding.MessageItemBinding
import com.squareup.picasso.Picasso

class CreateMessageAdapter (
    private var messageList: MutableList<String>,
    private var onStarClick: (message: String) -> Unit
) :
    RecyclerView.Adapter<CreateMessageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MessageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messageList[position]
        holder.showMessage(message)
        holder.binding.icFavorite.setOnClickListener {
            onStarClick(message)
        }
    }

    override fun getItemCount() = messageList.size

    fun updateMessageList(newList: MutableList<String>) {
        messageList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: MessageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun showMessage(message: String) {
            binding.tvMessageBody.text = message
        }
    }
}
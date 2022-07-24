package br.com.zup.minhamusicafavorita.ui.viewpager.album.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.minhamusicafavorita.databinding.AlbumItemBinding
import br.com.zup.minhamusicafavorita.domain.model.Album

class AlbumAdapter(
    private var listaAlbum: MutableList<Album>,
    private val clickAlbum: (album: Album) -> Unit,
) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AlbumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = listaAlbum[position]
        holder.exibirAlbunsView(album)
        holder.binding.cvItem.setOnClickListener {
            clickAlbum(album)
        }
    }

    override fun getItemCount() = listaAlbum.size

    fun atualizarListaAlbum(novaLista: MutableList<Album>) {
        listaAlbum = novaLista
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: AlbumItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun exibirAlbunsView(album: Album) {
            binding.imgFotoItem.setImageResource(album.imagem)
        }
    }
}
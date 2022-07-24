package br.com.zup.minhamusicafavorita.ui.albumDetails.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.zup.minhamusicafavorita.*
import br.com.zup.minhamusicafavorita.databinding.FragmentAlbumDetailsBinding
import br.com.zup.minhamusicafavorita.domain.model.Album
import br.com.zup.minhamusicafavorita.ui.viewpager.view.ViewPagerActivity

class AlbumDetailsFragment : Fragment() {
    private lateinit var binding: FragmentAlbumDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as ViewPagerActivity).supportActionBar?.title = getString(R.string.detalhe_do_Album)
        recuperarAlbum()
        exibirMensagemFavoritar()
    }

    private fun recuperarAlbum() {
        val album = arguments?.getParcelable<Album>(ALBUM_KEY)
        if (album != null) {
            exibirInformacoes(album)
        }
    }

    private fun exibirInformacoes(album: Album) {
        binding.imgAlbum.setImageResource(album.imagem)
        binding.tvNomeAlbum.text = album.nomeAlbum
        binding.tvDetalheAlbum.text = album.descricaoAlbum
        binding.tvCantora.text = TEXT_ARTISTA + album.artista
        binding.tvLancamento.text = TEXT_LANCAMENTO + album.lancamento.toString()
        binding.tvGravadora.text = TEXT_GRAVADORA + album.gravadora
        binding.tvEstudio.text = TEXT_ESTUDIO + album.estudio
        binding.tvFormato.text = TEXT_FORMATO + album.formato
        binding.tvGenero.text = TEXT_GENERO + album.genero
    }

    private fun exibirMensagemFavoritar(){
        binding.imCoracao.setOnClickListener {
            Toast.makeText(context, FAVORITADO, Toast.LENGTH_LONG).show()
        }
    }
}
import br.com.zup.minhamusicafavorita.data.datasource.local.dao.AlbumDAO
import br.com.zup.minhamusicafavorita.domain.model.Album

class AlbumRepository(private val albumDao: AlbumDAO) {

    suspend fun insertAlbumsDB(listAlbum: List<Album>) {
//        val listAlbums = createListAlbum()
        albumDao.insertAlbumsDB(listAlbum)
    }

    suspend fun getAllAlbums(): List<Album> = albumDao.getAllAlbums()

   /* fun createListAlbum(): List<Album> {
        val listAlbum = mutableListOf<Album>()
        listAlbum.add(
            Album(
                imagem = ALBUM1_IMAGEM,
                nomeAlbum = ALBUM1_NOME_ALBUM,
                descricaoAlbum = ALBUM1_DESCICAO_ALBUM,
                artista = ALBUM1_ARTISTA,
                lancamento = ALBUM1_LANCAMENTO,
                gravadora = ALBUM1_GRAVADORA,
                estudio = ALBUM1_ESTUDIO,
                formato = ALBUM1_FORMATO,
                genero = ALBUM1_GENERO
            )
        )
        listAlbum.add(
            Album(
                imagem = ALBUM2_IMAGEM,
                nomeAlbum = ALBUM2_NOME_ALBUM,
                descricaoAlbum = ALBUM2_DESCICAO_ALBUM,
                artista = ALBUM2_ARTISTA,
                lancamento = ALBUM2_LANCAMENTO,
                gravadora = ALBUM2_GRAVADORA,
                estudio = ALBUM2_ESTUDIO,
                formato = ALBUM2_FORMATO,
                genero = ALBUM2_GENERO
            )
        )
        listAlbum.add(
            Album(
                imagem = ALBUM3_IMAGEM,
                nomeAlbum = ALBUM3_NOME_ALBUM,
                descricaoAlbum = ALBUM3_DESCICAO_ALBUM,
                artista = ALBUM3_ARTISTA,
                lancamento = ALBUM3_LANCAMENTO,
                gravadora = ALBUM3_GRAVADORA,
                estudio = ALBUM3_ESTUDIO,
                formato = ALBUM3_FORMATO,
                genero = ALBUM3_GENERO
            )
        )
        listAlbum.add(
            Album(
                imagem = ALBUM4_IMAGEM,
                nomeAlbum = ALBUM4_NOME_ALBUM,
                descricaoAlbum = ALBUM4_DESCICAO_ALBUM,
                artista = ALBUM4_ARTISTA,
                lancamento = ALBUM4_LANCAMENTO,
                gravadora = ALBUM4_GRAVADORA,
                estudio = ALBUM4_ESTUDIO,
                formato = ALBUM4_FORMATO,
                genero = ALBUM4_GENERO
            )
        )
        listAlbum.add(
            Album(
                imagem = ALBUM5_IMAGEM,
                nomeAlbum = ALBUM5_NOME_ALBUM,
                descricaoAlbum = ALBUM5_DESCICAO_ALBUM,
                artista = ALBUM5_ARTISTA,
                lancamento = ALBUM5_LANCAMENTO,
                gravadora = ALBUM5_GRAVADORA,
                estudio = ALBUM5_ESTUDIO,
                formato = ALBUM5_FORMATO,
                genero = ALBUM5_GENERO
            )
        )
        listAlbum.add(
            Album(
                imagem = ALBUM6_IMAGEM,
                nomeAlbum = ALBUM6_NOME_ALBUM,
                descricaoAlbum = ALBUM6_DESCICAO_ALBUM,
                artista = ALBUM6_ARTISTA,
                lancamento = ALBUM6_LANCAMENTO,
                gravadora = ALBUM6_GRAVADORA,
                estudio = ALBUM6_ESTUDIO,
                formato = ALBUM6_FORMATO,
                genero = ALBUM6_GENERO
            )
        )
        listAlbum.add(
            Album(
                imagem = ALBUM7_IMAGEM,
                nomeAlbum = ALBUM7_NOME_ALBUM,
                descricaoAlbum = ALBUM7_DESCICAO_ALBUM,
                artista = ALBUM7_ARTISTA,
                lancamento = ALBUM7_LANCAMENTO,
                gravadora = ALBUM7_GRAVADORA,
                estudio = ALBUM7_ESTUDIO,
                formato = ALBUM7_FORMATO,
                genero = ALBUM7_GENERO
            )
        )
        listAlbum.add(
            Album(
                imagem = ALBUM8_IMAGEM,
                nomeAlbum = ALBUM8_NOME_ALBUM,
                descricaoAlbum = ALBUM8_DESCICAO_ALBUM,
                artista = ALBUM8_ARTISTA,
                lancamento = ALBUM8_LANCAMENTO,
                gravadora = ALBUM8_GRAVADORA,
                estudio = ALBUM8_ESTUDIO,
                formato = ALBUM8_FORMATO,
                genero = ALBUM8_GENERO
            )
        )
        listAlbum.add(
            Album(
                imagem = ALBUM9_IMAGEM,
                nomeAlbum = ALBUM9_NOME_ALBUM,
                descricaoAlbum = ALBUM9_DESCICAO_ALBUM,
                artista = ALBUM9_ARTISTA,
                lancamento = ALBUM9_LANCAMENTO,
                gravadora = ALBUM9_GRAVADORA,
                estudio = ALBUM9_ESTUDIO,
                formato = ALBUM9_FORMATO,
                genero = ALBUM9_GENERO
            )
        )
        return listAlbum
    }

    */
}
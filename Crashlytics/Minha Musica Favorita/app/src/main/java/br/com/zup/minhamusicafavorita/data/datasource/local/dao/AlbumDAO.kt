package br.com.zup.minhamusicafavorita.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zup.minhamusicafavorita.*
import br.com.zup.minhamusicafavorita.domain.model.Album

@Dao
interface AlbumDAO {
    @Query("SELECT * FROM albuns ORDER BY lancamento ASC")
    fun getAllAlbums(): List<Album>

    @Query("SELECT * FROM albuns WHERE album =:albumTitle")
    fun getAlbumTitle(albumTitle: String): Album

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAlbumsDB(listAbums : List<Album>)
}
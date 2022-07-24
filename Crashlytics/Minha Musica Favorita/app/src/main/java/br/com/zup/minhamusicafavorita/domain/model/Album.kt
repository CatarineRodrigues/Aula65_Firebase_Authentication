package br.com.zup.minhamusicafavorita.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "albuns")
data class Album(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cod_album")
    var codAlbum: Long = 1,

    @ColumnInfo(name = "imagem")
    var imagem: Int,

    @ColumnInfo(name = "album")
    var nomeAlbum: String,

    @ColumnInfo(name = "descricao")
    var descricaoAlbum: String,

    @ColumnInfo(name = "artista")
    var artista: String,

    @ColumnInfo(name = "lancamento")
    var lancamento: Int,

    @ColumnInfo(name = "gravadora")
    var gravadora: String,

    @ColumnInfo(name = "estudio")
    var estudio: String,

    @ColumnInfo(name = "formato")
    var formato: String,

    @ColumnInfo(name = "genero")
    var genero: String,

    @ColumnInfo(name = "favoritado")
    var isFavorite: Boolean = false

) : Parcelable
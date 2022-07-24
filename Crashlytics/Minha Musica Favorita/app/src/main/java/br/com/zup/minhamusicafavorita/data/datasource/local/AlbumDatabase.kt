package br.com.zup.minhamusicafavorita.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.zup.minhamusicafavorita.data.datasource.local.dao.AlbumDAO
import br.com.zup.minhamusicafavorita.domain.model.Album

@Database(entities = [Album::class], version = 3)
abstract class AlbumDatabase: RoomDatabase() {
    abstract fun albumDao(): AlbumDAO

    companion object {
        @Volatile
        private var INSTANCE: AlbumDatabase? = null

        fun getDatabase(context: Context): AlbumDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AlbumDatabase::class.java,
                    "album_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
package at.fh.swengb.voetter.homeexercise2

import android.arch.persistence.room.*
import android.content.Context


@Database(entities = [(NoteEntity::class)], version = 1)
abstract class NoteRoomDatabase: RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        fun getDatabase(context: Context): NoteRoomDatabase {
            return Room.databaseBuilder(context,NoteRoomDatabase::class.java,"NoteDB")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}

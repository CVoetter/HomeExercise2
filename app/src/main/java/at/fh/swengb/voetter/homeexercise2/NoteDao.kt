package at.fh.swengb.voetter.homeexercise2

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: NoteEntity)

    @Query("select * from Notes")
    fun select(): List<NoteEntity>

    @Query("delete from Notes")
    fun delete()

}

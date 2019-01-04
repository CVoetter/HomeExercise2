package at.fh.swengb.voetter.homeexercise2

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Notes")
class NoteEntity (

    @PrimaryKey
    val titleNote: String,

    val contentNote: String

)
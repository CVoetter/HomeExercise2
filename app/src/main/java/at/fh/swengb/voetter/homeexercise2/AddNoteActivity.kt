package at.fh.swengb.voetter.homeexercise2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    lateinit var db: NoteRoomDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        db = NoteRoomDatabase.getDatabase(this)
    }

    open fun dbEntry(v: View) {

        val titleN = title_add.text.toString()
        val contentN = content_add.text.toString()
        val note = NoteEntity(titleN,contentN)

        db.noteDao.insertNote(note)
        db.noteDao.select()

        Log.i("NoteApp", "Entry in database")

        finish()

    }

}









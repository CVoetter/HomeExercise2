package at.fh.swengb.voetter.homeexercise2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {


    private val noteAdapter = NoteAdapter()
    private val notes = mutableListOf<NoteEntity>()

    lateinit var db: NoteRoomDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        recyclerV.adapter = noteAdapter
        recyclerV.layoutManager = LinearLayoutManager(this)

        db = NoteRoomDatabase.getDatabase(this)

        recyclerV.adapter = noteAdapter
        recyclerV.layoutManager = LinearLayoutManager(this)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val savedName = sharedPreferences.getString("name","Name")
        val savedAge = sharedPreferences.getInt("age",-1)

        var headline = findViewById(R.id.textList) as TextView

        headline.text = "Notes for ${savedName}, ${savedAge}"

    }

    override fun onResume() {
        super.onResume()
        db.noteDao.select()
        noteAdapter.updateList(db.noteDao.select())
    }


    fun delete(v: View)  {
        db.noteDao.delete()
        noteAdapter.updateList(db.noteDao.select())
    }

    fun add(v: View)   {

        Log.i("NoteApp", "New Entry")

        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)
    }



}

package at.fh.swengb.voetter.homeexercise2


import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun save(v: View) {

        val sharedPref = getSharedPreferences(packageName, Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString("name", name_main.text.toString())
            putInt("age", age_main.text.toString().toInt())
            commit()
        }

        Log.i("NoteApp", "Name and age are saved")

        val intent = Intent(this, NoteListActivity::class.java)
        startActivity(intent)
    }
}
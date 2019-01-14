package at.fh.swengb.voetter.homeexercise2


import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_id.setOnClickListener {

            if (name_main.text.isNullOrEmpty() == true || age_main.text.isNullOrEmpty() == true) {
                Log.i("NoteApp", "empty textView")
                // Set a click listener for button widget

                // Initialize a new layout inflater instance
                val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                // Inflate a custom view using layout inflater
                val view = inflater.inflate(R.layout.another_view, null)

                // Initialize a new instance of popup window
                val popupWindow = PopupWindow(
                    view, // Custom view to show in popup window
                    LinearLayout.LayoutParams.WRAP_CONTENT, // Width of popup window
                    LinearLayout.LayoutParams.WRAP_CONTENT // Window height
                )

                // Set an elevation for the popup window
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    popupWindow.elevation = 10.0F
                }


                // Get the widgets reference from custom view
                val tv = view.findViewById<TextView>(R.id.text_view)
                val buttonPopup = view.findViewById<Button>(R.id.button_popup)


                // Set a click listener for popup's button widget
                buttonPopup.setOnClickListener {
                    // Dismiss the popup window
                    popupWindow.dismiss()
                }

                // Set a dismiss listener for popup window
                popupWindow.setOnDismissListener {
                    Toast.makeText(applicationContext, "Popup closed", Toast.LENGTH_SHORT).show()
                }


                // Finally, show the popup window on app
                TransitionManager.beginDelayedTransition(root_layout)
                popupWindow.showAtLocation(
                    root_layout, // Location to display popup window
                    Gravity.CENTER, // Exact position of layout to display popup
                    0, // X offset
                    0 // Y offset
                )
            }


            else {
                val sharedPref = getSharedPreferences(packageName, Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("name", name_main.text.toString())
                    putInt("age", age_main.text.toString().toInt())
                    commit()
                    Log.i("NoteApp", "Name and age are saved")
                }
                Log.i("NoteApp", "start NoteListActivity")

                val intent = Intent(this, NoteListActivity::class.java)
                startActivity(intent)
            }
        }

    }
}

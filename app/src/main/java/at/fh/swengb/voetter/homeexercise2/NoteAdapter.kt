package at.fh.swengb.voetter.homeexercise2


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdapter(): RecyclerView.Adapter<NoteViewHolder>() {

    var list = listOf<NoteEntity>()

    fun updateList(newList: List<NoteEntity>) {
        list = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val noteItemView = inflater.inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(noteItemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: NoteViewHolder, position: Int) {
        val noteA = list[position]
        viewHolder.bindItem(noteA)
    }
}



class NoteViewHolder(myView: View): RecyclerView.ViewHolder(myView) {
    fun bindItem(note: NoteEntity) {
        itemView.view_title.text = note.titleNote
        itemView.view_content.text = note.contentNote
    }
}
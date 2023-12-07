package values

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alomapp.alom.R

class MemberAdapter(val itemList: ArrayList<Members>) :
        RecyclerView.Adapter<MemberAdapter.MemberViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.attendance_list, parent, false)
        return MemberViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        holder.name.text = itemList[position].name
        holder.major.text = itemList[position].major
        holder.studentID.text = itemList[position].studentID
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val major = itemView.findViewById<TextView>(R.id.major)
        val studentID = itemView.findViewById<TextView>(R.id.studentID)
        val name = itemView.findViewById<TextView>(R.id.name)
    }
}
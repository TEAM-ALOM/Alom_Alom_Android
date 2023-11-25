import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alomapp.alom.R
import com.alomapp.alom.ui.members.data.ExecutiveMember

class ExecutiveAdapter(private val executiveList: List<ExecutiveMember>) :
    RecyclerView.Adapter<ExecutiveAdapter.ExecutiveViewHolder>() {

    inner class ExecutiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mentorImageView: ImageView = itemView.findViewById(R.id.mentorImageView)
        val mentorIntroView: TextView = itemView.findViewById(R.id.mentorIntroView)
        val mentorNameView: TextView = itemView.findViewById(R.id.mentorNameView)
        val mentorSpecView: TextView = itemView.findViewById(R.id.mentorSpecView)
        val mentorTeamView: TextView = itemView.findViewById(R.id.mentorTeamView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExecutiveViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.mentor, parent, false)
        return ExecutiveViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ExecutiveViewHolder, position: Int) {
        val currentItem = executiveList[position]

        // currentItem에서 데이터를 가져와서 ViewHolder에 설정
        holder.mentorImageView.setImageResource(R.drawable.member) // 멘토 이미지 설정
        holder.mentorIntroView.text = currentItem.introduction // 멘토 소개말 설정
        holder.mentorNameView.text = "${currentItem.studentID} ${currentItem.name}" // 학번 및 이름 설정
        holder.mentorSpecView.text = currentItem.role // 역할 설정
        holder.mentorTeamView.text = "Team: ${currentItem.team}" // 소속팀 설정
    }

    override fun getItemCount(): Int {
        return executiveList.size
    }
}

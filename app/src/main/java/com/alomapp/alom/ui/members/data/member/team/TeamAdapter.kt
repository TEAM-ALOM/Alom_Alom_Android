package com.alomapp.alom.ui.members.data.member.team
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alomapp.alom.R

class TeamAdapter(private var teamList: List<Team>) :
    RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val teamNameView: TextView = itemView.findViewById(R.id.teamNameView)
        val memberNameView: TextView = itemView.findViewById(R.id.memberNameView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.team, parent, false)
        return TeamViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val currentItem = teamList[position]
        // currentItem에서 데이터를 가져와서 ViewHolder에 설정
        holder.teamNameView.text = currentItem.teamName //팀 이름 설정
        holder.memberNameView.text = currentItem.memberName//멤버 이름 설정
    }

    override fun getItemCount(): Int {
        return teamList.size
    }
    // 외부에서 팀 리스트를 설정하기 위한 메서드 추가
    @SuppressLint("NotifyDataSetChanged")
    fun setTeamList(newList: List<Team>) {
        teamList = newList
        notifyDataSetChanged()
    }
}

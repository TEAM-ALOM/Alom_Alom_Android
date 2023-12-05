package com.alomapp.alom.ui.members.data.member

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alomapp.alom.R
import com.alomapp.alom.ui.members.data.member.team.Team
import com.alomapp.alom.ui.members.data.member.team.TeamAdapter

class MemberAdapter(private val memberList: List<Member>) :
    RecyclerView.Adapter<MemberAdapter.MemberViewHolder>() {

    inner class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val teamRecyclerView: RecyclerView = itemView.findViewById(R.id.teamrv)
        val stackNameView:TextView=itemView.findViewById(R.id.stackView)
        val teamAdapter: TeamAdapter = TeamAdapter(emptyList()) // 팀 어댑터 초기화

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.member, parent, false) // member_item.xml 또는 원하는 레이아웃으로 수정
        return MemberViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        val currentItem = memberList[position]
        holder.stackNameView.text = currentItem.stackName // 팀 이름 설정

        // 팀 어댑터에 데이터 설정
        holder.teamAdapter.setTeamList(currentItem.team)
        holder.teamRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = holder.teamAdapter
        }

    }

    override fun getItemCount(): Int {
        return memberList.size
    }
}

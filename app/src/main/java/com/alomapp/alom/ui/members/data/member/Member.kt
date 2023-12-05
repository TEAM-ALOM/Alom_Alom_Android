package com.alomapp.alom.ui.members.data.member

import android.text.Layout
import android.widget.ListAdapter
import com.alomapp.alom.ui.members.data.member.team.Team

data class Member (
    val stackName:String,
    val team: List<Team>
)
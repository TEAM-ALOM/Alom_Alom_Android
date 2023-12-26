package com.alomapp.alom.server

import com.alomapp.alom.ui.members.data.executivemember.ExecutiveMember
import com.alomapp.alom.ui.members.data.member.Member
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    // 새로운 메소드들 추가
    @GET("api/executiveMembers") // 임원진 데이터를 가져오는 엔드포인트 URL
    fun getExecutiveMembers(): Call<List<ExecutiveMember>> // ExecutiveMember 리스트를 받아옴

    @GET("api/members") // 멤버 데이터를 가져오는 엔드포인트 URL
    fun getMembers(): Call<List<Member>> // Member 리스트를 받아옴
}

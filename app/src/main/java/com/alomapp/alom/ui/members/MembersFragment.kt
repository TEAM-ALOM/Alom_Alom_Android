package com.alomapp.alom.ui.members

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alomapp.alom.databinding.FragmentMemberBinding
import com.alomapp.alom.server.ApiClient
import com.alomapp.alom.server.ApiService
import com.alomapp.alom.ui.members.data.executivemember.ExecutiveAdapter
import com.alomapp.alom.ui.members.data.executivemember.ExecutiveMember
import com.alomapp.alom.ui.members.data.executivemember.ExecutiveViewModel
import com.alomapp.alom.ui.members.data.member.Member
import com.alomapp.alom.ui.members.data.member.MemberAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MembersFragment : Fragment() {
    private var _binding: FragmentMemberBinding? = null
    private val executiveList = mutableListOf<ExecutiveMember>() // 임원진 데이터 리스트
    private val memberList = mutableListOf<Member>()
    private val binding get() = _binding!!
    private lateinit var apiService: ApiService // Retrofit 인터페이스 변수 선언
    private lateinit var mentorAdapter: ExecutiveAdapter
    private lateinit var memberAdapter: MemberAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val membersViewModel = ViewModelProvider(this).get(ExecutiveViewModel::class.java)
        _binding = FragmentMemberBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Retrofit 객체 생성
        apiService = ApiClient.getClient().create(ApiService::class.java)

        // 리사이클러뷰 설정
        setupRecyclerViews()

        // 서버에서 데이터를 가져와 리사이클러뷰에 설정하는 함수 호출
        fetchDataAndUpdateRecyclerViews()

        return root
    }

    private fun setupRecyclerViews() {
        // Mentor RecyclerView 설정
        val mentorRecyclerView: RecyclerView = binding.mentorRv
        mentorRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mentorAdapter = ExecutiveAdapter(executiveList)
        mentorRecyclerView.adapter = mentorAdapter

        // Member RecyclerView 설정
        val memberRecyclerView: RecyclerView = binding.memberRv
        memberRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        memberAdapter = MemberAdapter(memberList)
        memberRecyclerView.adapter = memberAdapter
    }

    private fun fetchDataAndUpdateRecyclerViews() {
        // 서버에서 임원진 데이터 가져오기
        val mentorDataCall = apiService.getExecutiveMembers() // ApiService에서 정의한 메소드 사용 (GET 방식)
        mentorDataCall.enqueue(object : Callback<List<ExecutiveMember>> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<List<ExecutiveMember>>, response: Response<List<ExecutiveMember>>) {
                if (response.isSuccessful) {
                    val mentorData: List<ExecutiveMember>? = response.body()
                    mentorData?.let {
                        executiveList.clear()
                        executiveList.addAll(it)
                        mentorAdapter.notifyDataSetChanged()
                    }
                } else {
                    // 요청은 성공했지만 응답이 실패한 경우 처리
                    Log.e("MemberFragment","Fail to get response")

                }
            }

            override fun onFailure(call: Call<List<ExecutiveMember>>, t: Throwable) {
                // 요청 실패에 대한 처리
                Log.e("MemberFragment","Cannot connect to server")

            }
        })

        // 서버에서 멤버 데이터 가져오기
        val memberDataCall = apiService.getMembers() // ApiService에서 정의한 메소드 사용 (GET 방식)
        memberDataCall.enqueue(object : Callback<List<Member>> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<List<Member>>, response: Response<List<Member>>) {
                if (response.isSuccessful) {
                    val memberData: List<Member>? = response.body()
                    memberData?.let {
                        memberList.clear()
                        memberList.addAll(it)
                        memberAdapter.notifyDataSetChanged()
                    }
                } else {
                    Log.e("MemberFragment","Fail to get response")
                    // 요청은 성공했지만 응답이 실패한 경우 처리
                }
            }

            override fun onFailure(call: Call<List<Member>>, t: Throwable) {
                Log.e("MemberFragment","Cannot connect to server")
                // 요청 실패에 대한 처리
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

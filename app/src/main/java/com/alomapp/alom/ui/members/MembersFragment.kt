    package com.alomapp.alom.ui.members

    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.fragment.app.Fragment
    import androidx.lifecycle.ViewModelProvider
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.alomapp.alom.databinding.FragmentMemberBinding
    import com.alomapp.alom.ui.members.data.executivemember.ExecutiveAdapter
    import com.alomapp.alom.ui.members.data.executivemember.ExecutiveMember
    import com.alomapp.alom.ui.members.data.executivemember.ExecutiveViewModel
    import com.alomapp.alom.ui.members.data.member.Member
    import com.alomapp.alom.ui.members.data.member.MemberAdapter
    import com.alomapp.alom.ui.members.data.member.team.Team

    class MembersFragment : Fragment() {

        private var _binding: FragmentMemberBinding? = null
        private val executiveList = mutableListOf<ExecutiveMember>() // 임원진 데이터 리스트
        private val memberList= mutableListOf<Member>()
        private val binding get() = _binding!!

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            val membersViewModel =
                ViewModelProvider(this).get(ExecutiveViewModel::class.java)

            _binding = FragmentMemberBinding.inflate(inflater, container, false)
            val root: View = binding.root
            addExecutiveMembers()
            addMember()
            val mentorRecyclerView: RecyclerView = binding.mentorRv
            mentorRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val mentorAdaptor = ExecutiveAdapter(executiveList)
            mentorRecyclerView.adapter = mentorAdaptor
            mentorRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {//가운데 항목 강조 메소드
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager?
                    layoutManager?.let {
                        val firstVisibleItemPosition = it.findFirstVisibleItemPosition()
                        val lastVisibleItemPosition = it.findLastVisibleItemPosition()

                        // 화면에 보이는 아이템 중 가운데에 위치한 아이템 인덱스 계산
                        val centerItemPosition = (firstVisibleItemPosition + lastVisibleItemPosition) / 2

                        // 각 아이템에 대한 크기 조절
                        for (i in firstVisibleItemPosition..lastVisibleItemPosition) {
                            val itemView = it.findViewByPosition(i)
                            if (itemView != null) {
                                if (i == centerItemPosition) {
                                    // 화면 상 가운데에 위치한 아이템 크기를 크게 설정
                                    itemView.scaleX = 1f
                                    itemView.scaleY = 1f
                                } else {
                                    // 다른 아이템들은 기본 크기로 설정
                                    itemView.scaleX = 0.7f
                                    itemView.scaleY = 0.7f
                                }
                            }
                        }
                    }
                }
            })
            val memberRecyclerView: RecyclerView = binding.memberRv
            memberRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val memberAdaptor = MemberAdapter(memberList)
            memberRecyclerView.adapter = memberAdaptor
            memberRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {//가운데 항목 강조 메소드
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager?
                layoutManager?.let {
                    val firstVisibleItemPosition = it.findFirstVisibleItemPosition()
                    val lastVisibleItemPosition = it.findLastVisibleItemPosition()

                    // 화면에 보이는 아이템 중 가운데에 위치한 아이템 인덱스 계산
                    val centerItemPosition = (firstVisibleItemPosition + lastVisibleItemPosition) / 2

                    // 각 아이템에 대한 크기 조절
                    for (i in firstVisibleItemPosition..lastVisibleItemPosition) {
                        val itemView = it.findViewByPosition(i)
                        if (itemView != null) {
                            if (i == centerItemPosition) {
                                // 화면 상 가운데에 위치한 아이템 크기를 크게 설정
                                itemView.scaleX = 1f
                                itemView.scaleY = 1f
                            } else {
                                // 다른 아이템들은 기본 크기로 설정
                                itemView.scaleX = 0.7f
                                itemView.scaleY = 0.7f
                            }
                        }
                    }
                }
            }
            })
            return root
        }


        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
        private fun addExecutiveMembers() {
            // 임원진 데이터 추가
            executiveList.add(ExecutiveMember("라이언", "안드로이드 멘토", "안녕하세용", "18", "Alom"))
            executiveList.add(ExecutiveMember("춘식이", "서버 멘토", "헬로~", "22", "Mola"))
            executiveList.add(ExecutiveMember("뿡뿡이", "IOS 멘토", "하이!!", "20", "Zero"))
            executiveList.add(ExecutiveMember("뽀로로", "플러터 멘토", "놀자~~", "12", "OG"))
            executiveList.add(ExecutiveMember("짱구", "회장", "정기 모임 공지", "18", "ZZang"))
        }
        private fun addMember() {
            val teamList = mutableListOf<Team>()
            for (i in 1..5){
                val teamName = "${i}조"
                val teamMembers = "${i*5} 신짱구  ${i*5-2} 최자두 ${i*4} 퉁퉁이 ${i*5-4} 정재현 ${i*5-3} 이민형 ${i*4+2} 나재민 ${i*3} 춘식이" // 여기에 해당 팀의 멤버 정보 입력
                val team = Team(teamName, teamMembers)
                teamList.add(team)
            }

            // 각 팀을 해당하는 스택명으로 Member 객체에 추가
            val androidMember = Member("Android", teamList)
            val iosMember = Member("IOS", teamList)
            val serverMember = Member("Server", teamList)
            val flutterMember = Member("Flutter", teamList)

            // 각 Member 객체를 리스트에 추가
            memberList.add(androidMember)
            memberList.add(iosMember)
            memberList.add(serverMember)
            memberList.add(flutterMember)
        }

    }
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
    import com.alomapp.alom.ui.members.data.member.team.Team

    class MembersFragment : Fragment() {

        private var _binding: FragmentMemberBinding? = null
        private val executiveList = mutableListOf<ExecutiveMember>() // 임원진 데이터 리스트
        private val teamList= mutableListOf<Team>()//멤버 데이터 리스트
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
            val recyclerView: RecyclerView = binding.mentorRv
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)


            val adapter = ExecutiveAdapter(executiveList)
            recyclerView.adapter = adapter

            /*val textView: TextView = binding.mentorRv
            membersViewModel.text.observe(viewLifecycleOwner) {
                textView.text = it
            }*/
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

            val Team1=Team("1조", "19 신짱구  20 최자두 20 퉁퉁이 21 정재현 21 이민형 21 나재민 22 춘식이")
            val Team2=Team("2조", "19 신짱구  20 최자두 20 퉁퉁이 21 정재현 21 이민형 21 나재민 22 춘식이")
            val Team3=Team("3조", "19 신짱구  20 최자두 20 퉁퉁이 21 정재현 21 이민형 21 나재민 22 춘식이")
            val Team4=Team("4조", "19 신짱구  20 최자두 20 퉁퉁이 21 정재현 21 이민형 21 나재민 22 춘식이")
            val Team5=Team("5조", "19 신짱구  20 최자두 20 퉁퉁이 21 정재현 21 이민형 21 나재민 22 춘식이")

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
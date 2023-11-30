    package com.alomapp.alom.ui.members

    import ExecutiveAdapter
    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.fragment.app.Fragment
    import androidx.lifecycle.ViewModelProvider
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.alomapp.alom.databinding.FragmentMemberBinding
    import com.alomapp.alom.ui.members.data.ExecutiveMember
    import com.alomapp.alom.ui.members.data.ExecutiveViewModel

    class MembersFragment : Fragment() {

        private var _binding: FragmentMemberBinding? = null
        private val executiveList = mutableListOf<ExecutiveMember>() // 임원진 데이터 리스트
        // This property is only valid between onCreateView and
        // onDestroyView.
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
        }
    }
package com.alomapp.alom.ui.announcement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.alomapp.alom.databinding.FragmentAnnouncementBinding

class AnnouncementFragment : Fragment() {

    private var _binding: FragmentAnnouncementBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val announcementViewModel =
            ViewModelProvider(this).get(AnnouncementViewModel::class.java)

        _binding = FragmentAnnouncementBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textView
        announcementViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
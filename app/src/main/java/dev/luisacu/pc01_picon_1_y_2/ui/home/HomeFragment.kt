package dev.luisacu.pc01_picon_1_y_2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.luisacu.pc01_picon_1_y_2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var listViewTeams: ListView

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        listViewTeams = binding.listViewTeams
        val teams = arrayOf(
            "FC Barcelona",
            "Real Madrid",
            "Manchester United",
            "Bayern Munich",
            "Paris Saint-Germain",
            "Juventus",
            "Liverpool",
            "Chelsea",
            "Manchester City",
            "Arsenal"
        )

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, teams)
        listViewTeams.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

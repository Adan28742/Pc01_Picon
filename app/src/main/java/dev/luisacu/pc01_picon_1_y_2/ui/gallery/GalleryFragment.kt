package dev.luisacu.pc01_picon_1_y_2.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.luisacu.pc01_picon_1_y_2.PlayersAdapter
import dev.luisacu.pc01_picon_1_y_2.R
import dev.luisacu.pc01_picon_1_y_2.Player
import dev.luisacu.pc01_picon_1_y_2.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var playersAdapter: PlayersAdapter

    // Lista de jugadores de ejemplo
    private val players = listOf(
        Player(R.drawable.player1, "Lionel Messi", 1987),
        Player(R.drawable.player2, "Cristiano Ronaldo", 1985),
        Player(R.drawable.player3, "Neymar Jr.", 1992)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configuración del RecyclerView
        recyclerView = binding.recyclerViewPlayers
        playersAdapter = PlayersAdapter(players)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = playersAdapter

        // Observando el texto del ViewModel (opcional)
        galleryViewModel.text.observe(viewLifecycleOwner) { text ->
            binding.textGallery.text = text
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

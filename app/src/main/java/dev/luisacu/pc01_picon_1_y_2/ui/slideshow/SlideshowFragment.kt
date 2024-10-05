package dev.luisacu.pc01_picon_1_y_2.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.luisacu.pc01_picon_1_y_2.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Inicializar elementos del layout
        val inputKilometers: EditText = binding.inputKilometers
        val inputMinutes: EditText = binding.inputMinutes
        val buttonCalculate: Button = binding.buttonCalculate
        val textResult: TextView = binding.textResult

        // Manejar el clic del botón
        buttonCalculate.setOnClickListener {
            calculatePerformance(inputKilometers, inputMinutes, textResult)
        }

        return root
    }

    private fun calculatePerformance(inputKilometers: EditText, inputMinutes: EditText, textResult: TextView) {
        val kilometers = inputKilometers.text.toString().toDoubleOrNull() ?: 0.0
        val minutes = inputMinutes.text.toString().toDoubleOrNull() ?: 1.0 // Para evitar división por cero

        if (minutes > 0) {
            val performance = kilometers / minutes
            textResult.text = "Rendimiento físico: ${String.format("%.2f", performance)} km/min"
        } else {
            textResult.text = "Por favor ingresa minutos válidos."
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

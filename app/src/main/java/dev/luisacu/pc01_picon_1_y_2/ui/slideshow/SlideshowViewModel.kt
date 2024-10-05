package dev.luisacu.pc01_picon_1_y_2.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Rendimiento"
    }
    val text: LiveData<String> = _text
}
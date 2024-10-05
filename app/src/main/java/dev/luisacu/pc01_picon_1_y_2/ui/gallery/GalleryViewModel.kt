package dev.luisacu.pc01_picon_1_y_2.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "PLAYERS"
    }
    val text: LiveData<String> = _text
}
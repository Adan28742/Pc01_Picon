package dev.luisacu.pc01_picon_1_y_2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Equipos"
    }
    val text: LiveData<String> = _text
}
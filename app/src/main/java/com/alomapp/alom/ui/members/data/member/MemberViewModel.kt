package com.alomapp.alom.ui.members.data.member

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MemberViewModel {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}
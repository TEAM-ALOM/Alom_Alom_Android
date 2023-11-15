package com.alomapp.alom.ui.announcement

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnnouncementViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "공지사항 작성하기"
    }
    val text: LiveData<String> = _text
}
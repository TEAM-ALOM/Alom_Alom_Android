package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private  lateinit var noticeRecyclerView: RecyclerView
    private  lateinit var noticeArray: ArrayList<Notice>
    lateinit var title:Array<String>
    lateinit var text:Array<String>
    lateinit var date:Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title= arrayOf(
            "[2학기 정기 모임 활동 재안내]",
            "[2학기 정기 모임 활동 재안내]",
            "[2학기 정기 모임 활동 재안내]",
            "[2학기 정기 모임 활동 재안내]",
            "[2학기 정기 모임 활동 재안내]",
            "[2학기 정기 모임 활동 재안내]",
            "[2학기 정기 모임 활동 재안내]",
            "[2학기 정기 모임 활동 재안내]",
            "[2학기 정기 모임 활동 재안내]",
            "[2학기 정기 모임 활동 재안내]"
        )
        text= arrayOf(
            "26일 당일 활동을 취소합니다. 아직 시험이 끝나지 않은 분들이 많아 2학기 정기 모임 재시작은 11월달부터로 하겠습니다!",
            "27일 당일 활동을 취소합니다. 아직 시험이 끝나지 않은 분들이 많아 2학기 정기 모임 재시작은 11월달부터로 하겠습니다!",
            "28일 당일 활동을 취소합니다. 아직 시험이 끝나지 않은 분들이 많아 2학기 정기 모임 재시작은 11월달부터로 하겠습니다!",
            "29일 당일 활동을 취소합니다. 아직 시험이 끝나지 않은 분들이 많아 2학기 정기 모임 재시작은 11월달부터로 하겠습니다!",
            "30일 당일 활동을 취소합니다. 아직 시험이 끝나지 않은 분들이 많아 2학기 정기 모임 재시작은 11월달부터로 하겠습니다!",
            "1일 당일 활동을 취소합니다. 아직 시험이 끝나지 않은 분들이 많아 2학기 정기 모임 재시작은 12월달부터로 하겠습니다!",
            "2일 당일 활동을 취소합니다. 아직 시험이 끝나지 않은 분들이 많아 2학기 정기 모임 재시작은 12월달부터로 하겠습니다!",
            "3일 당일 활동을 취소합니다. 아직 시험이 끝나지 않은 분들이 많아 2학기 정기 모임 재시작은 12월달부터로 하겠습니다!",
            "4일 당일 활동을 취소합니다. 아직 시험이 끝나지 않은 분들이 많아 2학기 정기 모임 재시작은 12월달부터로 하겠습니다!",
            "5일 당일 활동을 취소합니다. 아직 시험이 끝나지 않은 분들이 많아 2학기 정기 모임 재시작은 12월달부터로 하겠습니다!"
        )
        date= arrayOf(
            "23.11.16", "23.11.17", "23.11.18", "23.11.19", "23.11.20", "23.11.21", "23.11.22", "23.11.23", "23.11.24", "23.11.25"
        )
        noticeRecyclerView=findViewById(R.id.recyclerView)
        noticeRecyclerView.layoutManager=LinearLayoutManager(this)
        noticeRecyclerView.setHasFixedSize(true)

        noticeArray= arrayListOf<Notice>()
        getUserdata()
    }

    private fun getUserdata() {
        for(i in title.indices){

            val notice=Notice(title[i],text[i], date[i])
            noticeArray.add(notice)
        }
        noticeRecyclerView.adapter = MyAdapter(noticeArray.toTypedArray())
    }
}
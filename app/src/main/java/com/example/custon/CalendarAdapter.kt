package com.example.custon

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi

import androidx.recyclerview.widget.RecyclerView
import com.example.custon.CalendarAdapter.CalendarViewHolder
import java.util.*
import kotlin.collections.ArrayList
var buf_view: View? = null
class Calendar(){
    var buf_view2: View? = buf_view
}
class CalendarAdapter(private val dayList: ArrayList<String>, private val onItemListener: OnItemListener) :
        RecyclerView.Adapter<CalendarViewHolder>() {
    var check = 0
    var text: String? = null
    var viewsList= ArrayList<View>()
    var buff2 = 0
    var a = 0
    var dot : Boolean = true
    fun a(): View? {
        return buf_view
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.calendar_cell, parent, false)
        viewsList.add(view)
        return CalendarViewHolder(view)
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        val day = dayList[position]
        val yearmothday = yearmothday()
        yearmothday.setDay(day)
        //토일 색상 변경
        holder.dayText.text = day
        if (position == 11) {
        }
        if ((position + 1) % 7 == 0) {
            holder.dayText.setTextColor(Color.parseColor("#FF6E6E"))
        } else if (position == 0 || position % 7 == 0) {
            holder.dayText.setTextColor(Color.parseColor("#FF6E6E"))
        }
        //날짜 클릭 이벤트
        holder.itemView.setOnClickListener {
            onItemListener.onItemClick(day)
            //색깔 변경 추가
            if (check == 0) {
                holder.parentView.setBackgroundResource(R.drawable.edge_blue)
                check = 1
                buff2 = position;
                buf_view = viewsList.get(buff2)
            } else if (check == 1) {
                viewsList[buff2].setBackgroundResource(R.drawable.edge_white)
                //arrList.get(buff2+1).clear();
                //arrList.get(buff2-1).clear();
                //arrList.get(buff2).getMsg().setBackgroundResource(R.drawable.edge_white);
                //view1[0].setBackgroundResource(R.drawable.edge_white);
                holder.parentView.setBackgroundResource(R.drawable.edge_blue)
                check = 1
                buff2 = position;
                buf_view = viewsList.get(buff2)
                //viewsList.get(text!!.toInt()).findViewById(R.id.todo1).setVisibility(View.VISIBLE)
            }
        }
    }

    //viewsList를 공유하던가 추가 버튼후에 아래 명령어가 실행되게 신호를 주는 방법을 알아봐야함!!!!!!!!
    object MyJavaClass {
        fun area(text: String) {
            var text = text
            text = text
        }
    }

    override fun getItemCount(): Int {
        return dayList.size
    }

    inner class CalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var dayText: TextView
        var parentView: View

        init {
            dayText = itemView.findViewById(R.id.dayText)
            parentView = itemView.findViewById(R.id.parentView)
        }
    }
}
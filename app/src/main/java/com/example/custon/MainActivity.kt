package com.example.custon

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_add.*
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.*

var input : String =""
val java = yearmothday()
class Main(){
    var input2 : String?= input
}
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), OnItemListener {
    lateinit var buff_view : View
    //일시적 담는 데이터
    // 일정추가
    var readDay: String? = null
    var str: String? = null
    var text : String = ""
    var calendarView: CalendarView? = null

    //기본일정 코딩
    var monthYearText: TextView? = null

    //클릭 일정데이터 저장
    var year : String = ""
    var month : String = ""
    var day : Int = 0

    //LocalDate selectedDate;
    var recyclerView: RecyclerView? = null
    var selectedDate: LocalDate? = null
    lateinit var dayText : View
    fun createimage() : View {
        val image = ImageView(this)
        image.setImageResource(R.drawable.rectangle)
        val lp = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
        image.layoutParams = lp
        image.id = ViewCompat.generateViewId()
        return image
    }
    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_calendar_body)

        //추가
        var test = findViewById<LinearLayout>(R.id.parentView)

        //초기화
        monthYearText = findViewById(R.id.monthYearText)
        recyclerView = findViewById(R.id.recyclerView)
        selectedDate = LocalDate.now()
        setMonthView()

        //plus 버튼 클릭시 다른 창으로 이동
        val plusBtn = findViewById<ImageButton>(R.id.plus_btn)

        //
        var intent = Intent(this, SlideLeftActivity::class.java)
        plusBtn.setOnClickListener{
            //팝업
            val dialog = CustomDialog(this)
            // Custom Dialog 표시
            dialog.showDialog()

            //startActivity(intent)
        }
    }
   @RequiresApi(Build.VERSION_CODES.O)
    override fun onItemClick(dayText: String) {
        var yearMonday = yearMonthFromDate(selectedDate) + "" + dayText + "일"

        //날짜 저장
        input = yearMonday
        //이벤트
        Toast.makeText(this, yearMonday, Toast.LENGTH_SHORT).show()

    }
/*    fun createbtn() : View {
        val image = ImageView(this)
        image.setImageResource(R.drawable.check_round)
        val lp = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        image.layoutParams= lp
        image.id=ViewCompat.generateViewId()
        return image
    }*/

    @RequiresApi(api = Build.VERSION_CODES.O)
    private fun monthYearFromDate(date: LocalDate?): String {
        val formatter = DateTimeFormatter.ofPattern("MM월 yyyy")
        return date!!.format(formatter)
    }

    //날짜 타입 설정 메서드
    @RequiresApi(api = Build.VERSION_CODES.O)
    private fun yearMonthFromDate(date: LocalDate?): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy년 MM월")
        return date!!.format(formatter)
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    override fun setMonthView() {
        monthYearText!!.text = monthYearFromDate(selectedDate)
        val dayList = daysInMonthArray(selectedDate)
        val adapter = CalendarAdapter(dayList, this@MainActivity)
        val manager: RecyclerView.LayoutManager = GridLayoutManager(applicationContext, 7)
        recyclerView!!.layoutManager = manager
        recyclerView!!.adapter = adapter
    }

    override fun Bool(bool: Boolean): Boolean {
        TODO()
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private fun daysInMonthArray(date: LocalDate?): ArrayList<String> {
        val dayList = ArrayList<String>()
        val yearMonth = YearMonth.from(date)
        val lastDay = yearMonth.lengthOfMonth()
        val firstDay = selectedDate!!.withDayOfMonth(1)
        val dayOfWeek = firstDay.dayOfWeek.value
        for (i in 1..41) {
            if (i <= dayOfWeek || i > lastDay + dayOfWeek) {
                dayList.add("")
            } else {
                dayList.add((i - dayOfWeek).toString())
            }
        }
        return dayList
    }
    internal class Position_day {
        var Day: String? = null
        fun setday(day: String?) {
            Day = day
        }

        fun getday(): String? {
            return Day
        }
    }

}
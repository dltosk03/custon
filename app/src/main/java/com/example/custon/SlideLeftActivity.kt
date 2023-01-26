package com.example.custon

//import RecyclerAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.custon.CalendarAdapter


class SlideLeftActivity : AppCompatActivity() {
    /*private var adapter: RecyclerAdapter? = null
    private val p: Paint = Paint()*/

/*    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_add)

        //
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val rv_view = findViewById<RecyclerView>(R.id.rv_view)

        //클릭된 날짜로 변경
        var intent = intent
        val text = Main().input2
        if (text != null) {
            java.setYear(text.substring(0 until 4))
            java.setMonth(text.substring(6 until 8))
            java.setDay(text.substring(9 until 11))
        }
        if (text != null) {
            java.setMonth(text.substring(6 until 8))
        }
*//*        fun createbtn() : View {
            val image = ImageView(this)
            image.setImageResource(R.drawable.check_round)
            val lp = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            image.layoutParams= lp
            image.id= ViewCompat.generateViewId()
            return image
        }*//*
        intent = Intent(this, MainActivity::class.java)
        val click_day = findViewById<TextView>(R.id.click_day)
        click_day.setText(java.getYear() + "." + java.getMonth() + "." + java.getDay())
        //버튼 클릭시todo layout 추가
        var button = findViewById<Button>(R.id.todo_add_btn)
        var out_button = findViewById<ImageButton>(R.id.todo_out_btn)
        val todo_body_layout = findViewById<LinearLayout>(R.id.todo_body_layout)
        button.setOnClickListener {
            //todo_body_layout.addView(createimage())

            //클릭후 dot 추가
            //viewsList.get(text!!.toInt()).findViewById(R.id.todo1).setVisibility(View.VISIBLE)
            startActivity(intent)

        }
        //다시
        out_button.setOnClickListener {
            startActivity(intent)
        }
    }
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
    }*/
}


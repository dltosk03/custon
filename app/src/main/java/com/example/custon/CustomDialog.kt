package com.example.custon

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_calendar_body.*
import kotlinx.android.synthetic.main.todo_add.*


class CustomDialog(context: Context): AppCompatActivity() {
    private lateinit var onItemListener : OnItemListener
    private lateinit var binding: CustomDialog
    private val dialog = Dialog(context)
    private lateinit var onClickListener: OnDialogClickListener

 /*   fun createimage() : View {
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

    fun setOnClickListener(listener: OnDialogClickListener)
    {
        onClickListener = listener
    }

    fun showDialog()
    {

        //클릭된 날짜로 변경
        val text = Main().input2
        if (text != null) {
            java.setYear(text.substring(0 until 4))
            java.setMonth(text.substring(6 until 8))
            java.setDay(text.substring(9 until 11))
        }
        if (text != null) {
            java.setMonth(text.substring(6 until 8))
        }

        dialog.setContentView(R.layout.todo_add)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )

        // Custom Dialog 위치 조절
        dialog.window?.setGravity(Gravity.BOTTOM)
        // Custom Dialog 배경 설정 (다음과 같이 진행해야 좌우 여백 없이 그려짐)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //클릭 날짜로 텍스트 변경
        dialog.click_day.setText(java.getYear() + "." + java.getMonth() + "." + java.getDay())
        dialog.show()

        dialog.todo_out_btn.setOnClickListener{
            //창 닫기
            dialog.dismiss()
        }
        dialog.todo_add_btn.setOnClickListener {
            Calendar().buf_view2?.findViewById<ImageView>(R.id.todo1)?.setVisibility(View.VISIBLE)
            //todo_body_layout.addView(createimage())
            dialog.dismiss()
        }
        dialog.color_red.setOnClickListener {
            Calendar().buf_view2?.findViewById<ImageView>(R.id.todo1)?.setBackgroundResource(R.drawable.check_round)
        }
        dialog.color_orange.setOnClickListener {
            Calendar().buf_view2?.findViewById<ImageView>(R.id.todo1)?.setBackgroundResource(R.drawable.check_round_orange)
        }
        dialog.color_blue.setOnClickListener {
            Calendar().buf_view2?.findViewById<ImageView>(R.id.todo1)?.setBackgroundResource(R.drawable.check_round_blue)
        }
        dialog.color_blue_purple.setOnClickListener {
            Calendar().buf_view2?.findViewById<ImageView>(R.id.todo1)?.setBackgroundResource(R.drawable.check_round_bluepurple)
        }
        dialog.color_green.setOnClickListener {
            Calendar().buf_view2?.findViewById<ImageView>(R.id.todo1)?.setBackgroundResource(R.drawable.check_round_green)
        }
        dialog.color_pink.setOnClickListener {
            Calendar().buf_view2?.findViewById<ImageView>(R.id.todo1)?.setBackgroundResource(R.drawable.check_round_pink)
        }
        dialog.color_purple.setOnClickListener {
            Calendar().buf_view2?.findViewById<ImageView>(R.id.todo1)?.setBackgroundResource(R.drawable.check_round_purple)
        }
        dialog.color_yello.setOnClickListener {
            Calendar().buf_view2?.findViewById<ImageView>(R.id.todo1)?.setBackgroundResource(R.drawable.check_round_yello)
        }

    }

    interface OnDialogClickListener
    {
        fun onClicked(name: String)
    }
}
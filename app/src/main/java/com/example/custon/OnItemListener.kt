package com.example.custon

import android.view.View

interface OnItemListener {
    fun onItemClick(dayText: String)
    fun setMonthView()
/*    fun Check(view: View)
    fun Final_Check()*/
    fun Bool(bool: Boolean): Boolean
}
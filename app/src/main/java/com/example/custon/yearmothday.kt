package com.example.custon

import android.view.View

class yearmothday {
    private var year: String? = null
    private var month: String? = null
    private var day: String? = null
    var Check_view : View? = null
    fun getCheckview() : View? {
        return Check_view
    }
    fun getDay(): String? {
        return day
    }

    fun getYear(): String? {
        return year
    }

    fun getMonth(): String? {
        return month
    }

    fun setDay(day: String?) {
        this.day = day
    }

    fun setMonth(month: String?) {
        this.month = month
    }

    fun setYear(year: String?) {
        this.year = year
    }
}
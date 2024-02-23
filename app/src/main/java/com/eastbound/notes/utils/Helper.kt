package com.eastbound.notes.utils

import android.content.Context
import android.widget.Toast
import com.eastbound.notes.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.Random

object Helper {

    fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault())
        val date = Date()

        return dateFormat.format(date)
    }

    fun showMessage(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun randomColor(): Int {
        val colorList = listOf(
            R.color.pastel_blue,
            R.color.pastel_green,
            R.color.pastel_blue,
            R.color.pastel_brown,
            R.color.pastel_tosca,
            R.color.pastel_purple,
            R.color.pastel_peach,
            R.color.pastel_red,
            R.color.pastel_pink,
            R.color.pastel_soft_green,
            R.color.pastel_dark_tosca
        )

        val randomIndex = Random().nextInt(colorList.size)
        return colorList[randomIndex]
    }

}
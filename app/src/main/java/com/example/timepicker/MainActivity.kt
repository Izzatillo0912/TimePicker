package com.example.timepicker

import android.app.TimePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var setListener : TimePickerDialog.OnTimeSetListener
    private val calendar = Calendar.getInstance()
    private var hour = 0
    private var minute = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun easyTimePicker(view: View) {

        val timePickerDialog = TimePickerDialog(this,android.R.style.Theme_Holo_Dialog_MinWidth,
            TimePickerDialog.OnTimeSetListener(object : TimePickerDialog.OnTimeSetListener,
                (TimePicker, Int, Int) -> Unit {
            override fun onTimeSet(p0: TimePicker?, hour1: Int, minute1: Int) {
            }
            override fun invoke(p1: TimePicker, hour1: Int, minute1: Int) {
                calendar.set(0,0,0,hour1,minute1)
                val time = "$hour1:$minute1"
                val f24Hours = SimpleDateFormat("HH:mm")
                try {
                    val date = f24Hours.parse(time)
                    val f12Hours = SimpleDateFormat("HH:mm")
                    easy_view.text = f12Hours.format(date)
                }catch (e : ExceptionInInitializerError) {}
            }
        }),12,0,true)
        timePickerDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        timePickerDialog.show()
    }
    fun mediumTimePicker(view: View) {

        val timePickerDialog = TimePickerDialog(this,
            TimePickerDialog.OnTimeSetListener(object : TimePickerDialog.OnTimeSetListener,
            (TimePicker, Int, Int) -> Unit {
                override fun onTimeSet(p0: TimePicker?, hour1: Int, minute1: Int) {
                }
                override fun invoke(p1: TimePicker, hour1: Int, minute1: Int) {
                    calendar.set(0,0,0,hour1,minute1)
                    val time = "$hour1:$minute1"
                    val f24Hours = SimpleDateFormat("HH:mm")
                    try {
                        val date = f24Hours.parse(time)
                        val f12Hours = SimpleDateFormat("HH:mm")
                        medium_view.text = f12Hours.format(date)
                    }catch (e : ExceptionInInitializerError) {}
                }
            }),12,0,true)
        timePickerDialog.show()

    }
}
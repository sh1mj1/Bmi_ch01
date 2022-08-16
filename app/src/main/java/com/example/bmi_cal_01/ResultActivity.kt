package com.example.bmi_cal_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity", "height: $height, weight: $weight")
        val bmi = weight / (height / 100.0).pow(2.0)  // double 로 치환을 해주어야 함. 기본적으로 Int 형을 Float 나 double 로 나누면 자동으로 실수형으로 치환이 된다.
        val resultText = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }
        val resultNumTv = findViewById<TextView>(R.id.bmi_result_num_Tv)
        val resultStrTv = findViewById<TextView>(R.id.bmi_result_str_Tv)

        resultNumTv.text = bmi.toString()
        resultStrTv.text = resultText
    }

}
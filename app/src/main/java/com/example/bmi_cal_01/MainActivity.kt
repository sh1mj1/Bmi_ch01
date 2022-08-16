package com.example.bmi_cal_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEt: EditText = findViewById(R.id.height_Et)
        val weightEt = findViewById<EditText>(R.id.weight_Et) // Type을 변수 뒤에 적거나 혹은 findViewById 뒤 <> 에 넣어야 한다.
        val resultBtn = findViewById<Button>(R.id.check_Btn)

//        resultBtn.setOnClickListener() // 이건 인터페이스를 만들어주어야 한다.

        resultBtn.setOnClickListener {
            if (heightEt.text.isEmpty() || weightEt.text.isEmpty()){
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val height: Int = heightEt.text.toString().toInt()
            val weight: Int = weightEt.text.toString().toInt()
            Log.d("MainActivity", "ResultBtn Clicked, height: $height, weight: $weight")

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)

        }

    }

}
package com.example.module10_bodymassindex

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var heightInputET: EditText
    private lateinit var weightInputET: EditText

    private lateinit var calculateBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heightInputET = findViewById(R.id.heightInputET)
        weightInputET = findViewById(R.id.weightInputET)

        calculateBTN = findViewById(R.id.calculateBTN)
        calculateBTN.setOnClickListener {
            if (heightInputET.text.isNotEmpty() && weightInputET.text.isNotEmpty()) {
                val height = heightInputET.text.toString().toInt()
                val weight = weightInputET.text.toString().toInt()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("height", height)
                intent.putExtra("weight", weight)
                startActivity(intent)
            } else {
                if (heightInputET.text.isEmpty()) heightInputET.error = "Введите значение"
                if (weightInputET.text.isEmpty()) weightInputET.error = "Введите значение"
            }

        }
    }
}
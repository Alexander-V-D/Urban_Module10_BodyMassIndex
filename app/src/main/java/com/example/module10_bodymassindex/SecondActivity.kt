package com.example.module10_bodymassindex

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import java.util.Locale
import kotlin.math.pow

class SecondActivity : AppCompatActivity() {

    private lateinit var indexTV: TextView
    private lateinit var bodyWeightIV: ImageView
    private lateinit var infoTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        indexTV = findViewById(R.id.indexTV)
        bodyWeightIV = findViewById(R.id.bodyWeightIV)
        infoTV = findViewById(R.id.infoTV)

        val height = intent.getIntExtra("height", 180)
        val weight = intent.getIntExtra("weight", 80)

        val index = weight / (height.toDouble().pow(2)) * 10_000

        indexTV.text = String.format(Locale.US,"%.2f", index)
        when {
            index < 18.5 -> {
                bodyWeightIV.setImageDrawable(
                    AppCompatResources.getDrawable(applicationContext, R.drawable.thin))
                infoTV.text = getString(R.string.thin_text)
            }
            index in 18.5..24.9 -> {
                bodyWeightIV.setImageDrawable(
                    AppCompatResources.getDrawable(applicationContext, R.drawable.normal))
                infoTV.text = getString(R.string.normal_text)
            }
            index > 24.9 -> {
                bodyWeightIV.setImageDrawable(
                    AppCompatResources.getDrawable(applicationContext, R.drawable.fat))
                infoTV.text = getString(R.string.fat_text)
            }
        }
    }
}
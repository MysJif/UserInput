package com.example.user_input

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.core.view.get
import org.w3c.dom.Text
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalc = findViewById<Button>(R.id.idCalcBtn)
        val mealCost = findViewById<TextView>(R.id.idMealCost)
        val mealTotal = findViewById<TextView>(R.id.idMealTotal)
        val tipSpin = findViewById<Spinner>(R.id.idTipSpin)
        val dollarFormat = DecimalFormat("$#,###.00")

        var mealPrice: Double
        var spinPos: Int
        var totalCost: Double

        fun calculate(price: Double, tipPos: Int): Double {
            var tipPer: Double = 0.0
            var result: Double
            when(tipPos) {
                0->{
                    tipPer = .05
                }
                1->{
                    tipPer = .1
                }
                2->{
                    tipPer = .15
                }
                3->{
                    tipPer = .2
                }
                4->{
                    tipPer = .25
                }
            }
            result = price + (price*tipPer)
            return result
        }

        btnCalc.setOnClickListener {
            mealPrice = mealCost.text.toString().toDouble()
            spinPos = tipSpin.selectedItemPosition
            mealTotal.text = dollarFormat.format(calculate(mealPrice, spinPos))
        }
    }
}

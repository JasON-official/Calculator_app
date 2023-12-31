package com.example.calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.ezylang.evalex.Expression

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Find the buttons and TextView
        val zeroButton = findViewById<Button>(R.id.zero_button)
        val oneButton = findViewById<Button>(R.id.one_button)
        val twoButton = findViewById<Button>(R.id.two_button)
        val threeButton = findViewById<Button>(R.id.three_button)
        val fourButton = findViewById<Button>(R.id.four_button)
        val fiveButton = findViewById<Button>(R.id.five_button)
        val sixButton = findViewById<Button>(R.id.six_button)
        val sevenButton = findViewById<Button>(R.id.seven_button)
        val eightButton = findViewById<Button>(R.id.eight_button)
        val nineButton = findViewById<Button>(R.id.nine_button)

        val equalButton = findViewById<Button>(R.id.equal_button)
        val plusButton = findViewById<Button>(R.id.plus_button)
        val minusButton = findViewById<Button>(R.id.minus_button)
        val multiplyButton = findViewById<Button>(R.id.multiply_button)
        val divideButton = findViewById<Button>(R.id.divide_button)
        val pointButton = findViewById<Button>(R.id.point_button)
        val clearButton = findViewById<Button>(R.id.clear_button)
        val resetButton = findViewById<Button>(R.id.reset_button)

        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        //Initialize StringBuilder
        val numberStringBuilder = StringBuilder()

        //Initialization of button listeners from 0 to 9
        zeroButton.setOnClickListener {
            numberStringBuilder.append(0)

            resultTextView.text = numberStringBuilder
        }

        oneButton.setOnClickListener {
            numberStringBuilder.append(1)

            resultTextView.text = numberStringBuilder
        }

        twoButton.setOnClickListener {
            numberStringBuilder.append(2)

            resultTextView.text = numberStringBuilder
        }

        threeButton.setOnClickListener {
            numberStringBuilder.append(3)

            resultTextView.text = numberStringBuilder
        }

        fourButton.setOnClickListener {
            numberStringBuilder.append(4)

            resultTextView.text = numberStringBuilder
        }

        fiveButton.setOnClickListener {
            numberStringBuilder.append(5)

            resultTextView.text = numberStringBuilder
        }

        sixButton.setOnClickListener {
            numberStringBuilder.append(6)

            resultTextView.text = numberStringBuilder
        }

        sevenButton.setOnClickListener {
            numberStringBuilder.append(7)

            resultTextView.text = numberStringBuilder
        }

        eightButton.setOnClickListener {
            numberStringBuilder.append(8)

            resultTextView.text = numberStringBuilder
        }

        nineButton.setOnClickListener {
            numberStringBuilder.append(9)

            resultTextView.text = numberStringBuilder
        }

        pointButton.setOnClickListener {
            numberStringBuilder.append(".")

            resultTextView.text = numberStringBuilder
        }

        plusButton.setOnClickListener {
            numberStringBuilder.append("+")

            resultTextView.text = numberStringBuilder
        }

        minusButton.setOnClickListener {
            numberStringBuilder.append("-")

            resultTextView.text = numberStringBuilder
        }

        multiplyButton.setOnClickListener {
            numberStringBuilder.append("*")

            resultTextView.text = numberStringBuilder
        }

        divideButton.setOnClickListener {
            numberStringBuilder.append("/")

            resultTextView.text = numberStringBuilder
        }

        equalButton.setOnClickListener {
            try {

                val stringExpression = numberStringBuilder.toString()
                val expression = Expression(stringExpression)
                val expressionResult = expression.evaluate().numberValue
                resultTextView.text = expressionResult.toString()

                numberStringBuilder.clear()
                numberStringBuilder.append(expressionResult.toString())

            } catch (t: Throwable) {
                Toast.makeText(this@MainActivity, "Exception $t", Toast.LENGTH_LONG)
                    .show()
            }

        }

        clearButton.setOnClickListener {
            resultTextView.text = "0"
            numberStringBuilder.clear()
        }

        resetButton.setOnClickListener {
            val lastIndex = numberStringBuilder.length - 1
            numberStringBuilder.deleteCharAt(lastIndex)
            resultTextView.text = numberStringBuilder
        }
    }
}
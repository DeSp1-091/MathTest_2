package com.example.pr_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat
import com.example.pr_8.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        return (start..end).random()
    }

    fun randomChar(chars: String): Char {
        return chars[Random.nextInt(chars.length)]
    }

    public var a = 0
    public var b = 0
    public var c = " "
    public var x = 0
    public var y = 0
    public var z = 0
    public var sum = 0
    public var sumTrue = 0

    fun btnClickStart(view: View){
        var start = 10
        var end = 99
        val chars = "+-*/"
        var d = 0

        a = rand(start, end)
        b = rand(start, end)
        c = randomChar(chars).toString()
        if (c == "/")
        {
            do {
                do {
                    a = rand(start, end)
                    b = rand(start, end)
                } while ((a % 2 != 0 || b % 2 != 0) && a == b)
                if (a < b) {
                    val a2 = b
                    val b2 = a
                    a = a2
                    b = b2
                }
            }while(a % b != 0)
        }

        when(c){
            "+" -> sum = a + b
            "-" -> sum = a - b
            "*" -> sum = a * b
            "/" -> sum = a / b
        }

        start = 1
        end = 2
        d = rand(start, end)
        if(d == 1)
        {
            binding.textSUMTF.text = sum.toString()
        }
        else
        {
            var sumFalse = 0
            start = 10
            end = 99
            var a1 = rand(start, end)
            var b1 = rand(start, end)
            when(c){
                "+" -> sumFalse = a1 + b1
                "-" -> sumFalse = a1 - b1
                "*" -> sumFalse = a1 * b1
                "/" -> sumFalse = a1 / b1
            }
            binding.textSUMTF.text = sumFalse.toString()
        }
        binding.textNum1.text = a.toString()
        binding.textNum2.text = b.toString()
        binding.textZn.text = c

    }

    fun btnClickCheckTrue(view: View){
        var p = 0.00
        if (sum == sumTrue)
        {
            x += 1
            z +=1
            binding.textTRUE.text = x.toString()
            binding.textITOG.text = z.toString()
        }
        else
        {
            y += 1
            z +=1
            binding.textFALSE.text = y.toString()
            binding.textITOG.text = z.toString()
        }
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        p = ((x.toDouble() / z.toDouble()))
        val p1 = df.format(p * 100)
        binding.textPROCENT.text = p1.toString()
    }

    fun btnClickCheckFalse(view: View){
        var p = 0.00
        if (sum != sumTrue)
        {
            x += 1
            z +=1
            binding.textTRUE.text = x.toString()
            binding.textITOG.text = z.toString()
        }
        else
        {
            y += 1
            z +=1
            binding.textFALSE.text = y.toString()
            binding.textITOG.text = z.toString()
        }
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        p = ((x.toDouble() / z.toDouble()))
        val p1 = df.format(p * 100)
        binding.textPROCENT.text = p1.toString()
    }

}
package com.showtyclef.btcngnconverter

import android.os.Bundle
import android.widget.Toast
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import com.showtyclef.btcngnconverter.databinding.ActivityMainBinding
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.ceil
import kotlin.math.round
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            convert()
        }
    }

    private fun convert() {
        val input = binding.inputNGN.text.toString().toDoubleOrNull()

        if (input.toString().isNotEmpty()) {

            if (input == null || input == 0.0) {
                display(0.0)
                return
            }
            else{

            var result = (input / 18633335.55)

            if (binding.roundUp.isChecked) {
                result = Math.ceil(result)

            } else {
                val result2 = result
                result = BigDecimal(result2).setScale(2, RoundingMode.HALF_EVEN).toDouble()
            }
                display(result)
            }
        }
        else {
            Toast.makeText(
                this, "Field cannot be blank:|", Toast.LENGTH_LONG
            ).show()
        }
    }

private fun display (result: Double) {
    val printResult = "$result"
    binding.result.text = getString(R.string.result, printResult)
}
}



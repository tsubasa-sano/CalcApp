package jp.techacademy.tsubasa.sano.calcapp

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import java.lang.Exception

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        try {
            val text1: String = editText1.text.toString()
            val num1: Double = text1.toDouble()

            val text2: String = editText2.text.toString()
            val num2: Double = text2.toDouble()

            val plus = num1 + num2
            val minus = num1 - num2
            val times = num1 * num2
            val divide = num1 / num2

            var value: Double = 0.0

            when (v.id) {
                R.id.button1 -> value = plus.toDouble()
                R.id.button2 -> value = minus.toDouble()
                R.id.button3 -> value = times.toDouble()
                R.id.button4 -> value = divide.toDouble()
            }

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("VALUE", value)
            startActivity(intent)

        } catch (value : Exception) {
            Snackbar.make(v, "数値を入力してください", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}

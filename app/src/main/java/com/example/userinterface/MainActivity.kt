package com.example.userinterface

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        bCalculate.setOnClickListener {


            if (d1.isChecked == false && d2.isChecked == false && d3.isChecked == false && d4.isChecked == false && d5.isChecked == false) {
                Toast.makeText(this, "กรุณาเลือกกิจกรรม", Toast.LENGTH_SHORT).show()
            } else if (radioWomen.isChecked == false && radioMen.isChecked == false) {
                Toast.makeText(this, "กรุณาเลือกเพศ", Toast.LENGTH_SHORT).show()
            } else if (Heightt.text.toString() == "" || Agee.text.toString() == "" || Weightt.text.toString() == "") {
                Toast.makeText(this, "กรุณาใส่ข้อมูลให้ถูกต้อง", Toast.LENGTH_SHORT).show()
            } else {
                var txt1 = Weightt.text.toString().toDouble()
                var txt2 = (Heightt.text.toString().toDouble() * 0.01)
                var txt3 = (txt1.toDouble() / Math.pow(txt2.toDouble(), 2.0))
                var txt4 = Agee.text.toString().toDouble()

                var m: Double = 0.0
                var n = 0.0
                if (radioMen.isChecked) {
                    m = (66 + (13.7 * Weightt.text.toString()
                        .toDouble()) + (5 * Heightt.text.toString().toDouble()) - (6.8 * txt4))
                } else if (radioWomen.isChecked) {
                    m = (665 + (9.6 * Weightt.text.toString()
                        .toDouble()) + (1.8 * Heightt.text.toString().toDouble()) - (4.7 * txt4))
                }

                if (d1.isChecked) {
                    n = (m.toDouble() * 1.2)
                } else if (d2.isChecked) {
                    n = (m.toDouble() * 1.375)
                } else if (d3.isChecked) {
                    n = (m.toDouble() * 1.55)
                } else if (d4.isChecked) {
                    n = (m.toDouble() * 1.725)
                } else if (d5.isChecked) {
                    n = (m.toDouble() * 1.9)
                }

                val i = Intent(this, MainActivity2::class.java)
                i.putExtra("txt1", txt3.toString())
                i.putExtra("txt2", m.toInt().toString())
                i.putExtra("txt3", n.toInt().toString())
                startActivity(i)


            }

        }


        bClear2.setOnClickListener {
            RDG.clearCheck()
            radioGroup.clearCheck()
            Weightt.text.clear()
            Heightt.text.clear()
            Agee.text.clear()
        }

    }


}
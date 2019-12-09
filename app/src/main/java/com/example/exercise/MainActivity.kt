package com.example.exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
        //dont want intial anything then put lateinit
    lateinit var myData: PremiumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData = ViewModelProviders.of(this).get(PremiumModel::class.java)

        btnCalculate.setOnClickListener()
        {
            myData.premimAmount = getPremium()
            display()

            //val result:Double = getPremium()
            //ansTotal.text = result.toString()
        }
        btnReset.setOnClickListener()
        {
            spAge.setSelection(0)
            groupGender.clearCheck()
            checkbox_yes.isChecked = false
            myData.premimAmount = 0.0
            //ansTotal.text = ""
        }
    }
    fun display() {
        ansTotal.text = myData.premimAmount.toString()
    }


    fun getPremium():Double{

        return when(spAge.selectedItemPosition) {
            0 -> 60.00
            1 -> 70.00 +
                    (if(btnMale.isChecked) 50.00 else 0.0) +
                    (if (checkbox_yes.isChecked) 100.00 else 0.0)
            2 -> 90.00 +
                    (if(btnMale.isChecked) 100.00 else 0.0) +
                    (if (checkbox_yes.isChecked) 150.00 else 0.0)
            3 -> 120.00 +
                    (if (btnMale.isChecked) 150.00 else 0.0) +
                    (if (checkbox_yes.isChecked) 200.00 else 0.0)
            4 -> 150.00 +
                    (if(btnMale.isChecked) 200.00 else 0.0) +
                    (if (checkbox_yes.isChecked) 250.00 else 0.0)
            else -> 150.00 +
                    (if (btnMale.isChecked) 200.00 else 0.0) +
                    (if (checkbox_yes.isChecked) 300.00 else 0.0)

        }
    }
}

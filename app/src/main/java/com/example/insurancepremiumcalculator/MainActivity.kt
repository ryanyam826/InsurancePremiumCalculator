package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

        lateinit var myData: PremiumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCal.setOnClickListener(){
            val totalPremium : Double = getPremium()
            txtTtlPremium.text = totalPremium.toString()
        }
        myData = ViewModelProviders.of(this).get(PremiumModel::class.java)
        display()

        btnReset.setOnClickListener(){
            spinnerAgeRange.setSelection(0)
            chkBxYesNo.isChecked = false
            radioGroupGender.clearCheck()
            txtTtlPremium.text = ""
        }
    }

    fun getPremium():Double{
        return when(spinnerAgeRange.selectedItemPosition){
            0 -> 60.00
            1 -> 90.00 + (if(rdBtnMale.isChecked) 50.00 else 0.0) + (if(chkBxYesNo.isChecked) 100.00 else 0.0)
            2 -> 90.00 + (if(rdBtnMale.isChecked) 100.00 else 0.0) + (if(chkBxYesNo.isChecked) 150.00 else 0.0)
            3 -> 120.00 + (if(rdBtnMale.isChecked) 150.00 else 0.0) + (if(chkBxYesNo.isChecked) 200.00 else 0.0)
            4 -> 150.00 + (if(rdBtnMale.isChecked) 200.00 else 0.0) + (if(chkBxYesNo.isChecked) 250.00 else 0.0)
            else -> 150.00 + (if(rdBtnMale.isChecked) 200.00 else 0.0) + (if(chkBxYesNo.isChecked) 300.00 else 0.0)
        }
    }

    fun display(){
        txtTtlPremium.text = myData.premiumAmount.toString()
    }
}

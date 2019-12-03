package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var spinnerAge: Spinner
    lateinit var radioGroupGender: RadioGroup
    lateinit var radioButtonMale: RadioButton
    lateinit var radioButtonFemale: RadioButton
    lateinit var checkBoxSmoker: CheckBox
    lateinit var textViewPremium: TextView
    lateinit var buttonCalculate: Button
    lateinit var buttonReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerAge = findViewById(R.id.spinnerAge)

        radioGroupGender = findViewById(R.id.radioGroupGender)
        radioButtonMale = findViewById(R.id.radioButtonMale)
        radioButtonFemale = findViewById(R.id.radioButtonFemale)

        checkBoxSmoker = findViewById(R.id.checkBoxSmoker)
        textViewPremium = findViewById(R.id.textViewPremium)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        buttonReset = findViewById(R.id.buttonReset)

        buttonCalculate.setOnClickListener{ calculate() }
        buttonReset.setOnClickListener{ reset() }
    }

    private fun calculate(){
        var mySpinner: String = spinnerAge.getSelectedItem().toString()
        var totalInsurance: Int = 0
        var premiumPrice: Int = 0
        var genderFee: Int = 0
        var smokerFee: Int = 0

        if(mySpinner.equals("Less than 17")) {
            premiumPrice = 60
            genderFee = 0
            smokerFee = 0
        }
        else if(mySpinner.equals("17 to 25")){
            premiumPrice = 70
            if(radioGroupGender.checkedRadioButtonId != -1){
                if(radioButtonMale.isChecked){
                    genderFee = 50
                } else if (radioButtonFemale.isChecked){
                    genderFee = 0
                }
            }
            if(checkBoxSmoker.isChecked){
                smokerFee = 100
            } else {
                smokerFee = 0
            }
        }
        else if(mySpinner.equals("26 to 30")){
            premiumPrice = 90
            if(radioGroupGender.checkedRadioButtonId != -1){
                if(radioButtonMale.isChecked){
                    genderFee = 100
                } else if (radioButtonFemale.isChecked){
                    genderFee = 0
                }
            }
            if(checkBoxSmoker.isChecked){
                smokerFee = 150
            } else {
                smokerFee = 0
            }
        }
        else if(mySpinner.equals("31 to 40")){
            premiumPrice = 120
            if(radioGroupGender.checkedRadioButtonId != -1){
                if(radioButtonMale.isChecked){
                    genderFee = 150
                } else if (radioButtonFemale.isChecked){
                    genderFee = 0
                }
            }
            if(checkBoxSmoker.isChecked){
                smokerFee = 200
            } else {
                smokerFee = 0
            }
        }
        else if(mySpinner.equals("41 to 55")){
            premiumPrice = 150
            if(radioGroupGender.checkedRadioButtonId != -1){
                if(radioButtonMale.isChecked){
                    genderFee = 200
                } else if (radioButtonFemale.isChecked){
                    genderFee = 0
                }
            }
            if(checkBoxSmoker.isChecked){
                smokerFee = 250
            } else {
                smokerFee = 0
            }
        }
        else if(mySpinner.equals("More than 55")){
            premiumPrice = 150
            if(radioGroupGender.checkedRadioButtonId != -1){
                if(radioButtonMale.isChecked){
                    genderFee = 200
                } else if (radioButtonFemale.isChecked){
                    genderFee = 0
                }
            }
            if(checkBoxSmoker.isChecked){
                smokerFee = 300
            } else {
                smokerFee = 0
            }
        }

        totalInsurance = premiumPrice + genderFee + smokerFee
        textViewPremium.text = textViewPremium.text.toString() + " " + totalInsurance.toString()

    }

    private fun reset(){
        spinnerAge.setSelection(0)
        radioGroupGender.clearCheck();
        //radioButtonMale.setChecked(false)
        //radioButtonFemale.setChecked(false)
        checkBoxSmoker.setChecked(false)
    }
}

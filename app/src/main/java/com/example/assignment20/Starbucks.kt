package com.example.assignment20

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment

class Starbucks : DialogFragment(R.layout.starbucks) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var sum: Double = 0.0;
        var extra1: Double = 0.0;
        var extra2: Double = 0.0;
        val StarbucksCoffeeSpinner: Spinner = view.findViewById(R.id.StarbucksCoffeeSpinner)
        var optionsCoffee = arrayOf(
            "White Mocha 5.00$",
            "American Coffee 4.50$",
            "Americano 5.00$",
            "Frappe 3.50$",
            "Hazelnut Coffee 4.50$",
            "Pistachio 5.50$"
        )
        var flag: String = "White Mocha 5.00$"
        StarbucksCoffeeSpinner.adapter = this.activity?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.simple_list_item_1,
                optionsCoffee
            )
        }

        val SBcncl: Button = view.findViewById(R.id.SbCoffeeCancel)
        val SBsbmt: Button = view.findViewById(R.id.SbCoffeeSubmit)
        val cookieRad = view.findViewById<RadioGroup>(R.id.CookieRadio)
        val drinkSizeRad = view.findViewById<RadioGroup>(R.id.SbDrinkSizeRadio)

        SBcncl.setOnClickListener {
            dismiss()
        }
        SBsbmt.setOnClickListener {
            val selectedFries: Int = cookieRad.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedFries)

            if (radioButton.text == "Yes+2.00\$")
                extra1 = 2.0
            if (radioButton.text == "No")
                extra1 = 0.0


            val selectedDrink: Int = drinkSizeRad.checkedRadioButtonId
            val radioButton2 = view.findViewById<RadioButton>(selectedDrink)

            if (radioButton2.text == "Small\$")
                extra2 = 0.0
            if (radioButton2.text == "Medium+1.0\$")
                extra2 = 1.0
            if (radioButton2.text == "Large+1.5\$")
                extra2 = 1.5


            val m1: MainActivity = getActivity() as MainActivity;
            sum = sum + extra1 + extra2
            m1.recieveTotal(sum)
            dismiss()

        }

        StarbucksCoffeeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = optionsCoffee.get(p2).toString()
                if (p2 == 0)
                    sum = 5.0
                if (p2 == 1)
                    sum = 4.5
                if (p2 == 2)
                    sum = 5.0
                if (p2 == 3)
                    sum = 3.5
                if (p2 == 4)
                    sum = 4.5
                if (p2 == 5)
                    sum = 5.5
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                sum = 0.0
                TODO("Not yet implemented")
            }

        }
    }
}
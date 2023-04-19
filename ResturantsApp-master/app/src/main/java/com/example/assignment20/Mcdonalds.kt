package com.example.assignment20

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment

class Mcdonalds : DialogFragment(R.layout.mcdonalds) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var sum: Double = 0.0;
        var extra1: Double = 0.0;
        var extra2: Double = 0.0;
        val BurgerSpinner: Spinner = view.findViewById(R.id.BurgerSpinner)
        var optionsBurger = arrayOf(
            "Big Tasty Beef 5.00$",
            "Big Tasty Chicken 4.50$",
            "Grand Chicken 5.00$",
            "Big Mac 3.50$",
            "Happy Meal 4.50$",
            "Big Mushroom 5.50$"
        )
        var flag: String = "Big Tasty Beef 5.00$"
        BurgerSpinner.adapter = this.activity?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.simple_list_item_1,
                optionsBurger
            )
        }

        val BurgerCncl: Button = view.findViewById(R.id.BurgerCncl)
        val BurgerSbmt: Button = view.findViewById(R.id.BurgerSbmt)
        val FriesRad = view.findViewById<RadioGroup>(R.id.FriesRadio)
        val DrinkRad = view.findViewById<RadioGroup>(R.id.DrinkRadio)

        BurgerCncl.setOnClickListener {
            dismiss()
        }
        BurgerSbmt.setOnClickListener {
            val selectedFries: Int = FriesRad.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedFries)

            if (radioButton.text == "Yes+2.00\$")
                extra1 = 2.0
            if (radioButton.text == "No")
                extra1 = 0.0


            val selectedDrink: Int = DrinkRad.checkedRadioButtonId
            val radioButton2 = view.findViewById<RadioButton>(selectedDrink)

            if (radioButton2.text == "Small+1.0\$")
                extra2 = 1.0
            if (radioButton2.text == "Medium+2.0\$")
                extra2 = 2.0
            if (radioButton2.text == "Large+2.5\$")
                extra2 = 2.5


            val m1: MainActivity = getActivity() as MainActivity;
            sum = sum + extra1 + extra2
            m1.recieveTotal(sum)
            dismiss()

        }

        BurgerSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = optionsBurger.get(p2).toString()
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
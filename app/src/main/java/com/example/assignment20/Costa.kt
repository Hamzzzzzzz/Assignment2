package com.example.assignment20

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment

class Costa : DialogFragment(R.layout.costa) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var sum: Double = 0.0;
        var extra: Double = 0.0;
        val CostaCoffeeSpinner: Spinner = view.findViewById(R.id.CostaCoffeeSpinner)
        var optionsPizza = arrayOf(
            "Cappuccino 5.00 $", "Latte 6.00 $",  "Iced Chocolate 4.50 $", "Romantic Strawberry and cream 6.50 $",
            "Bubbly Mango Frappe 4.80 $", "Flat Mocha 7.00 $"
        )
        var flag: String = "Cappuccino 5.00 $"
        CostaCoffeeSpinner.adapter = this.activity?.let { ArrayAdapter<String>(it,android.R.layout.simple_list_item_1, optionsPizza) }

        val costaCncl: Button = view.findViewById(R.id.CostaCancel)
        val costaSbmt: Button = view.findViewById(R.id.CostaSubmit)
        val sizeRad = view.findViewById<RadioGroup>(R.id.SizeRadio)

        costaCncl.setOnClickListener {
        dismiss()
        }
        costaSbmt.setOnClickListener {
            val selectedSize: Int = sizeRad.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedSize)

            if (radioButton.text == "Medium + 2.0\$")
                extra = 2.0
            if (radioButton.text == "Large + 3.0\$")
                extra = 3.0


            val m1: MainActivity = getActivity() as MainActivity;
            sum = sum + extra
            m1.recieveTotal(sum)
            dismiss()

        }

        CostaCoffeeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = optionsPizza.get(p2).toString()
                if (p2 == 0)
                    sum = 5.0
                if (p2 == 1)
                    sum = 6.0
                if (p2 == 2)
                    sum = 4.5
                if (p2 == 3)
                    sum = 6.5
                if (p2 == 4)
                    sum = 4.8
                if (p2 == 5)
                    sum = 7.0
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                sum = 0.0
                TODO("Not yet implemented")
            }

        }
    }
}



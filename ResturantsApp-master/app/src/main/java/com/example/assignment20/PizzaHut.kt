package com.example.assignment20

import android.app.PendingIntent.getActivity
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

class PizzaHut : DialogFragment(R.layout.hut_pizza) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var sum: Double = 0.0;
        var extra: Double = 0.0;
        val PizzaSpinner: Spinner = view.findViewById(R.id.PizzaSpinner)
        var optionsPizza = arrayOf(
            "Pepperoni 5.00 $", "Alfredo 6.00 $", "BBQ 4.50 $", "Zinger 6.50 $",
            "Margareta 4.80 $", "Shrimp 7.00 $"
        )
        var flag: String = "Pepperoni 5.00 $"
        PizzaSpinner.adapter = this.activity?.let { ArrayAdapter<String>(it,android.R.layout.simple_list_item_1, optionsPizza) }

        val pizzaCncl: Button = view.findViewById(R.id.PizzaCancel)
        val pizzaSbmt: Button = view.findViewById(R.id.PizzaSubmit)
        val sizeRad = view.findViewById<RadioGroup>(R.id.SizeRadio)

        pizzaCncl.setOnClickListener {
        dismiss()
        }
        pizzaSbmt.setOnClickListener {
            val selectedSize: Int = sizeRad.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedSize)

            if (radioButton.text == "Large+3.5\$")
                extra = 3.5
            if (radioButton.text == "Medium+2.0\$")
                extra = 2.0


            val m1: MainActivity = getActivity() as MainActivity;
            sum = sum + extra
            m1.recieveTotal(sum)
            dismiss()

        }

        PizzaSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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



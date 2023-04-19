package com.example.assignment20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val confirm: Button = findViewById(R.id.cnfrm)
        val reset: Button = findViewById(R.id.rst)
        val txt: TextView = findViewById(R.id.totalTV)

        confirm.setOnClickListener {
            if(txt.text == "0")
                Toast.makeText(this,"Must Select Items First! ", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Order Confirmed Successfuly with total of " + txt.text, Toast.LENGTH_SHORT).show()
        }

        reset.setOnClickListener {
            txt.text = "0"
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var dialog_var = Costa()
        var dialog_var2 = Starbucks()

        when(item.itemId) {
            R.id.item1 -> dialog_var.show(supportFragmentManager, "Custom Dialog")
            R.id.item2 -> dialog_var2.show(supportFragmentManager, "Custom Dialog2")
        }
        return true
    }

    fun recieveTotal(total: Double) {
        val totalTV : TextView = findViewById(R.id.totalTV)
        var x : Double = total + totalTV.text.toString().toDouble()
        totalTV.text = x.toString()
        }
    }

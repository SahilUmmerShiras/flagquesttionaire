package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.lang.Exception
import java.math.BigDecimal


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)



        next.setOnClickListener {
            if(!name.text.toString().trim().isEmpty())
            {
                var intent:Intent = Intent(this,quiz::class.java)
                startActivity(intent)
            }
            else
            {
                name.error ="EDIT TEXT IS EMPTY"
                Toast.makeText(applicationContext,"EDIT TEXT IS EMPTY",Toast.LENGTH_SHORT).show();
            }
        }
    }
}

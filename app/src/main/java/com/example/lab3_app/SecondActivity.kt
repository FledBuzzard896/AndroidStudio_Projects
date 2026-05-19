package com.example.lab3_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textView = findViewById<TextView>(R.id.textView4)
        textView.text = "Вы ввели: " + getIntent().getStringExtra("text2remember")
        val button = findViewById<Button>(R.id.button2)

        button.setOnClickListener {
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            intent.putExtra("text2remember",textView.text.toString().substringAfter(" ").substringAfter(" "))
            startActivity(intent)
        }
    }
}
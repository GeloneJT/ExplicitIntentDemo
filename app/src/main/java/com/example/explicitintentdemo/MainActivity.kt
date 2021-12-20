package com.example.explicitintentdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.b1)
        btn2 = findViewById(R.id.b2)
        btn3 = findViewById(R.id.b3)

        btn1.setOnClickListener{
            intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://amazon.com"))
            startActivity(intent)
        }
        btn2.setOnClickListener{
            intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:123-456-789"))
            startActivity(intent)
        }
        btn3.setOnClickListener{
            val location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California")
            val mapIntent = Intent(Intent.ACTION_VIEW, location)
            mapIntent.setPackage("com.google.android.apps.maps")
            mapIntent.resolveActivity(packageManager)?.let {
                startActivity(mapIntent)
            }
        }
    }
}
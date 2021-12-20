package com.example.explicitintentdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.b1)
        btn2 = findViewById(R.id.b2)
        btn3 = findViewById(R.id.b3)

        btn1.setOnClickListener(View.OnClickListener {
            intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://amazon.com"))
            startActivity(intent)
        })
        btn2.setOnClickListener(View.OnClickListener {
            intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:123-456-789"))
            startActivity(intent)
        })
        btn3.setOnClickListener(View.OnClickListener {
            var location = Uri.parse("geo:27.2046,77.4977")
            var mapIntent = Intent(Intent.ACTION_VIEW, location)
            mapIntent.setPackage("com.google.android.apps.maps")
            mapIntent.resolveActivity(packageManager)?.let {
                startActivity(mapIntent)
            }
        })
    }
}
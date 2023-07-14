package com.example.clase5onitemselected

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var textViewName: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //BIND
        textViewName = findViewById(R.id.textViewNameDetail)
        imageView = findViewById(R.id.imageViewDetail)

        //BUNDLE
        val bundle = intent.extras
        val name = bundle?.getString("name", "")
        val url = bundle?.getString("url", "")

        textViewName.text = name
        Glide.with(applicationContext)
            .load(url)
            .into(imageView)

    }
}
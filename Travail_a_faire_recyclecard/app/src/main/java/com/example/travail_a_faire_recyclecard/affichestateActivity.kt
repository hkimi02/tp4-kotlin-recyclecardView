package com.example.travail_a_faire_recyclecard

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.lang.Integer.parseInt

class affichestateActivity : ComponentActivity(){
    lateinit var txtView :TextView
    lateinit var imageview : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.afficher_state_activity)
        val intent: Intent = intent
        val name = intent.getStringExtra("name")
        val src = intent.getStringExtra("src")
        txtView=findViewById(R.id.NameState)
        imageview=findViewById(R.id.imageState)
        txtView.text=name
        imageview.setImageResource(parseInt(src))

    }
}
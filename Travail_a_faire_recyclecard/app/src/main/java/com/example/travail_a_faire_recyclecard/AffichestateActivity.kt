package com.example.travail_a_faire_recyclecard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.lang.Integer.parseInt

class AffichestateActivity : ComponentActivity(){
    lateinit var txtView :TextView
    lateinit var imageview : ImageView
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.afficher_state_activity)
        val intent: Intent = intent
        val nom = intent.getStringExtra("nom")
        val src = intent.getStringExtra("src")
        txtView=findViewById(R.id.NameState)
        imageview=findViewById(R.id.imageState)
        button=findViewById(R.id.btn_delete)

        val position=intent.getStringExtra("position")
        val id=resources.getIdentifier(src, "drawable", applicationContext.packageName)
        txtView.setText(nom)
        imageview.setImageResource(id);
        button.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("delete",position)
            intent.putExtra("fromAffichestateActivity", true)
            startActivity(intent)
        }

    }
}
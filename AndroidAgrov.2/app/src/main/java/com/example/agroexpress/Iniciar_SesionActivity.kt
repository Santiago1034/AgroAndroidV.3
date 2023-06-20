package com.example.agroexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Iniciar_SesionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)



        val bntRegistar: Button = findViewById(R.id.btnTextoRegistrar)
        bntRegistar.setOnClickListener{
            val intent: Intent = Intent(this,RegistrarActivity :: class.java)
            startActivity(intent)
        }
    }



}
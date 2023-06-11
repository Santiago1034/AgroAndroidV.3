package com.example.agroexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.findNavController

class HomeActivity : AppCompatActivity() {
    private lateinit var myfragment: RegistrarFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        myfragment = RegistrarFragment()

        val btnRegistar = findViewById<Button>(R.id.RegistarUsuario)
        btnRegistar.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.contenedorRegistarFrament,new RegistrarFragment())
            fragmentTransaction.replace(R.id.contenedorRegistarFrament,myfragment)
            fragmentTransaction.commit()
           // findNavController().navigate(R.id.registrarFragment,myfragment)
        }



       /* val bntRegistar:Button = findViewById(R.id.RegistarUsuario)
        bntRegistar.setOnClickListener{
            val intent: Intent = Intent(this, cac :: class.java)
            startActivity(intent)
        }

        val bntIngresar:Button = findViewById(R.id.IniciarSesionHome)
        bntIngresar.setOnClickListener{
            val intent: Intent = Intent(this, cac :: class.java)
            startActivity(intent)
        }*/


    }




}
package com.example.tarea2onlinepmdp.ejercicio3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea2onlinepmdp.R
import com.example.tarea2onlinepmdp.ejercicio2.Web

class Main3Activity : AppCompatActivity(), ListaFragment.OnWebSelectedListener {

    private lateinit var detalleFragment: DetalleFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        detalleFragment = supportFragmentManager.findFragmentById(R.id.fragmentDetalle) as DetalleFragment
    }

    override fun onWebSelected(web: Web) {
        detalleFragment.mostrarWeb(web)
    }
}
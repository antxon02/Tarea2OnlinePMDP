package com.example.tarea2onlinepmdp.ejercicio2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea2onlinepmdp.R
import com.example.tarea2onlinepmdp.databinding.ActivityMain2Binding

class Main2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var adapter: WebAdapter
    private val webs = mutableListOf<Web>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        inicializarDatos()
        configurarRecyclerView()
        configurarSwipe()

        binding.btnAdd.setOnClickListener {
            val nuevaWeb = Web(
                "Nuevo sitio",
                "https://nuevo.com",
                "Sitio añadido manualmente.",
                "contacto@nuevo.com",
                R.drawable.ic_launcher_foreground
            )
            adapter.addWeb(nuevaWeb)
            Toast.makeText(this, "Sitio añadido", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inicializarDatos() {
        webs.add(
            Web(
                "Android Developers",
                "https://developer.android.com",
                "Documentación oficial de Android y Kotlin.",
                "support@android.com",
                R.drawable.ic_launcher_foreground
            )
        )
        webs.add(
            Web(
                "Kotlin Lang",
                "https://kotlinlang.org",
                "Página oficial del lenguaje kotlin.",
                "info@kotlinlang.org",
                R.drawable.kotlin
            )
        )
    }

    private fun configurarRecyclerView() {
        adapter = WebAdapter(webs) { web ->
            val dialog = AlertDialog.Builder(this)
                .setTitle(web.nombre)
                .setMessage("${web.descripcion}\n\nContacto: ${web.email}")
                .setPositiveButton("OK", null)
                .create()
            dialog.show()
        }
        binding.recyclerWebs.layoutManager = LinearLayoutManager(this)
        binding.recyclerWebs.adapter = adapter
    }

    private fun configurarSwipe() {
        val swipeHandler = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.removeAt(viewHolder.adapterPosition)
                Toast.makeText(applicationContext, "Sitio eliminado", Toast.LENGTH_SHORT).show()
            }
        }
        ItemTouchHelper(swipeHandler).attachToRecyclerView(binding.recyclerWebs)
    }
}
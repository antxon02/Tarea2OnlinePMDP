package com.example.tarea2onlinepmdp.ejercicio3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tarea2onlinepmdp.R
import com.example.tarea2onlinepmdp.ejercicio2.Web

class DetalleFragment : Fragment() {
    private lateinit var ivDetalle: ImageView
    private lateinit var tvNombre: TextView
    private lateinit var tvEnlace: TextView
    private lateinit var tvDescripcion: TextView
    private lateinit var tvEmail: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detalle, container, false)
        ivDetalle = view.findViewById(R.id.ivDetalle)
        tvNombre = view.findViewById(R.id.tvNombre)
        tvEnlace = view.findViewById(R.id.tvEnlace)
        tvDescripcion = view.findViewById(R.id.tvDescripcion)
        tvEmail = view.findViewById(R.id.tvEmail)
        return view
    }

    fun mostrarWeb(web: Web) {
        ivDetalle.setImageResource(web.imagenResId)
        tvNombre.text = web.nombre
        tvEnlace.text = web.enlace
        tvDescripcion.text = web.descripcion
        tvEmail.text = "Email: ${web.email}"
    }
}
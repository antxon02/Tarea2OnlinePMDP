package com.example.tarea2onlinepmdp.ejercicio3

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea2onlinepmdp.R
import com.example.tarea2onlinepmdp.ejercicio2.Web
import com.example.tarea2onlinepmdp.ejercicio2.WebAdapter

class ListaFragment : Fragment() {

    private var listener: OnWebSelectedListener? = null

    private val webs = listOf(
        Web("Android Developers", "https://developer.android.com", "Documentacion oficial", "support@android.com", R.drawable.ic_launcher_foreground),
        Web("Kotlin Lang", "https://kotlinglang.org", "Sitio oficial de Kotlin", "info@kotlinlang.org", R.drawable.ic_launcher_foreground),
        Web("GitHub", "https://github.com", "Plataforma de repositorios", "support@github.com", R.drawable.ic_launcher_foreground)
    )

    interface OnWebSelectedListener {
        fun onWebSelected(web: Web)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnWebSelectedListener) {
            listener = context
        } else {
            throw RuntimeException("$context debe implementar OnWebSelectedListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerLista)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = WebAdapter(webs as MutableList<Web>) { web -> listener?.onWebSelected(web)}
        return view
    }
}
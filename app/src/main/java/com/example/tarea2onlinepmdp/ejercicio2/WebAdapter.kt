package com.example.tarea2onlinepmdp.ejercicio2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea2onlinepmdp.R

class WebAdapter(
    private val webs: MutableList<Web>,
    private val onItemClick: (Web) -> Unit
) : RecyclerView.Adapter<WebAdapter.WebViewHolder>() {
    inner class WebViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivWeb: ImageView = view.findViewById(R.id.ivWeb)
        val tvNombre: TextView = view.findViewById(R.id.tvNombre)
        val tvEnlace: TextView = view.findViewById(R.id.tvEnlace)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_web, parent, false)
        return WebViewHolder(view)
    }

    override fun onBindViewHolder(holder: WebViewHolder, position: Int) {
        val web = webs[position]
        holder.ivWeb.setImageResource(web.imagenResId)
        holder.tvNombre.text = web.nombre
        holder.tvEnlace.text = web.enlace
        holder.itemView.setOnClickListener { onItemClick(web) }
    }

    override fun getItemCount() = webs.size

    fun removeAt(position: Int) {
        if (position in 0 until webs.size) {
            webs.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun addWeb(web: Web) {
        webs.add(web)
        notifyItemInserted(webs.size - 1)
    }
}
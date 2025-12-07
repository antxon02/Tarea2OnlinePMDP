package com.example.tarea2onlinepmdp.ejercicio1

import android.os.Bundle
import android.support.v4.os.IResultReceiver
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea2onlinepmdp.databinding.ActivityMain1Binding

class Main1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityMain1Binding

    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val watcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                actualizarConversion()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        binding.etCantidad.addTextChangedListener(watcher)
        binding.etCambio.addTextChangedListener(watcher)

        binding.rgOpciones.setOnCheckedChangeListener { _, _ -> actualizarConversion() }
    }

    private fun actualizarConversion() {
        val cantidadStr = binding.etCantidad.text.toString()
        val cambioStr = binding.etCambio.text.toString()

        if (cantidadStr.isEmpty() || cambioStr.isEmpty()) {
            binding.tvResultado.text = ""
            return
        }

        val cantidad = cantidadStr.toDoubleOrNull()
        val cambio = cambioStr.toDoubleOrNull()

        if (cantidad == null || cambio == null) {
            Toast.makeText(this, "Introduce valores númericos válidos", Toast.LENGTH_SHORT).show()
            binding.tvResultado.text = ""
            return
        }

        val resultado = if (binding.rbDolEu.isChecked) {
            cantidad * cambio
        } else {
            cantidad / cambio
        }

        binding.tvResultado.text = "Resultado: %.2f".format(resultado)
    }
}
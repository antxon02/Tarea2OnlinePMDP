package com.example.tarea2onlinepmdp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea2onlinepmdp.databinding.ActivityMainBinding
import com.example.tarea2onlinepmdp.ejercicio1.Main1Activity
import com.example.tarea2onlinepmdp.ejercicio2.Main2Activity
import com.example.tarea2onlinepmdp.ejercicio3.Main3Activity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEj1.setOnClickListener {
            val intent = Intent(this, Main1Activity::class.java)
            startActivity(intent)
        }

        binding.btnEj2.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }

        binding.btnEj3.setOnClickListener {
            val intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)
        }
    }
}
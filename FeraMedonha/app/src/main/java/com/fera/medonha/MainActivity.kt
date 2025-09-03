package com.fera.medonha

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    fun confereIdade(v: View){
        val num = findViewById<EditText>(R.id.idade)
        val texto = findViewById<TextView>(R.id.resposta)
        val idade = num.text.toString().toInt()

        if (idade >= 18)
            texto.text = "Você pode votar."
        else
            texto.text = "Você não pode votar."
    }
}
package com.fera.layouts

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Segunda_Tela : AppCompatActivity(){

    val brasil = arrayOf("1958", "1999", "1860", "1994", "2026")

    val alemanha = arrayOf("1963", "1997", "54 a.c")

    val italia = arrayOf("1942", "1950", "2026")

    val argentina = arrayOf("1750", "1480", "2000", "12 pós jardim do Éden")

    var pais : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_segunda_tela)
        val textoPais = findViewById<TextView>(R.id.campeao_text)
        val intent = getIntent()
        val dados = intent.extras
        pais = dados?.getString("país")
        textoPais.text = "Supercampeões\n - $pais - "
        exibeTitulos()
    }

    fun exibeTitulos(){
        val textoTitulos = findViewById<TextView>(R.id.titulosGanhador_text)

        when(pais){
            "Brasil" -> {
                for (titulo in brasil){
                    textoTitulos.append("$titulo\n")
                }
            }
            "Argentina" -> {
                for (titulo in argentina){
                    textoTitulos.append("$titulo\n")
                }
            }
            "Alemanha" -> {
                for (titulo in alemanha){
                    textoTitulos.append("$titulo\n")
                }
            }
            "Italia" -> {
                for (titulo in italia){
                    textoTitulos.append("$titulo\n")
                }
            }
        }
    }
}
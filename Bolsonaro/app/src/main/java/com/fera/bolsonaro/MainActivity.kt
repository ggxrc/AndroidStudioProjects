package com.fera.bolsonaro

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

const val TAG = "CICLO"
class MainActivity : AppCompatActivity() {
    var contador = 0
    var contadorRodando = false
    var timer : CountDownTimer? = null

    lateinit var textViewContador : TextView
    lateinit var textViewEstado : TextView
    lateinit var buttonIniciar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewContador = findViewById<TextView>(R.id.contador_view)
        textViewEstado = findViewById<TextView>(R.id.estado_view)
        buttonIniciar = findViewById<Button>(R.id.iniciar_btn)

        if(savedInstanceState != null){
            contador = savedInstanceState.getInt("CONTADOR")
            contadorRodando = savedInstanceState.getBoolean("CONTADOR_ATIVO")
        }

        atualizarInterface()

        buttonIniciar.setOnClickListener {
            contadorRodando = !contadorRodando
            if (contadorRodando){
                iniciarContador()
                textViewEstado.text = "Contador parado"
            }

        }

        Log.d(TAG, "onCreate - Activity está sendo criada")
    }

    fun atualizarInterface(){
        textViewContador.text = "Contador: $contador"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState - Salvando o estado da tela")
        outState.putInt("CONTADOR", contador)
        outState.putBoolean("CONTADOR_ATIVO", contadorRodando)
    }
}
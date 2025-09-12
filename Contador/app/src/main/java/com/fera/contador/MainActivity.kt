package com.fera.contador

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
            }else{
                pararContador()
            }

        }

        Log.d(TAG, "onCreate - Activity está sendo criada")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart - Activity ficando visível")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume - Activity em primeiro plano")
        if (contadorRodando){
            iniciarContador()
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause - Activity perdeu o foco")
        pararContador()
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop - Activity não visível")
    }
    fun iniciarContador(){
        timer = object : CountDownTimer(Long.MAX_VALUE, 1000){
            override fun onTick(millisUntilFinish: Long) {
                contador++
                atualizarInterface()
            }

            override fun onFinish() {
                // farei o L
            }
        }
        timer?.start()
        contadorRodando = true
        buttonIniciar.text = "Parar"
    }

    fun pararContador(){
        timer?.cancel()
        buttonIniciar.text = "Começar"
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
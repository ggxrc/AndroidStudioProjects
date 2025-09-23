package com.fera.adsletras

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var meuSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        meuSpinner = findViewById(R.id.semestre_spinner)
        val adaptador = ArrayAdapter.createFromResource(this, R.array.semestres, android.R.layout.simple_spinner_item)

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        meuSpinner.adapter = adaptador

        meuSpinner.isEnabled = false

        val radioGroup : RadioGroup = findViewById(R.id.cursos)

        radioGroup.setOnCheckedChangeListener {_, checkedId ->
            val op : RadioButton = findViewById(checkedId)
            val curso = op.text.toString()
            meuSpinner.isEnabled = curso =="ADS"
        }
    }

    fun verifica (v : View){
        val nome = findViewById<EditText>(R.id.nome_inputText).text.toString()
        val radioGroup = findViewById<RadioGroup>(R.id.cursos)
        val op = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
        val curso = op.text.toString()

        when (curso){
            "Letras" -> {
                if(nome.isEmpty()){
                    AlertDialog.Builder(this)
                        .setTitle("é fogo")
                        .setMessage("nem pra ter a decência de colocar seu nome... " +
                                "tinha que ser de Letras.")
                        .setPositiveButton("Vá se lascar")  { _, _ ->
                            finishAffinity()
                        }
                        .show()
                } else{
                    AlertDialog.Builder(this)
                        .setTitle("Aviso")
                        .setMessage("Olá $nome. Sinto muito, não queremos" +
                                " saber de ninguém de letras.")
                        .setPositiveButton("OK") { _, _ ->
                            finishAffinity()
                        }
                        .show()

                }

            }
            "ADS" -> {
                val semestre = meuSpinner.selectedItem.toString()

                if(nome.isNotEmpty()){
                    val msg = when(semestre){
                        "S1", "S2" -> "Sem editais no momento"
                        "S3" -> "Edital - Jovens do latrocínio"
                        "S4" -> "Edital - Jovens das ilicitudes"
                        "S5" -> "Edital - Jovens Vagabundos"
                        else -> "Não há nenhum edital"
                    }

                    AlertDialog.Builder(this)
                        .setTitle("Editais disponíveis")
                        .setMessage("Olá $nome. Está disponível:\n" +
                                "\n$msg")
                        .setPositiveButton("OK", null)
                        .show()
                }else{
                    AlertDialog.Builder(this)
                        .setTitle("ATENÇÃO")
                        .setMessage("Por favor. preencha todos os" +
                                " dados")
                        .setPositiveButton("OK", null)
                        .show()
                }

            }

        }

    }
}
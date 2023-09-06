package br.edu.ifpb.pdm.zagreus

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private var jogo = JogoDoBicho()
    private lateinit var tvStatus: TextView
    private lateinit var tvIntervaloMinimo: TextView
    private lateinit var tvIntervaloMaximo: TextView
    private lateinit var botao: Button
    private lateinit var entrada: TextInputEditText
    private lateinit var palpiteDoJogador: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvStatus = this.findViewById(R.id.status)
        this.tvIntervaloMinimo = this.findViewById(R.id.intervaloMinimo)
        this.tvIntervaloMaximo = this.findViewById(R.id.intervaloMaximo)
        this.botao = this.findViewById(R.id.botao)
        this.entrada = this.findViewById(R.id.entrada)

        this.botao.setOnClickListener({ cliqueDoBotao(it)})


    }

    fun cliqueDoBotao(view:View){
        this.palpiteDoJogador = this.entrada.text.toString()
        if(this.palpiteDoJogador.isNullOrEmpty() || !this.palpiteDoJogador.isDigitsOnly()){
            this.showToast("Entrada Inválida")

        }else{
            Toast.makeText(this,"Entrada Inválida",Toast.LENGTH_SHORT).show()
            this.showToast(this.jogo.jogar(this.palpiteDoJogador.toInt()))
            this.tvStatus.setText("Status do Jogo: "+ this.jogo.getStatus())
            this.tvIntervaloMinimo.setText(this.jogo.getIntervaloMinimo().toString())
            this.tvIntervaloMaximo.setText(this.jogo.getIntervaloMaximo().toString())
        }

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
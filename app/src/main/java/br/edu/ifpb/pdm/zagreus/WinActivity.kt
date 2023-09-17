package br.edu.ifpb.pdm.zagreus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class WinActivity : AppCompatActivity() {
    private lateinit var botaoWin: Button
    private lateinit var nomeDoJogador: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)

        this.botaoWin = this.findViewById(R.id.botaoWin)
        this.botaoWin.setOnClickListener({retornar()})

        this.nomeDoJogador = this.findViewById(R.id.nomeJogador)
    }

    private fun retornar(){
        //Estou enviando para a view que me chamou o nome do jogador
        var nomeDoJogador = this.nomeDoJogador.text.toString()
        val intent = Intent().apply {
            putExtra("NOME_JOGADOR",nomeDoJogador)
        }
        setResult(RESULT_OK, intent)
        finish()
    }
}
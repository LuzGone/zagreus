package br.edu.ifpb.pdm.zagreus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

class WinActivity : AppCompatActivity() {
    private lateinit var botaoWin: Button
    private lateinit var nomeDoJogador: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)

        this.nomeDoJogador = this.findViewById(R.id.nomeDoJogador)
        this.botaoWin = this.findViewById(R.id.botaoWin)


        this.botaoWin.setOnClickListener({retornar()})
    }

    private fun retornar(){
        val nomeDoJogador = this.nomeDoJogador.text.toString()
        val intent = Intent().apply {
            putExtra("NOME_JOGADOR", nomeDoJogador)
        }
        setResult(RESULT_OK,intent)
        finish()
    }
}
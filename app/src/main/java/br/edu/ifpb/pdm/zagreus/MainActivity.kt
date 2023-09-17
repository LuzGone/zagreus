package br.edu.ifpb.pdm.zagreus

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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
    private lateinit var ultimoGanhador: TextView

    private val winResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            val nomeDoJogador = it.data?.getStringExtra("NOME_JOGADOR")
            this.ultimoGanhador.setText("Ultimo Ganhador: ${nomeDoJogador}")
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvStatus = this.findViewById(R.id.status)
        this.tvIntervaloMinimo = this.findViewById(R.id.intervaloMinimo)
        this.tvIntervaloMaximo = this.findViewById(R.id.intervaloMaximo)
        this.botao = this.findViewById(R.id.botao)
        this.entrada = this.findViewById(R.id.entrada)
        this.ultimoGanhador = this.findViewById(R.id.ultimoGanhador)

        this.botao.setOnClickListener({ cliqueDoBotao(it)})
        this.tvStatus.setOnLongClickListener({cliqueLongoDoStatus(it)})

    }

    override fun onRestart() {
        super.onRestart()
        this.jogo.reiniciar()
        this.tvStatus.setText("Status do Jogo: "+ this.jogo.getStatus())
        this.tvIntervaloMinimo.setText(this.jogo.getIntervaloMinimo().toString())
        this.tvIntervaloMaximo.setText(this.jogo.getIntervaloMaximo().toString())
    }

    fun cliqueDoBotao(view:View){
        this.palpiteDoJogador = this.entrada.text.toString()
        if(this.palpiteDoJogador.isDigitsOnly()){
            this.showToast(this.jogo.jogar(this.palpiteDoJogador.toInt()))
            if(this.jogo.getStatus()=="VITORIA"){
                this.chamarTelaWin()
            }else if (this.jogo.getStatus()=="DERROTA"){
                this.chamarTelaLose()
            }
            this.tvStatus.setText("Status do Jogo: "+ this.jogo.getStatus())
            this.tvIntervaloMinimo.setText(this.jogo.getIntervaloMinimo().toString())
            this.tvIntervaloMaximo.setText(this.jogo.getIntervaloMaximo().toString())
        }else{
            this.showToast("Entrada Inválida")
        }
    }

    fun cliqueLongoDoStatus(view: View): Boolean{
        this.showToast("Reiniciando Jogo")
        this.jogo.reiniciar()
        this.tvStatus.setText("Status do Jogo: "+ this.jogo.getStatus())
        this.tvIntervaloMinimo.setText(this.jogo.getIntervaloMinimo().toString())
        this.tvIntervaloMaximo.setText(this.jogo.getIntervaloMaximo().toString())
        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun chamarTelaWin(){
        val intent = Intent(this, WinActivity::class.java)
        this.winResult.launch(intent)
    }

    private fun chamarTelaLose(){
        val intent = Intent(this, LoseActivity::class.java)
        startActivity(intent)
    }
}
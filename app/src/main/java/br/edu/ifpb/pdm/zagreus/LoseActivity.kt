package br.edu.ifpb.pdm.zagreus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoseActivity : AppCompatActivity() {
    private lateinit var botaoLose: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lose)

        this.botaoLose = this.findViewById(R.id.botaoLose)
        this.botaoLose.setOnClickListener({this.retornar()})
    }

    private fun retornar(){
        finish()
    }
}
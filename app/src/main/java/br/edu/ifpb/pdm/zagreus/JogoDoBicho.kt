package br.edu.ifpb.pdm.zagreus

import android.util.Log
import kotlin.random.Random

const val MINIMO = 1
const val MAXIMO = 100


class JogoDoBicho {
    private var intervaloMinimo = MINIMO
    private var intervaloMaximo = MAXIMO
    private var bichoSorteado : Int
    private var status : String

    constructor(){
        this.bichoSorteado = Random.nextInt(MINIMO,MAXIMO+1)
        Log.d("STATUS",this.bichoSorteado.toString())
        this.status = "JOGANDO"
    }

    fun jogar (palpiteDoJogador:Int) : String{
        if(this.status == "JOGANDO"){
            if(palpiteDoJogador<this.intervaloMinimo || palpiteDoJogador>this.intervaloMaximo){
                this.status = "DERROTA"
                return "PERDEU"
            }
            if(palpiteDoJogador==this.bichoSorteado){
                this.status = "VITORIA"
                return "GANHOU"
            }
            if(palpiteDoJogador>this.bichoSorteado){
                this.intervaloMaximo = palpiteDoJogador - 1
                if(this.intervaloMinimo == this.intervaloMaximo) {
                    this.status = "DERROTA"
                    return "PERDEU"
                }
                return "ERROU"
            }else{
                this.intervaloMinimo = palpiteDoJogador + 1
                if(this.intervaloMinimo == this.intervaloMaximo) {
                    this.status = "DERROTA"
                    return "PERDEU"
                }
                return "ERROU"
            }
        }else{
            return this.status
        }

    }

    fun reiniciar(){
        this.bichoSorteado =  Random.nextInt(MINIMO,MAXIMO+1)
        this.intervaloMinimo = MINIMO
        this.intervaloMaximo = MAXIMO
        this.status = "JOGANDO"
        Log.d("STATUS",this.bichoSorteado.toString())
    }

    fun getStatus():String{
        return this.status
    }

    fun getIntervaloMinimo():Int{
        return this.intervaloMinimo
    }

    fun getIntervaloMaximo():Int{
        return this.intervaloMaximo
    }

}
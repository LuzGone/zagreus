package br.edu.ifpb.pdm.zagreus

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
        this.status = "JOGANDO"
    }

    fun jogar (palpiteDoJogador:Int) : String{
        if(palpiteDoJogador<this.intervaloMinimo || palpiteDoJogador>this.intervaloMaximo){
            this.status = "DERROTA"
            return "PERDEU"
        }
        if(palpiteDoJogador==this.bichoSorteado){
            this.status = "VITORIA"
            return "GANHOU"
        }
        if(this.intervaloMinimo == this.intervaloMaximo) {
            this.status = "DERROTA"
            return "PERDEU"
        }
        if(palpiteDoJogador>this.bichoSorteado){
            this.intervaloMaximo = palpiteDoJogador
            return "ERROU"
        }else{
            this.intervaloMinimo = palpiteDoJogador
            return "ERROU"
        }
    }

    fun reiniciar(){
        this.bichoSorteado =  Random.nextInt(MINIMO,MAXIMO+1)
        this.intervaloMinimo = MINIMO
        this.intervaloMaximo = MAXIMO
        this.status = "JOGANDO"
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
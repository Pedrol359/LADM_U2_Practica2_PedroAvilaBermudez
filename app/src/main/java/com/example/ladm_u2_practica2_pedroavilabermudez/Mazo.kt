package com.example.ladm_u2_practica2_pedroavilabermudez

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.widget.ImageView
import kotlin.random.Random

class Mazo(val imagenCarta:ImageView, val activity: MainActivity) {
    var cont =0
    var posicion=-1
    val carta = Array<Carta>(54){Carta(imagenCarta)}
    var mazoRecorridoDerecha = false
    var mazoRecorridoIzquierda = true
    var juegoTerminado =false
    var juegoPausado =false

    val hilo=Hilo(this,activity)

    init {
        crearCartas()

        barajar()
        hilo.start()
    }
    fun iniciarJuego() {
       hilo.despausarHilo()

    }
    fun siguienteCarta(){
        println("Pos: "+posicion)
        if (posicion<53){
            carta[++posicion].mostarCarta()
            carta[posicion].mencionarCarta(activity)
            mazoRecorridoIzquierda=false
            if (posicion==53) {
                if (!juegoTerminado)
                    juegoTerminado=true
                mazoRecorridoDerecha = true
                println("Mazo Recorrido Derecha")
            }
        }

    }
    fun cartaAnterior(){
        if (posicion>0){
            println("Posicion: $posicion")
            carta[--posicion].mostarCarta()
            carta[posicion].mencionarCarta(activity)
            println("Posicion: $posicion")
            //println(carta[posicion].numCarta)
            mazoRecorridoDerecha = false
            if (posicion==0){
                mazoRecorridoIzquierda = true
                println("Mazo Recorrido Izquierda")
            }
        }else
            mazoRecorridoIzquierda = true

    }
    fun pausarOContinuar():Boolean{
        if (juegoPausado){
            hilo.despausarHilo()
            juegoPausado=false
            return false

        }else{
            hilo.pausarHilo()
            juegoPausado=true
            return true
        }

    }
    fun reiniciar(){
        juegoTerminado=false
        mazoRecorridoIzquierda=true
        mazoRecorridoDerecha=false
        hilo.pausarHilo()
        posicion=-1
        imagenCarta.setImageResource(R.drawable.carta1)
        barajar()
    }
    fun barajar(){
        //Algoritmo para desordenar
        (0..53).forEach{
            val random= Random.nextInt(0,53)
            val copiaCarta = carta[it]
            carta.set(it,carta[random])
            carta.set(random,copiaCarta)
        }
        //Metodo para solo comprobar que no este repetido algun elemento
        /*
        val lista : ArrayList<Int>
        lista = ArrayList()
        for (i in (0..53)){
            lista.add(carta[i].numCarta)
        }
        println(lista.sorted())
        for (i in (0..53)){
            println("ID: ${carta[i].numCarta}")
        }
        println(carta.size)*/
    }
    fun loteria() {
        hilo.pausarHilo()
    }

    fun crearCartas(){
        carta[cont++].cargarImagenYAudio(R.drawable.carta1,R.raw.a1,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta2,R.raw.a2,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta3,R.raw.a3,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta4,R.raw.a4,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta5,R.raw.a5,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta6,R.raw.a6,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta7,R.raw.a7,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta8,R.raw.a8,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta9,R.raw.a9,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta10,R.raw.a10,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta11,R.raw.a11,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta12,R.raw.a12,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta13,R.raw.a13,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta14,R.raw.a14,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta15,R.raw.a15,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta16,R.raw.a16,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta17,R.raw.a17,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta18,R.raw.a18,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta19,R.raw.a19,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta20,R.raw.a20,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta21,R.raw.a21,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta22,R.raw.a22,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta23,R.raw.a23,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta24,R.raw.a24,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta25,R.raw.a25,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta26,R.raw.a26,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta27,R.raw.a27,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta28,R.raw.a28,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta29,R.raw.a29,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta30,R.raw.a30,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta31,R.raw.a31,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta32,R.raw.a32,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta33,R.raw.a33,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta34,R.raw.a34,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta35,R.raw.a35,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta36,R.raw.a36,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta37,R.raw.a37,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta38,R.raw.a38,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta39,R.raw.a39,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta40,R.raw.a40,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta41,R.raw.a41,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta42,R.raw.a42,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta43,R.raw.a43,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta44,R.raw.a44,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta45,R.raw.a45,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta46,R.raw.a46,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta47,R.raw.a47,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta48,R.raw.a48,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta49,R.raw.a49,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta50,R.raw.a50,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta51,R.raw.a51,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta52,R.raw.a52,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta53,R.raw.a53,cont)
        carta[cont++].cargarImagenYAudio(R.drawable.carta54,R.raw.a54,cont)
    }




}
package com.example.ladm_u2_practica2_pedroavilabermudez

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.media.MediaPlayer
import android.widget.ImageView

class Carta(imagenCarta: ImageView) {
    var numCarta=0
    val imagenCarta=imagenCarta
    var imagen=0
    var sonido=0

    fun mostarCarta(){
        imagenCarta.setImageResource(imagen)
    }
    fun mencionarCarta(pointer:MainActivity){
        println("Sonido: $sonido")
        try {
            val sondg = MediaPlayer.create(pointer.applicationContext,sonido)
            sondg.start()
            sondg.setOnCompletionListener { sond -> sond.release() }
        } catch (ex: Exception) {
            println(ex.message)
        }
    }
    fun cargarImagenYAudio(img:Int,sound:Int,id:Int){
        imagen=img
        sonido=sound
        numCarta=id-1

        //println("Imagen: $imagen, Sonido: $sonido, numCarta: $numCarta")
    }

}
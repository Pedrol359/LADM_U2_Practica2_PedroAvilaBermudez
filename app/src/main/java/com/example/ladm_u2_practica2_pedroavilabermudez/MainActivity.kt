package com.example.ladm_u2_practica2_pedroavilabermudez

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {
    //Variables

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="Hola Mundo!"
        //Componentes
        val btnIniciar = findViewById<Button>(R.id.iniciar)
        val btnLoteria = findViewById<Button>(R.id.loteria)
        val btnMostrarCartas = findViewById<Button>(R.id.mostrarRestoCartas)
        val btnPausar = findViewById<Button>(R.id.pausar)
        val btnReiniciar = findViewById<Button>(R.id.reiniciar)
        val btnSiguiente = findViewById<Button>(R.id.siguiente)
        val btnAnterior = findViewById<Button>(R.id.anterior)
        val imagenCarta = findViewById<ImageView>(R.id.imagenCarta)
        val contadorInicio = findViewById<TextView>(R.id.contador)

        val mazo = Mazo(imagenCarta,this)
        setTitle("Bienvenido y suerte")
        btnIniciar.setOnClickListener {
            contadorInicio.visibility= View.VISIBLE
            val coroutine = GlobalScope.launch {
                contadorInicio.setText("3")
                sleep(800)
                contadorInicio.setText("2")
                sleep(800)
                contadorInicio.setText("1")
                sleep(800)
                contadorInicio.setText("Go")
                sleep(700)
                mazo.iniciarJuego()

                runOnUiThread{
                    contadorInicio.visibility= View.INVISIBLE
                    btnIniciar.visibility=View.INVISIBLE
                    btnLoteria.visibility=View.VISIBLE
                    btnPausar.visibility=View.VISIBLE
                    btnReiniciar.visibility=View.VISIBLE
                }
            }

            val controlEstado = GlobalScope.launch {
                while (true){
                    sleep(50)
                    runOnUiThread{

                        if (mazo.juegoTerminado){
                            btnLoteria.isEnabled = false
                            btnPausar.isEnabled = false
                            setTitle("Baraja Finalizada")

                        } else{
                            if (!mazo.juegoTerminado){
                                btnLoteria.isEnabled = true
                                btnPausar.isEnabled = true
                            }
                        }
                        btnAnterior.isEnabled = !mazo.mazoRecorridoIzquierda
                        btnSiguiente.isEnabled = !mazo.mazoRecorridoDerecha
                    }

                }

            }
        }//fin btnIniciar
        btnLoteria.setOnClickListener {
            mazo.loteria()
            btnLoteria.visibility=View.INVISIBLE
            btnPausar.visibility=View.INVISIBLE
            btnSiguiente.visibility=View.VISIBLE
            btnAnterior.visibility=View.VISIBLE
            setTitle("Felicidades!")
        }//fin btnLoteria
        btnPausar.setOnClickListener {
            btnPausar.setText("Continuar")
            if (mazo.pausarOContinuar())
                btnPausar.setText("Continuar")
            else
                btnPausar.setText("Pausar")
        }//fin btnPausar
        btnReiniciar.setOnClickListener {
            mazo.reiniciar()
            btnIniciar.visibility=View.VISIBLE
            btnLoteria.visibility=View.INVISIBLE
            btnPausar.visibility=View.INVISIBLE
            btnReiniciar.visibility=View.INVISIBLE
            btnSiguiente.visibility=View.INVISIBLE
            btnAnterior.visibility=View.INVISIBLE
            btnPausar.setText("Pausar")
            btnSiguiente.isEnabled = !mazo.mazoRecorridoDerecha
            btnAnterior.isEnabled = !mazo.mazoRecorridoIzquierda
            setTitle("Bienvenido y suerte")
        }
        var temp=1
        btnSiguiente.setOnClickListener {
            mazo.siguienteCarta()
        }
        btnAnterior.setOnClickListener {
            mazo.cartaAnterior()
        }

    }

    fun p(imagenCarta:ImageView){
        imagenCarta.visibility= View.INVISIBLE
    }

}
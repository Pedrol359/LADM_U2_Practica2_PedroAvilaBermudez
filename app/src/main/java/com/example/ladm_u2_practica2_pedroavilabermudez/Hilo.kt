package com.example.ladm_u2_practica2_pedroavilabermudez

class Hilo(val mazo: Mazo, val activity: MainActivity): Thread() {

    private var pausar = true

    override fun run() {//ESTE HILO AUNQUE TENGA UNA SOLA INSTRUCCION, ES EL PROCESO MÁS PESADO DADO QUE SE ENCARGA DE EJECUTAR TODA LA MULTIMEDIA
                        // a comparacion de las coroutinas que solo se encargan e mostrar un contador de inicio y la segunda de cambiar el estado de
                        //habilitado de algunos botones
        super.run()

        while (true) {

            if(!mazo.mazoRecorridoDerecha && !pausar){
                activity.runOnUiThread {
                    mazo.siguienteCarta()
                }
                sleep(2500)
                //sleep(1500)
            }

        }
    }

    fun pausarHilo() {
        pausar = true
    }

    fun despausarHilo() {
        pausar = false
    }
}
package com.liceth.ramirez.calcularnotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {

    private lateinit var ingresarNombre: EditText
    private lateinit var ingresarPorcentaje: EditText
    private lateinit var ingresarNota: EditText
    private lateinit var finalizar: Button
    private lateinit var guardar: Button
    private lateinit var  progreso : ProgressBar

    private var porcentajeAcumulado = 0

    val listaNotas : MutableList<Double> = mutableListOf()
    val listaPorcentajes : MutableList<Int> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ingresarNombre = findViewById(R.id.ingresarNombre)
        ingresarPorcentaje = findViewById(R.id.ingresarNombre)
        ingresarNota = findViewById(R.id.ingresarNota)
        finalizar = findViewById(R.id.finalizar)
        guardar = findViewById(R.id.guardar)
        progreso = findViewById(R.id.progreso)



        guardar.setOnClickListener{
            val nota = (ingresarNota.text.toString()).toDouble()

            val porcentaje = (ingresarPorcentaje.text.toString()).toInt()

            if (validarNota(nota) && validarPorcentaje(porcentaje)){
                listaNotas.add(nota)

                listaPorcentajes.add(porcentaje)
                porcentajeAcumulado += porcentaje
            }else{
                //TODO informar al usuario que la nota ingresada no es valida
            }


        }
    }

    fun actualizarPorgreso(porcentaje : Int){
progreso.progress=porcentaje
    }

    fun validarNota(nota : Double): Boolean{
        return nota >=0 && nota <=5
    }

    fun validarPorcentaje(porcentaje : Int): Boolean{
        return  porcentajeAcumulado + porcentaje <=100
    }


}
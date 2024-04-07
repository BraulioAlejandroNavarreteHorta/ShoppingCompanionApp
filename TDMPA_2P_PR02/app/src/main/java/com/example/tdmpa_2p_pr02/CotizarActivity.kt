package com.example.tdmpa_2p_pr02

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class CotizarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotizar)

        cargarProducto()

        var btnCotizar = findViewById<Button>(R.id.btnCalcular)

        btnCotizar.setOnClickListener {
            validacion()
            calcularTotal()
        }
    }

    fun validacion(){
        var txtCantidad = findViewById<EditText>(R.id.txtCantidad)
        if(txtCantidad.text.isEmpty()){
            txtCantidad.setText("0")
        }
    }

    fun cargarProducto(){
        var txtNombreProducto = findViewById<TextView>(R.id.txtNombreProducto3)
        var imgProducto = findViewById<ImageView>(R.id.imgProducto2)
        var txtPrecioProducto = findViewById<TextView>(R.id.txtPrecio)

        val nombreProducto = intent.extras?.getString("nombreProducto").toString()
        txtNombreProducto.text = nombreProducto

        val precioProducto = intent.extras?.getDouble("precioProducto").toString()
        txtPrecioProducto.text = precioProducto

        val imagenProducto = intent.extras?.getString("imagenProducto").toString()

        var urlFondo = imagenProducto
        val urlParseFondo : Uri = Uri.parse(urlFondo)
        Glide.with(applicationContext).load(urlParseFondo).into(imgProducto)
    }

    fun calcularTotal(){
        var txtPrecioProducto = findViewById<TextView>(R.id.txtPrecio)
        var txtCantidad = findViewById<EditText>(R.id.txtCantidad)
        var txtTotal =  findViewById<TextView>(R.id.txtTotal)

        var total = txtPrecioProducto.text.toString().toDouble() * txtCantidad.text.toString().toDouble()

        txtTotal.text = "$" + String.format("%.4f", total)

    }

}
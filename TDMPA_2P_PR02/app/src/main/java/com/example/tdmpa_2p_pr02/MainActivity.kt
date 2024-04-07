package com.example.tdmpa_2p_pr02

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var opcion = ""

        val spnCategoria = findViewById<Spinner>(R.id.spnCategoria)
        val spnProducto = findViewById<Spinner>(R.id.spnProducto)
        var btnAgregarAlCarrito = findViewById<Button>(R.id.btnAgregarCarrito)

        val categoria = resources.getStringArray(R.array.Categoria)
        val adapterCat = ArrayAdapter(this, android.R.layout.simple_spinner_item, categoria)
        spnCategoria.adapter = adapterCat

        spnCategoria.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                opcion = categoria[position]
                when {
                    opcion == "Ropa" -> {
                        ropaAdapter()
                    }

                    opcion == "Calzado" -> {
                        calzadoAdapter()
                    }

                    opcion == "Accesorios" -> {
                        accesoriosAdapter()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(
                    this@MainActivity, "No se seleccionó nada",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        spnProducto.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, posicion: Int, id: Long
            ) {
                seleccionProducto()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(
                    this@MainActivity, "No se seleccionó nada",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnAgregarAlCarrito.setOnClickListener {

            when {
                spnProducto.selectedItem == "Playera" -> {
                    nombreProducto = playeranegra[0]
                    imagenProducto = playeranegra[1]
                    precio = 200.0

                    val intent = Intent(this, CotizarActivity::class.java)
                    intent.putExtra("nombreProducto", nombreProducto)
                    intent.putExtra("imagenProducto", imagenProducto)
                    intent.putExtra("precioProducto", precio)
                    startActivity(intent)

                }

                spnProducto.selectedItem == "Pantalón" -> {
                    nombreProducto = pantalonnegro[0]
                    imagenProducto = pantalonnegro[1]
                    precio = 550.0

                    val intent = Intent(this, CotizarActivity::class.java)
                    intent.putExtra("nombreProducto", nombreProducto)
                    intent.putExtra("imagenProducto", imagenProducto)
                    intent.putExtra("precioProducto", precio)
                    startActivity(intent)
                }

                spnProducto.selectedItem == "Chamarra" -> {
                    nombreProducto = chamarranegra[0]
                    imagenProducto = chamarranegra[1]
                    precio = 999.0

                    val intent = Intent(this, CotizarActivity::class.java)
                    intent.putExtra("nombreProducto", nombreProducto)
                    intent.putExtra("imagenProducto", imagenProducto)
                    intent.putExtra("precioProducto", precio)
                    startActivity(intent)
                }

                spnProducto.selectedItem == "Jordan 1" -> {
                    nombreProducto = jordan1blanco[0]
                    imagenProducto = jordan1blanco[1]
                    precio = 3200.0

                    val intent = Intent(this, CotizarActivity::class.java)
                    intent.putExtra("nombreProducto", nombreProducto)
                    intent.putExtra("imagenProducto", imagenProducto)
                    intent.putExtra("precioProducto", precio)
                    startActivity(intent)
                }

                spnProducto.selectedItem == "Adidas Forum" -> {
                    nombreProducto = adidasforum[0]
                    imagenProducto = adidasforum[1]
                    precio = 1200.0

                    val intent = Intent(this, CotizarActivity::class.java)
                    intent.putExtra("nombreProducto", nombreProducto)
                    intent.putExtra("imagenProducto", imagenProducto)
                    intent.putExtra("precioProducto", precio)
                    startActivity(intent)
                }

                spnProducto.selectedItem == "Nike Dunk" -> {
                    nombreProducto = nikedunk[0]
                    imagenProducto = nikedunk[1]
                    precio = 1800.0

                    val intent = Intent(this, CotizarActivity::class.java)
                    intent.putExtra("nombreProducto", nombreProducto)
                    intent.putExtra("imagenProducto", imagenProducto)
                    intent.putExtra("precioProducto", precio)
                    startActivity(intent)
                }

                spnProducto.selectedItem == "Reloj" -> {
                    nombreProducto = reloj[0]
                    imagenProducto = reloj[1]
                    precio = 3000.0

                    val intent = Intent(this, CotizarActivity::class.java)
                    intent.putExtra("nombreProducto", nombreProducto)
                    intent.putExtra("imagenProducto", imagenProducto)
                    intent.putExtra("precioProducto", precio)
                    startActivity(intent)
                }

                spnProducto.selectedItem == "Pulsera" -> {
                    nombreProducto = pulsera[0]
                    imagenProducto = pulsera[1]
                    precio = 5200.0

                    val intent = Intent(this, CotizarActivity::class.java)
                    intent.putExtra("nombreProducto", nombreProducto)
                    intent.putExtra("imagenProducto", imagenProducto)
                    intent.putExtra("precioProducto", precio)
                    startActivity(intent)
                }

                spnProducto.selectedItem == "Gorra" -> {
                    nombreProducto = gorranegra[0]
                    imagenProducto = gorranegra[1]
                    precio = 220.0

                    val intent = Intent(this, CotizarActivity::class.java)
                    intent.putExtra("nombreProducto", nombreProducto)
                    intent.putExtra("imagenProducto", imagenProducto)
                    intent.putExtra("precioProducto", precio)
                    startActivity(intent)
                }
            }
        }
    }

    fun cargarDatosProductos(nombre: String, imagen: String, descripcion: String){
        var txtProducto = findViewById<TextView>(R.id.txtNombreProducto)
        var txtDescripcion = findViewById<TextView>(R.id.txtNombreProducto2)
        var imgProducto = findViewById<ImageView>(R.id.imgProducto)

        var urlFondo = imagen
        val urlParseFondo : Uri = Uri.parse(urlFondo)
        Glide.with(applicationContext).load(urlParseFondo).into(imgProducto)
        Toast.makeText(this@MainActivity, "Se realizó el cambio", Toast.LENGTH_SHORT).show()

        txtProducto.text = nombre
        txtDescripcion.text = descripcion

    }

    fun ropaAdapter(){
        val spnProducto = findViewById<Spinner>(R.id.spnProducto)
        val ropa = resources.getStringArray(R.array.Ropa)
        val adapterRopa = ArrayAdapter(this, android.R.layout.simple_spinner_item, ropa)
        spnProducto.adapter = adapterRopa
    }

    fun calzadoAdapter(){
        val spnProducto = findViewById<Spinner>(R.id.spnProducto)
        val calzado = resources.getStringArray(R.array.Calzado)
        val adapterCalzado = ArrayAdapter(this, android.R.layout.simple_spinner_item, calzado)
        spnProducto.adapter = adapterCalzado
    }

    fun accesoriosAdapter(){
        val spnProducto = findViewById<Spinner>(R.id.spnProducto)
        val accesorios = resources.getStringArray(R.array.Accesroios)
        val adapterAccesorio = ArrayAdapter(this, android.R.layout.simple_spinner_item, accesorios)
        spnProducto.adapter = adapterAccesorio
    }

    fun seleccionProducto(){
        val spnProducto = findViewById<Spinner>(R.id.spnProducto)
        when {
            spnProducto.selectedItem == "Playera" -> {
                cargarDatosProductos(playeranegra[0], playeranegra[1], playeranegra [2])
            }

            spnProducto.selectedItem == "Pantalón" -> {
                cargarDatosProductos(pantalonnegro[0], pantalonnegro[1], pantalonnegro [2])
            }

            spnProducto.selectedItem == "Chamarra" -> {
                cargarDatosProductos(chamarranegra[0], chamarranegra[1], chamarranegra [2])
            }

            spnProducto.selectedItem == "Jordan 1" -> {
                cargarDatosProductos(jordan1blanco[0], jordan1blanco[1], jordan1blanco [2])
            }

            spnProducto.selectedItem == "Adidas Forum" -> {
                cargarDatosProductos(adidasforum[0], adidasforum[1], adidasforum [2])
            }

            spnProducto.selectedItem == "Nike Dunk" -> {
                cargarDatosProductos(nikedunk[0], nikedunk[1], nikedunk [2])
            }

            spnProducto.selectedItem == "Reloj" -> {
                cargarDatosProductos(reloj[0], reloj[1], reloj [2])
            }

            spnProducto.selectedItem == "Pulsera" -> {
                cargarDatosProductos(pulsera[0], pulsera[1], pulsera [2])
            }

            spnProducto.selectedItem == "Gorra" -> {
                cargarDatosProductos(gorranegra[0], gorranegra[1], gorranegra [2])

            }
        }
    }

    var playeranegra = arrayOf("Playera Negra", "https://grupogranpremio.net/wp-content/uploads/2018/05/12.png","Esta es una playera lisa de cuello en V para caballero de la marca Alfani.")
    var pantalonnegro = arrayOf("Pantalon Roto", "https://m.media-amazon.com/images/I/81i9BwPgtEL._AC_SX679_.jpg","QIMYUM Jeans Rasgados para Hombre, Pantalones de Mezclilla de Pierna Recta y Desgastados.")
    var chamarranegra = arrayOf("Chamarra", "https://m.media-amazon.com/images/I/61h1qyECPqL._AC_SX679_.jpg","GIISAM - chamarra impermeable ligera para hombre, resistente al viento, para hombre")

    var jordan1blanco = arrayOf("Jordan 1 HIGH", "https://m.media-amazon.com/images/I/619FF0UkucL._AC_SX695_.jpg","Inspirada en el AJ1 original, esta edición media mantiene el aspecto icónico que te gusta, mientras que los colores de elección y el piel nítido le dan una identidad distintiva.")
    var adidasforum = arrayOf("Adidas Forum", "https://m.media-amazon.com/images/I/414Rb5J-osL._AC_SY695_.jpg","Adidas Forum 84 Low ADV - Zapatos unisex para baloncesto, atletismo y zapatillas")
    var nikedunk = arrayOf("Nike Dunk", "https://m.media-amazon.com/images/I/71gsTXVx5yL._AC_SX695_.jpg","Nike Dunk High DD1399 101 Syracuse - Talla para hombre, Team Gold/Trigo Gold Team Gold, 8.5 US")

    var reloj = arrayOf("Reloj plata", "https://m.media-amazon.com/images/I/71P8OsDVKDL._AC_SY879_.jpg","Reloj Invicta Pro Diver para Hombres 38mm, pulsera de Acero Inoxidable")
    var pulsera = arrayOf("Pulsera SKULL", "https://m.media-amazon.com/images/I/710xYR6jpEL._AC_SX695_.jpg","Pulsera Difusora Ajustable | Brazalete Piedra volcánica 8 mm | Calavera | Omky")
    var gorranegra = arrayOf("Gorra Negra", "https://grupogranpremio.net/wp-content/uploads/2018/10/10-600x600.png","-Material y cuidado:Este gorro suave está hecho de 96 % algodón.Lavable a máquina y lavable a mano, pero no apto para secadora.")

    var nombreProducto = ""
    var imagenProducto = ""
    var precio = 0.0
}
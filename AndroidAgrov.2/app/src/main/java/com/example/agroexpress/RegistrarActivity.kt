package com.example.agroexpress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.navigation.Navigation
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.agroexpress.Adaptador.ProductoAdaptador
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class RegistrarActivity : AdapterView.OnItemSelectedListener, AppCompatActivity() {


    private  var Departamanetoslist= ArrayList<JSONObject>()
    private var Municipiolist = ArrayList<JSONObject>()
    var spinerDepartamento : Spinner?=null
    var spinerMunicipio : Spinner?=null
    var textView_msg : TextView? = null
    var textView_msg2 : TextView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        textView_msg = findViewById(R.id.msg)
        textView_msg2 = findViewById(R.id.msg2)
        spinerDepartamento = findViewById(R.id.SpinnerDepartamentos)
        spinerMunicipio = findViewById(R.id.SpinnerMunicipio)

        val queue = Volley.newRequestQueue(this)
        val queue2 = Volley.newRequestQueue(this)
        val url = "http://192.168.104.149:8080/listardepar"
        val url2 = "http://192.168.104.149:8080/listarmuni"

        val stringRequest = StringRequest(Request.Method.GET, url2, { response ->
            val jsonArray = JSONArray(response)
            this.Municipiolist = ArrayList()
            try {
                var n = 0
                val g = jsonArray.length()

                while (n < g) {
                    Municipiolist.add(jsonArray[n] as JSONObject).toString()

                    n++
                }
                Log.d("municip activity", this.Municipiolist.toString())


                // Configuración del adaptador y enlace de datos
                spinerMunicipio!!.onItemSelectedListener = this
                val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, Municipiolist)
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinerMunicipio!!.adapter = aa

            } catch (e: JSONException) {
                Log.d("municip activity error", this.Municipiolist.toString())
            }
        },{ error ->

        })
        queue2.add(stringRequest)

            val stringRequest2 = StringRequest(Request.Method.GET, url, { response ->
                val jsonArray = JSONArray(response)

            this.Departamanetoslist = ArrayList()
            try {
                var i = 0
                val l = jsonArray.length()

                while (i < l) {
                    Departamanetoslist.add(jsonArray[i] as JSONObject).toString()
                    i++
                }
                Log.d("depart activity error", this.Departamanetoslist.toString())

                // Configuración del adaptador y enlace de datos
                spinerDepartamento!!.onItemSelectedListener = this
                val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, Departamanetoslist)
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinerDepartamento!!.adapter = aa

            } catch (e: JSONException) {
                Log.d("municip activity error", this.Departamanetoslist.toString())

            }

        }, { error ->

        })
        queue.add(stringRequest2)

        // Resto del código...
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        textView_msg!!.text = ""+Departamanetoslist[position].toString()
        if (Municipiolist.isNotEmpty()) {
            textView_msg2!!.text = "" + Municipiolist[position].toString()
        }



    }





    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    // Resto del código...
}

        /*
        textView_msg = findViewById(R.id.msg)
        spinerDepartamento = findViewById(R.id.SpinnerDepartamentos)
        //codigo array
        val url = "http://192.168.104.149:8080/listardepa"


        /*val url= "http://localhost/DatosBdAgro/bdagro.php"*/


        val queue = Volley.newRequestQueue(this)
        Log.d("List Product", "error")
        val stringRequest = StringRequest(Request.Method.GET, url, { response ->
            val jsonArray = JSONArray(response)
            this.Departamanetoslist = ArrayList()
            try {
                var i = 0
                val l = jsonArray.length()

                while (i < l) {
                    Departamanetoslist.add(jsonArray[i] as JSONObject)
                    i++
                }
                Log.d("product fragment", this.Departamanetoslist.toString())


            } catch (e: JSONException) {

            }

        }, { error ->

        })
        queue.add(stringRequest)




        spinerDepartamento!!.setOnItemSelectedListener(this)

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, Departamanetoslist )
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinerDepartamento!!.setAdapter(aa)
        /*
         //codigo fin array


       ListarDepartamentos()
       */

    }




    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        textView_msg!!.text = "Selected :  "+Departamanetoslist[position]
        ech

        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}*/
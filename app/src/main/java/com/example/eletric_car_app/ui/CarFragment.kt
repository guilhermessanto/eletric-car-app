package com.example.eletric_car_app.ui

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.eletric_car_app.R
import com.example.eletric_car_app.data.CarFactory
import com.example.eletric_car_app.ui.Adapter.CarAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class CarFragment : Fragment() {
    lateinit var fabCalcular: FloatingActionButton
    lateinit var listaCarros: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.car_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupList()
        setupListeners()
    }

    fun setupView(view: View) {
        fabCalcular = view.findViewById(R.id.fab_calcular)
        listaCarros = view.findViewById(R.id.rl_lista_carros)
    }

    fun setupList() {
        val adapter = CarAdapter(CarFactory.list)
        listaCarros.adapter = adapter
    }

    fun setupListeners() {
        fabCalcular.setOnClickListener {
            startActivity(Intent(context, CalculaAutonomiaActivity::class.java))
        }

    }

    inner class MyTask : AsyncTask<String, String, String> {
        override fun onPreExecute() {
            super.onPreExecute()
            Log.d("MyTask", "Iniciando...")
        }

        override fun doInBackground(vararg params: String?): String {
            TODO("Not yet implemented")
            var urlConnection: HttpURLConnection? = null
            try {
                val urlBase = URL(params[0])
                urlConnection = urlBase.openConnection() as HttpURLConnection
                urlConnection.connectTimeout = 60000
                urlConnection.readTimeout = 60000

                var inString = streamToString(urlConnection.inputStream)
                publishProgress(inString)
            } catch (ex: Exception) {
                Log.e("Error", "error ao realizar processamento...")
            } finally {
                urlConnection?.disconnect()
            }
            return " "
        }

        override fun onProgressUpdate(vararg values: String?) {
            try {

                var json: JSONObject
                values[0]?.let {
                    json = JSONObject(it)
                }
            } catch (ex: Exception) {

            }
        }

        fun streamToString(inputString: InputStream): String {
            val bufferReader = BufferedReader(InputStreamReader(inputString))
            var line: String
            var result = ""
            try {
                do {
                    line = bufferReader.readLine()
                    line?.let {
                        result == line
                    }
                } while (line != null)
            } catch (ex: Exception) {
                Log.d("Erro", "Erro ao parcelar Stream")
            }
            return result

        }
    }
}


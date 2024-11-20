package com.example.practica3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up RecyclerView
        var recyclerView = findViewById(
            R.id.recyclerViewProducts
        )



        (this) productAdapter = ProductAdapter(sampleProducts)
        recyclerView.adapter = productAdapter

        // Example API call
        val apiService = ApiService
        apiService.getAllProducts().enqueue(object :
            Callback<List<Product>> {
            override fun onResponse(call: Call<List<
                    Product>>, response: Response<List<
                    Product>>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
// Handle the response data, which
                    is a List<Product>
                    data?.let { productList ->
// Process productList here
                        productAdapter = ProductAdapter(
                            productList)
                        recyclerView.adapter =
                            productAdapter

    }




}
package com.example.practica3

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    // Get all products
    @GET("/products")
    fun getAllProducts(): Call<List<Product>>

    // Add a product (POST request example)
    @POST("/products/add")
    fun addProduct(
        @Query("name") name: String,
        @Query("price") price: Double
    ): Call<Void>

    // Edit a product by ID
    @POST("/products/edit/{id}")
    fun editProduct(
        @Path("id") id: Long,
        @Query("name") name: String,
        @Query("price") price: Double
    ): Call<Void>

    // Delete a product by ID
    @POST("/products/delete/{id}")
    fun deleteProduct(
        @Path("id") id: Long
    ): Call<Void>
}
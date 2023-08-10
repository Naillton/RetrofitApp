package com.example.retrofitapp.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Criando classe para instanciar uma conexao com o retrofit,
 * a classe vai conter um companion object que tera uma funcao de acesso a url da api.
 */
class RetrofitInstance {

    companion object {
        val BASE_URL = "https://jsonplaceholder.typicode.com"

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }
}
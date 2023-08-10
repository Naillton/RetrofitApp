package com.example.retrofitapp.retrofit.albumservice

import com.example.retrofitapp.retrofit.album.Album
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Criando interface, onde os metodos http e funcoes para acessar a api serao implementados
 */
interface AlbumService {

    @GET("/albums")
    suspend fun getAllAlbums(): Response<Album>

    @GET("/albums")
    suspend fun getAlbumsByUserId(@Query ("userId") userId: Int): Response<Album>

    @GET("/albums")
    suspend fun getAlbumByUserId(@Query ("userId") userId: Int, @Query ("id") id: Int): Response<Album>
}
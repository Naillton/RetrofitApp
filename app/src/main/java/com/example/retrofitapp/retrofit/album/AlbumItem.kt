package com.example.retrofitapp.retrofit.album

import com.google.gson.annotations.SerializedName

/**
 * Criando classe de dados POJO que sera usada como referencia a nossos dados na api fake,
 * o @SerializedName fara com que as constantes informadas serão serilializados com os valores
 * passados pelos (). Os valores abaixo condizem com os valores do objeto json e não precisariamos
 * usar o Serialized, mas, se tivessemos um campo name no nosso objeto json mas na classe POJO
 * chamamos ele de title o Serialized ficaria como name para poder fazer referencia ao objeto
 */
data class AlbumItem (
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)
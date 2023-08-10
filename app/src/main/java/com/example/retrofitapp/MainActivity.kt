package com.example.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.retrofitapp.databinding.ActivityMainBinding
import com.example.retrofitapp.retrofit.RetrofitInstance
import com.example.retrofitapp.retrofit.album.Album
import com.example.retrofitapp.retrofit.albumservice.AlbumService
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val retrofit = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        val responseLiveData: LiveData<Response<Album>> =
            liveData {
                // val response = retrofit.getAllAlbums()
                // val response = retrofit.getAlbumsByUserId(6)
                val response = retrofit.getAlbumByUserId(6, 51)
                emit(response)
            }

        responseLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()

            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumItem = albumList.next()
                    // val id = "Id: ${albumItem.id}"
                    // usando append para inserir varios elementos de uma so vez em um textView
                    // binding.titleId.append(title)
                    val title = "Title: ${albumItem.title}"
                    val userId = "id: ${albumItem.userId}"
                    val id = "id: ${albumItem.id}"
                    binding.userId.text = userId
                    binding.defaultId.text = id
                    binding.titleId.text = title
                }
            }
        })
    }
}
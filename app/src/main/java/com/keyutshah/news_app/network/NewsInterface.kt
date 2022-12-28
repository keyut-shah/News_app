package com.keyutshah.news_app.network

import com.keyutshah.news_app.data.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "50d0d3cd7257427bb764b76597fc0d58"


interface NewsInterface {

    @GET("v2/top-headlines?country=in&apiKey=$API_KEY&pageSize=100")
    fun getHeadLines(@Query("country") country: String,@Query("page") page : Int) : Call<News>

    @GET("v2/everything?q=agriculture&apiKey=$API_KEY")
    fun getAllNews(@Query("q") q: String,@Query("page") page : Int) : Call<News>

}

object NewsService{

    val newsInstance: NewsInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}
package genderizeapp.kotlin.com.genderize

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    private val client = OkHttpClient.Builder()


    private val builder = Retrofit.Builder()
        .baseUrl("https://api.genderize.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client.build())

    private val retrofit = builder.build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}
package genderizeapp.kotlin.com.genderize

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET("?name=luc")
    fun getLuc() : Call<GenderModel>

}
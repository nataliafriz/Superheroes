package cl.desafiolatam.superheroes.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {
    companion object {
        private const val BASE_uRL = "https://akabab.github.io/superhero-api/api/"
        fun retrofitClient () : API {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_uRL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(API::class.java)
        }
    }
}
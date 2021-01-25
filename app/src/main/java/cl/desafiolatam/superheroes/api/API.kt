package cl.desafiolatam.superheroes.api


import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface API {

    @GET(" /all.json")
    suspend fun getSuperHeroes(): Response<List<SuperHeroes>>
}
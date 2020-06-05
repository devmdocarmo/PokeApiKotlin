package py.com.roshka.listapokemones.apirest

import py.com.roshka.listapokemones.models.ListaPokemones
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokeAPI {

@GET("pokemon")
fun getListaPokemones(@Query("limit") limit : Int, @Query("offset") offset : Int): Call<ListaPokemones>



    companion object{
        val instance:PokeAPI by lazy{
            val builder = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
            builder.build().create(PokeAPI::class.java)
        }
    }
}
package py.com.roshka.listapokemones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import py.com.roshka.listapokemones.adapter.PokeAdapter
import py.com.roshka.listapokemones.apirest.PokeAPI
import py.com.roshka.listapokemones.models.ListaPokemones
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var pokeadapter : PokeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PokeAPI.instance.getListaPokemones(15, 0).enqueue(
            object: Callback<ListaPokemones> {
                override fun onFailure(call: Call<ListaPokemones>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(call: Call<ListaPokemones>, response: Response<ListaPokemones>) {
                    if (response.isSuccessful) {
                        val listaPokemon = response.body()
                        val pokemones = listaPokemon!!.results
                        pokeadapter = PokeAdapter(pokemones)
                        listaPokemonesRecycler.apply {
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = pokeadapter
                        }
                    }else{
                        Toast.makeText(this@MainActivity, "NO HUBO RESPUESTA EXITOSA", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        )
    }

}


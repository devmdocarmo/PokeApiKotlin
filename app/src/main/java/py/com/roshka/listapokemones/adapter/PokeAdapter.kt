package py.com.roshka.listapokemones.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import py.com.roshka.listapokemones.R
import py.com.roshka.listapokemones.models.Result

class PokeAdapter(val lista : List<Result>) : RecyclerView.Adapter<PokeAdapter.PokeHolder>() {
    class PokeHolder(view : View) : RecyclerView.ViewHolder(view) {
            var nombreView = view.findViewById<TextView>(R.id.nombrePokemon)
            var photoPoke = view.findViewById<ImageView>(R.id.photoPoke)
        fun bind(nombre : String, position : Int){
            nombreView.text = nombre
            Picasso.get()
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${position+1}.png")
                .into(photoPoke);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeAdapter.PokeHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.formato_recycler, parent, false)
        return PokeHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: PokeAdapter.PokeHolder, position: Int) {
        holder.bind(lista[position].name, position)
    }
}
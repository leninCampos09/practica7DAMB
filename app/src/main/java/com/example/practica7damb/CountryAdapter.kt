package com.example.practica7damb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(
    private val countryList: List<Country>,
    private val onItemClicked: (Country) -> Unit
) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private var filteredList: List<Country> = countryList // Lista filtrada inicializada con la lista completa

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flagImageView: ImageView = itemView.findViewById(R.id.imageView)
        val countryNameTextView: TextView = itemView.findViewById(R.id.textViewCountryName)

        fun bind(country: Country, onItemClicked: (Country) -> Unit) {
            flagImageView.setImageResource(country.flag)
            countryNameTextView.text = country.name
            itemView.setOnClickListener { onItemClicked(country) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int = filteredList.size // Cambiar para contar elementos filtrados

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(filteredList[position], onItemClicked)
    }

    fun filter(query: String?) {
        filteredList = if (query.isNullOrEmpty()) {
            countryList // Si la consulta está vacía, muestra la lista completa
        } else {
            countryList.filter { country ->
                country.name.contains(query, ignoreCase = true) // Filtrar por nombre de país
            }
        }
        notifyDataSetChanged() // Notificar al adaptador que la lista ha cambiado
    }
}

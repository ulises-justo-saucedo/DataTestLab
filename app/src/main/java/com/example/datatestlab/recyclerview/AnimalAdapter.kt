package com.example.datatestlab.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.datatestlab.R

class AnimalAdapter(private val animals: List<Animal>) : RecyclerView.Adapter<AnimalHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalHolder {
        return AnimalHolder(LayoutInflater.from(parent.context).inflate(R.layout.animal_element,parent,false))
    }

    override fun getItemCount(): Int = animals.size

    override fun onBindViewHolder(holder: AnimalHolder, position: Int) {
        holder.render(animals[position])
    }

}
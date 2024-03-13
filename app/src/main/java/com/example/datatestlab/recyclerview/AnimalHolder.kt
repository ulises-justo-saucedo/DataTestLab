package com.example.datatestlab.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datatestlab.R


class AnimalHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvName = view.findViewById<TextView>(R.id.tvName)
    var tvType = view.findViewById<TextView>(R.id.tvType)
    var tvAge = view.findViewById<TextView>(R.id.tvAge)
    fun render(animal: Animal){
        tvName.setText(animal.name)
        tvType.setText(animal.type)
        tvAge.setText(animal.age)
    }

}
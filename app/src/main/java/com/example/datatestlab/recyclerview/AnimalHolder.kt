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
        tvName.text = "NAME: "+animal.name
        tvType.text = "TYPE: "+animal.type
        tvAge.text = "AGE: "+animal.age.toString()
    }
}
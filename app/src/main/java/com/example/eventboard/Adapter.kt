package com.example.eventboard

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eventboard.databinding.ElementBinding
import com.squareup.picasso.Picasso

class Adapter(private val values: List<Events>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ElementBinding.inflate(LayoutInflater.from(parent.context))
        var view = binding.root
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name?.text = values[position].name
        holder.date?.text = values[position].date
        Picasso.get().load(values[position].image).into(holder.image)
    }

    override fun getItemCount() = values.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding = ElementBinding.inflate(LayoutInflater.from(itemView.context))
        var image: ImageView? = null
        var name: TextView? = null
        var date: TextView? = null

        init {
            image = binding.image
            name = binding.eventName
            date = binding.date
        }
    }
}
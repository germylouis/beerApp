package com.example.beerapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beerapp.data.entities.Beer
import com.example.beerapp.databinding.BeersListViewBinding

class BeersAdapter(private val beers: List<Beer>) :
    RecyclerView.Adapter<BeersAdapter.BeersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val beerItemBinding = BeersListViewBinding.inflate(inflater, parent, false)
        return BeersViewHolder(beerItemBinding)
    }

    override fun onBindViewHolder(holder: BeersViewHolder, position: Int) {
        holder.bind(beers[position])
    }

    override fun getItemCount(): Int = beers.size

    inner class BeersViewHolder(val binding: BeersListViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(beer: Beer) {
            binding.listItem = beer
        }
    }
}

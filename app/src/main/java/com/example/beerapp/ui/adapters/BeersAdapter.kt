package com.example.beerapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.beerapp.R
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

    inner class BeersViewHolder(private val binding: BeersListViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(beer: Beer) {
            binding.listItem = beer
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(view: ImageView, url: String) {
            val circularProgressDrawable = CircularProgressDrawable(view.context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()
            Glide.with(view).asBitmap().load(url).centerCrop()
                .placeholder(circularProgressDrawable)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground).into(view)
        }
    }
}

package com.example.beerapp.ui.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.beerapp.data.entities.Beer
import com.example.beerapp.databinding.FragmentBeersBinding

class BeersFragment : DialogFragment() {
    private lateinit var binding: FragmentBeersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBeersBinding.inflate(layoutInflater)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val bundle: Bundle? = this.arguments
        if (bundle != null) {
            val bundlOfBeers: Beer? = bundle.getParcelable("beer")
            binding.beer = bundlOfBeers
        }
        return binding.root
    }
}

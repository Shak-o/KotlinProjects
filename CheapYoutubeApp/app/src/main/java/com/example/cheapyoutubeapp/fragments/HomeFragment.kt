package com.example.cheapyoutubeapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cheapyoutubeapp.R

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var button : Button
    private lateinit var text : EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.button2)
        text = view.findViewById(R.id.editTextNumber)

        button.setOnClickListener {
            val read = text.text.toString().toInt()
            var action = HomeFragmentDirections.actionHomeFragmentToDashboardFragment(read)
            findNavController().navigate(action)
        }
    }
}
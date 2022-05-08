package com.example.cheapyoutubeapp.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.cheapyoutubeapp.R

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {
    private lateinit var text : TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text = view.findViewById(R.id.textViewm)
        text.text = DashboardFragmentArgs.fromBundle(requireArguments()).amount.toString();
    }
}
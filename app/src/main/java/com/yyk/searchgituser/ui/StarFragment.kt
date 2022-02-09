package com.yyk.searchgituser.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yyk.searchgituser.R

class StarFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_star, container, false)
//        view.findViewById<Button>(R.id.to_search_from_main).setOnClickListener {
//            Navigation.findNavController(view).navigate(R.id.action_star_screen_to_search_screen)
//        }
        return view
    }
}
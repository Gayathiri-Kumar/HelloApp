package com.example.hellotube

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var videoAdapter: VideoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.homeRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        // Initialize VideoAdapter
        videoAdapter = VideoAdapter(requireContext())

        // Set adapter to RecyclerView
        recyclerView.adapter = videoAdapter

        // Mock data for demonstration
        val dataList = mutableListOf<Videoitem>(
            Videoitem(R.drawable.image1, "The best nature Images", "@gayathiri_kumar18", R.drawable.avatar),
            Videoitem(R.drawable.image2, "The best nature Images", "@gayathiri_kumar18", R.drawable.avatar),
            Videoitem(R.drawable.image3, "The best nature Images", "@gayathiri_kumar18", R.drawable.avatar),
            Videoitem(R.drawable.image4, "The best nature Images", "@gayathiri_kumar18", R.drawable.avatar),
            Videoitem(R.drawable.image5, "The best nature Images", "@gayathiri_kumar18", R.drawable.avatar),
            Videoitem(R.drawable.image6, "The best nature Images", "@gayathiri_kumar18", R.drawable.avatar),
            Videoitem(R.drawable.image7, "The best nature Images", "@gayathiri_kumar18", R.drawable.avatar),
            Videoitem(R.drawable.image8, "The best nature Images", "@gayathiri_kumar18", R.drawable.avatar),
            Videoitem(R.drawable.image9, "The best nature Images", "@gayathiri_kumar18", R.drawable.avatar),
            Videoitem(R.drawable.image10, "The best nature Images", "@gayathiri_kumar18", R.drawable.avatar),

            )

        // Set data to adapter
        videoAdapter.setData(dataList)

        return view
    }
}
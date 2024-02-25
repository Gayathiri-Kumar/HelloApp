package com.example.hellotube

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2


class ShortsFragment : Fragment() {

    private lateinit var shortsDataList: MutableList<ShortsData>
    private lateinit var viewPager2: ViewPager2
    private lateinit var shortsAdapter: ShortsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_shorts, container, false)

        // Initialize data
        shortsDataList = mutableListOf()
        viewPager2 = view.findViewById(R.id.viewpager2)
        // Add some initial data
        viewPager2.setPageTransformer(CustomPageTransformer())
        shortsDataList.add(ShortsData(
            shortsPath = "android.resource://${context?.packageName}/${R.raw.video1}",
            shortsUser = "@gayathiri_kumar18",
            shortsTitle = "Plaster Handmaking kit/ tryit #shorts #craft #viral #shortvideo",
            shortsImage = R.drawable.avatar,
            subscripe = R.drawable.subscribe
        )
        )
        shortsDataList.add(ShortsData(
                shortsPath = "android.resource://${context?.packageName}/${R.raw.video2}",
                shortsUser = "@gayathiri_kumar18",
                shortsTitle = "Plaster Handmaking kit/ tryit #shorts #craft #viral #shortvideo",
                shortsImage = R.drawable.avatar,
                subscripe = R.drawable.subscribe
            )
        )
        shortsDataList.add(ShortsData(
            shortsPath = "android.resource://${context?.packageName}/${R.raw.video3}",
            shortsUser = "@gayathiri_kumar18",
            shortsTitle = "Make paints easily with food dye #shorts #craft #viral #shortvideo",
            shortsImage = R.drawable.avatar,
            subscripe = R.drawable.subscribe
        )
        )
        shortsDataList.add(ShortsData(
            shortsPath = "android.resource://${context?.packageName}/${R.raw.video4}",
            shortsUser = "@gayathiri_kumar18",
            shortsTitle = "Home made resins for decerations  #shorts #craft #viral #shortvideo",
            shortsImage = R.drawable.avatar,
            subscripe = R.drawable.subscribe
        )
        )
        shortsDataList.add(ShortsData(
            shortsPath = "android.resource://${context?.packageName}/${R.raw.video5}",
            shortsUser = "@gayathiri_kumar18",
            shortsTitle = "creativity makes work easier #shorts #craft #viral #shortvideo",
            shortsImage = R.drawable.avatar,
            subscripe = R.drawable.subscribe
        )
        )
        shortsDataList.add(ShortsData(
            shortsPath = "android.resource://${context?.packageName}/${R.raw.video6}",
            shortsUser = "@gayathiri_kumar18",
            shortsTitle = "Plaster Handmaking kit/ tryit #shorts #craft #viral #shortvideo",
            shortsImage = R.drawable.avatar,
            subscripe = R.drawable.subscribe
        )
        )
        shortsDataList.add(ShortsData(
            shortsPath = "android.resource://${context?.packageName}/${R.raw.video7}",
            shortsUser = "@gayathiri_kumar18",
            shortsTitle = "Create Memories with your loved ones #shorts #craft #viral #shortvideo",
            shortsImage = R.drawable.avatar,
            subscripe = R.drawable.subscribe
        )
        )
        shortsDataList.add(ShortsData(
            shortsPath = "android.resource://${context?.packageName}/${R.raw.video8}",
            shortsUser = "@gayathiri_kumar18",
            shortsTitle = "Make everything attractive #shorts #craft #viral #shortvideo",
            shortsImage = R.drawable.avatar,
            subscripe = R.drawable.subscribe
        )
        )
        shortsDataList.add(ShortsData(
            shortsPath = "android.resource://${context?.packageName}/${R.raw.video9}",
            shortsUser = "@gayathiri_kumar18",
            shortsTitle = "Plaster Handmaking kit/ tryit #shorts #craft #viral #shortvideo",
            shortsImage = R.drawable.avatar,
            subscripe = R.drawable.subscribe
        )
        )
        shortsDataList.add(ShortsData(
            shortsPath = "android.resource://${context?.packageName}/${R.raw.video10}",
            shortsUser = "@gayathiri_kumar18",
            shortsTitle = "Mini Craft Things Haul/ tryit #shorts #craft #viral #shortvideo",
            shortsImage = R.drawable.avatar,
            subscripe = R.drawable.subscribe
        )
        )

        shortsAdapter = ShortsAdapter(shortsDataList, viewPager2)
        viewPager2.adapter = shortsAdapter

        return view
    }
}

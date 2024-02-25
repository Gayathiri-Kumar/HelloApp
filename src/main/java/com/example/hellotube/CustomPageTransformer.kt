package com.example.hellotube

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class CustomPageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val alpha = if (position <= -1.0f || position >= 1.0f) {
            0.0f
        } else if (position == 0.0f) {
            1.0f
        } else {
            1.0f - Math.abs(position)
        }
        page.alpha = alpha
        if (position == 0.0f) {
            page.performClick() // This line ensures the video playback starts when the page is in focus
        }
    }
}
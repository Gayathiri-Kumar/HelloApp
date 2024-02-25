package com.example.hellotube

data class ShortsData (
        val shortsTitle: String,
        val shortsUser: String,
        val shortsPath: String,
        val shortsImage: Int,
        val subscripe: Int
    )

data class Videoitem (
        val videoThumbnail: Int,
        val videoTitle: String,
        val channelName: String,
        val channelImage: Int
)

package com.example.hellotube

import android.os.Handler
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.VideoView
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2



class ShortsAdapter(private val dataList: List<ShortsData>, private val viewPager2: ViewPager2) : RecyclerView.Adapter<ShortsAdapter.ShortViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShortViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shorts, parent, false)
        return ShortViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShortViewHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data,viewPager2)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ShortViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val videoView: VideoView = itemView.findViewById(R.id.videoView)
        private val shortsUser: TextView = itemView.findViewById(R.id.shortsUser)
        private val shortsTitle: TextView = itemView.findViewById(R.id.shortsTitle)
        private val shortsImage: ImageView = itemView.findViewById(R.id.shortsImage)
        private val pauseButton: ImageView = itemView.findViewById(R.id.pauseButton)
        private val seekBar: SeekBar = itemView.findViewById(R.id.seekBar)
        private val likeButton: ImageView = itemView.findViewById(R.id.likeButton)

        init {
            videoView.setOnClickListener {
                togglePauseButton()
            }
            likeButton.setOnClickListener {
                likeButton.isSelected = !likeButton.isSelected
                val drawable = if (likeButton.isSelected) {

                    // If selected, set the checked state to true
                    ContextCompat.getDrawable(itemView.context, R.drawable.heartfilled)?.apply {
                        state = intArrayOf(android.R.attr.state_checked)
                    }
                } else {
                    // If not selected, set the checked state to false
                    ContextCompat.getDrawable(itemView.context, R.drawable.heart)?.apply {
                        state = intArrayOf(-android.R.attr.state_checked)
                    }
                }
                likeButton.setImageDrawable(drawable)
            }

            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        videoView.seekTo(progress)
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    // No implementation needed
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    // No implementation needed
                }
            })
        }
        private fun togglePauseButton() {
            if (videoView.isPlaying) {
                videoView.pause()
                pauseButton.visibility = View.VISIBLE
            } else {
                videoView.start()
                pauseButton.visibility = View.GONE
            }
        }

        private fun updateSeekBarProgress() {
            val handler = Handler()
            handler.postDelayed(object : Runnable {
                override fun run() {
                    seekBar.progress = videoView.currentPosition
                    handler.postDelayed(this, 1000)
                }
            }, 1000)
        }

            fun bind(shortsData: ShortsData, viewPager2: ViewPager2) {

            videoView.setVideoPath(shortsData.shortsPath)
            videoView.start()
            shortsUser.text = shortsData.shortsUser
            shortsTitle.text = shortsData.shortsTitle
            shortsImage.setImageResource(shortsData.shortsImage)

            videoView.setOnPreparedListener { mediaPlayer ->
                // Start playing the video
                mediaPlayer.start()
                seekBar.max = mediaPlayer.duration
                updateSeekBarProgress()
                val videoWidth = mediaPlayer.videoWidth.toFloat()
                val videoHeight = mediaPlayer.videoHeight.toFloat()
                val videoRatio = videoWidth / videoHeight

                val screenRatio = videoView.width.toFloat() / videoView.height.toFloat()

                val scaleX = videoWidth / videoView.width.toFloat()
                val scaleY = videoHeight / videoView.height.toFloat()

                if (videoRatio > screenRatio) {
                    videoView.scaleX = scaleX
                    videoView.scaleY = scaleY / videoRatio * screenRatio
                } else {
                    videoView.scaleX = scaleX / videoRatio * screenRatio
                    videoView.scaleY = scaleY
                }
                mediaPlayer.isLooping = true
                if (adapterPosition == viewPager2.currentItem) {
                    videoView.start()

            }
            }

            videoView.setOnCompletionListener { mediaPlayer ->
                mediaPlayer.start()
            }
        }
    }
}
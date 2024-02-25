package com.example.hellotube

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter(private val context: Context, private var dataList: MutableList<Videoitem>? = null) :
    RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = dataList?.get(position)
        model?.let {
            holder.videoThumbnail.setImageResource(it.videoThumbnail) // Assuming thumbnail is a drawable resource ID
            holder.videoTitle.text = it.videoTitle
            holder.channelName.text = it.channelName
            holder.channelImage.setImageResource(it.channelImage) // Assuming channelImage is a drawable resource ID
        }
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    fun setData(data: MutableList<Videoitem>) {
        this.dataList = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoThumbnail: ImageView= itemView.findViewById(R.id.videoThumbnail)
        val videoTitle: TextView = itemView.findViewById(R.id.videoTitle)
        val channelName: TextView = itemView.findViewById(R.id.channelName) // Corrected
        val channelImage: ImageView = itemView.findViewById(R.id.channelImage) // Corrected
    }
}

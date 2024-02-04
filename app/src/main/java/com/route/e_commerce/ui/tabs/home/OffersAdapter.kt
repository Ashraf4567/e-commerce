package com.route.e_commerce.ui.tabs.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.route.e_commerce.R
import com.route.e_commerce.model.Image

class OffersAdapter(private val images: List<Image>) : RecyclerView.Adapter<OffersAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = images[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(image: Image) {
            // Load and display the image using your preferred image loading library
            val imageView: ImageView = itemView.findViewById(R.id.offerImage)
            imageView.setImageResource(image.imageId)
        }
    }
}
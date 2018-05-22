package com.imnotout.kollej

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.imnotout.app.NetworkIO.GlideApp
import com.imnotout.kollej.Models.*
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.ViewTreeObserver

class MediaItemsAdapter(val collage: MediaCollage) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val mediaCollection: List<MediaLayout> = collage.mediaCollection
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.media, parent, false)
        itemView.getViewTreeObserver().addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                val lp = itemView.getLayoutParams()
                if (lp is StaggeredGridLayoutManager.LayoutParams) {
                    val aspectRatio = viewType.toFloat() / 100000
                    val colSpan = viewType % 10
                    if(colSpan == collage.spanCount) lp.isFullSpan = true
                    if(collage.orientation == StaggeredGridLayoutManager.HORIZONTAL) {
                        lp.height = (itemView.width * colSpan.toFloat() / collage.spanCount).toInt()
                        lp.width = (lp.height * aspectRatio).toInt()
//                        lp.height = (itemView.width * colSpan aspectRatio).toInt()
//                        if(colSpan == collage.spanCount) {
//                            lp.height = (itemView.width / aspectRatio).toInt()
//                        }
                    }
                    else {
                        lp.width = itemView.width
                        lp.height = (itemView.width / aspectRatio).toInt()
                    }
//                    lp.height = (itemView.width * rowSpan.toFloat() / rowCount).toInt()
//                    lp.width = (itemView.width * colSpan.toFloat() / colCount).toInt()
//                    lp.isFullSpan = if(colSpan == 3) true else false
                    itemView.setLayoutParams(lp)
                    val lm = (parent as RecyclerView).layoutManager as StaggeredGridLayoutManager
                    lm.invalidateSpanAssignments()
                }
                itemView.getViewTreeObserver().removeOnPreDrawListener(this)
                return true
            }
        })

        return MediaViewHolder(itemView)
    }
    override fun getItemViewType(position: Int): Int {
        val item = mediaCollection[position]
        return (item.aspectRatio * 100000).toInt() + item.colSpan
    }
    override fun getItemCount(): Int = mediaCollection.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MediaViewHolder).bind(position, mediaCollection[position])
    }

    inner class MediaViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(position: Int, item: MediaLayout) {
//            loadImage(view.img_photo, item.url)
            val imageView = view as ImageView
            imageView.run {
//                aspectRatio = item.aspectRatio
//                colSpan = item.colSpan
//                getLayoutParams().height = (measuredWidth / aspectRatio).toInt()
                GlideApp.with(context)
                        .load(item.url)
                        .dontAnimate()
                        .centerCrop()
                        .placeholder(drawable)
                        .into(imageView)
            }
        }
    }
}
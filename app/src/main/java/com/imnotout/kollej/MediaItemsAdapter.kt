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
import kotlinx.android.synthetic.main.media.view.*

// https://stackoverflow.com/questions/36514887/layoutmanager-for-recyclerview-grid-with-different-cell-width?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
class MediaItemsAdapter(val collage: MediaCollage) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val mediaCollection: List<MediaLayout> = collage.mediaCollection
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutItem = if(viewType == 0) R.layout.text_view else R.layout.media
        val itemView = LayoutInflater.from(parent.context).inflate(layoutItem, parent, false)
//        itemView.getViewTreeObserver().addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
//            override fun onPreDraw(): Boolean {
//                val lp = itemView.getLayoutParams()
//                if (lp is StaggeredGridLayoutManager.LayoutParams) {
//                    val itemType = if(viewType < 0) viewType * - 1 else viewType
//                    val aspectRatio = itemType.toFloat() / 100000
//                    val colSpan = itemType % 10
//                    if(colSpan == collage.spanCount) lp.isFullSpan = true
//                    if(collage.orientation == StaggeredGridLayoutManager.HORIZONTAL) {
//                        lp.height = (itemView.width * colSpan.toFloat() / collage.spanCount).toInt()
//                        lp.width = (lp.height * aspectRatio).toInt()
//                    }
//                    else {
////                        lp.width = itemView.width
//                        lp.width = itemView.width * colSpan
//                        lp.height = (lp.width / aspectRatio).toInt()
//                    }
////                    lp.height = (itemView.width * rowSpan.toFloat() / rowCount).toInt()
////                    lp.width = (itemView.width * colSpan.toFloat() / colCount).toInt()
////                    lp.isFullSpan = if(colSpan == 3) true else false
//                    itemView.setLayoutParams(lp)
//                    val lm = (parent as RecyclerView).layoutManager as StaggeredGridLayoutManager
//                    lm.invalidateSpanAssignments()
//                }
//                itemView.getViewTreeObserver().removeOnPreDrawListener(this)
//                return true
//            }
//        })

        return MediaViewHolder(itemView)
    }
    override fun getItemViewType(position: Int): Int {
        val item = mediaCollection[position]
//        val viewType = (item.aspectRatio * 100000).toInt() + item.colSpan
        return if(position == getItemCount() - 1) 0 else 1
//        return viewType
    }
    override fun getItemCount(): Int = mediaCollection.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MediaViewHolder).bind(position, mediaCollection[position])
    }

    inner class MediaViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(position: Int, item: MediaLayout) {
//            loadImage(view.img_photo, item.url)
            if(position < getItemCount() - 1) {
                GlideApp.with(view.img_photo.context)
                        .load(item.url)
                        .dontAnimate()
                        .centerCrop()
                        .into(view.img_photo)
            }

//            else {
//                GlideApp.with(view.context)
//                        .load(item.url)
//                        .dontAnimate()
//                        .centerCrop()
//                        .into(view.background)
//            }
        }
    }
}
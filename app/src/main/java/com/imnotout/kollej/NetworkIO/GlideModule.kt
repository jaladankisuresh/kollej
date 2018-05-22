package com.imnotout.app.NetworkIO

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class AppImageModule : AppGlideModule() {
    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}

fun loadImage(view: ImageView, imgPath: String,placeHolder: Int? = null, error: Int? = null): Unit {
    val imgRequest: GlideRequest<Drawable> = GlideApp.with(view.context)
            .load(imgPath)
            .dontAnimate()
            .placeholder(view.drawable)
    placeHolder?.run { imgRequest.placeholder(this) }
    error?.run { imgRequest.placeholder(this) }
    imgRequest.into(view)
}
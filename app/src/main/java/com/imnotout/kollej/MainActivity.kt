package com.imnotout.kollej

import android.content.Intent
import android.media.browse.MediaBrowser
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.GridLayout
import com.imnotout.kollej.Models.*
import kotlinx.android.synthetic.main.activity_main.*

const val assetPath = "file:///android_asset/"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_1x3_potrait.setOnClickListener{
            val mediaCollection = listOf(MediaLayout(assetPath + "IMG_3278.JPG", 3, 0.6666F),
                    MediaLayout(assetPath + "IMG_3292.JPG"), MediaLayout(assetPath + "IMG_3380.JPG"),
                    MediaLayout(assetPath + "IMG_2868.JPG"))
            val collage = MediaCollage(mediaCollection, 3, StaggeredGridLayoutManager.HORIZONTAL)

            val galleryIntent = Intent(this, GalleryActivity::class.java)
            galleryIntent.putExtra("collage", collage)
            startActivity(galleryIntent)
        }
        btn_1x3_landscape.setOnClickListener{
            val mediaCollection = listOf(MediaLayout(assetPath + "IMG_2868.JPG", 3, 1.5F),
                    MediaLayout(assetPath + "IMG_3292.JPG"), MediaLayout(assetPath + "IMG_3380.JPG"),
                    MediaLayout(assetPath + "IMG_3278.JPG"))
            val collage = MediaCollage(mediaCollection, 3, StaggeredGridLayoutManager.VERTICAL)

            val galleryIntent = Intent(this, GalleryActivity::class.java)
            galleryIntent.putExtra("collage", collage)
            startActivity(galleryIntent)
        }
        btn_1x2_potrait.setOnClickListener{
            val mediaCollection = listOf(MediaLayout(assetPath + "IMG_3278.JPG", 2, 0.6666F),
                    MediaLayout(assetPath + "IMG_3292.JPG", aspectRatio = 0.6666F), MediaLayout(assetPath + "IMG_3380.JPG", aspectRatio = 0.6666F))
            val collage = MediaCollage(mediaCollection, 2, StaggeredGridLayoutManager.HORIZONTAL)

            val galleryIntent = Intent(this, GalleryActivity::class.java)
            galleryIntent.putExtra("collage", collage)
            startActivity(galleryIntent)
        }
        btn_1x2_landscape.setOnClickListener{
            val mediaCollection = listOf(MediaLayout(assetPath + "IMG_3278.JPG", 2, 1.5F),
                    MediaLayout(assetPath + "IMG_3292.JPG", aspectRatio = 1.5F), MediaLayout(assetPath + "IMG_3380.JPG", aspectRatio = 1.5F))
            val collage = MediaCollage(mediaCollection, 2, StaggeredGridLayoutManager.VERTICAL)

            val galleryIntent = Intent(this, GalleryActivity::class.java)
            galleryIntent.putExtra("collage", collage)
            startActivity(galleryIntent)
        }
        btn_1x2_landscape_var.setOnClickListener{
            val mediaCollection = listOf(MediaLayout(assetPath + "IMG_3278.JPG", 2, 1.5F),
                    MediaLayout(assetPath + "IMG_3292.JPG"), MediaLayout(assetPath + "IMG_3380.JPG"))
            val collage = MediaCollage(mediaCollection, 2, StaggeredGridLayoutManager.VERTICAL)

            val galleryIntent = Intent(this, GalleryActivity::class.java)
            galleryIntent.putExtra("collage", collage)
            startActivity(galleryIntent)
        }
        btn_1x1_potrait.setOnClickListener{
            val mediaCollection = listOf(MediaLayout(assetPath + "IMG_3292.JPG", aspectRatio = 0.5F),
                    MediaLayout(assetPath + "IMG_3380.JPG", aspectRatio = 0.5F))
            val collage = MediaCollage(mediaCollection, 2, StaggeredGridLayoutManager.VERTICAL)

            val galleryIntent = Intent(this, GalleryActivity::class.java)
            galleryIntent.putExtra("collage", collage)
            startActivity(galleryIntent)
        }
        btn_1x1_landscape.setOnClickListener{
            val mediaCollection = listOf(MediaLayout(assetPath + "IMG_3292.JPG", aspectRatio = 2F),
                    MediaLayout(assetPath + "IMG_3380.JPG", aspectRatio = 2F))
            val collage = MediaCollage(mediaCollection, 2, StaggeredGridLayoutManager.HORIZONTAL)

            val galleryIntent = Intent(this, GalleryActivity::class.java)
            galleryIntent.putExtra("collage", collage)
            startActivity(galleryIntent)
        }
    }
}

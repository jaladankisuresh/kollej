package com.imnotout.kollej

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.*
import com.imnotout.kollej.Models.MediaCollage
import kotlinx.android.synthetic.main.activity_gallery.*
// https://stackoverflow.com/questions/36514887/layoutmanager-for-recyclerview-grid-with-different-cell-width?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
class GalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val collage: MediaCollage = intent.getSerializableExtra("collage") as MediaCollage
        val gridLayoutManager = StaggeredGridLayoutManager(collage.spanCount, collage.orientation)

        list_media_items.run {
            layoutManager = gridLayoutManager
            adapter = MediaItemsAdapter(collage)
//            addItemDecoration(ItemOffsetDecoration(context, R.dimen.item_offset))
        }
    }


}

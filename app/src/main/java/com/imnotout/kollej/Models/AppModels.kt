package com.imnotout.kollej.Models

import java.io.Serializable

class MediaCollage(val mediaCollection: List<MediaLayout>, val colCount: Int, val cellAspectRatio: Float) : Serializable
class MediaLayout(val url: String, val rowSpan: Int = 1, val colSpan: Int = 1) : Serializable
//class MediaCollage(val mediaCollection: List<MediaLayout>, val spanCount: Int, val orientation: Int) : Serializable
//class MediaLayout(val url: String, val colSpan: Int = 1, val aspectRatio: Float = 1F) : Serializable
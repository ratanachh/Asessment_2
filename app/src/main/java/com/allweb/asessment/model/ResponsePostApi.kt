package com.allweb.asessment.model

import com.google.gson.annotations.SerializedName

data class ResponsePostApi (
    val page: String,
    val posts: List<Post>,
    @SerializedName("total_pages")
    val totalPages: Int
)
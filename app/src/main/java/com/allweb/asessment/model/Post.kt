package com.allweb.asessment.model

import com.google.gson.annotations.SerializedName

data class Post(
    val date: String,
    val id: Long,
    val message: String,
    val photo: String,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("user_name")
    val username: String,
    @SerializedName("user_pic")
    val userPicture: String
)
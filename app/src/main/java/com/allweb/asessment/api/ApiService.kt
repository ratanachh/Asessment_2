package com.allweb.asessment.api

import com.allweb.asessment.model.ResponsePostApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/test")
    fun getPosts(@Query("page") page: Int): Response<ResponsePostApi>
}
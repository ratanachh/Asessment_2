package com.allweb.asessment.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.allweb.asessment.api.ApiService
import com.allweb.asessment.model.Post

class PostPagingSource(private val apiService: ApiService) : PagingSource<Int, Post>() {
    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        return null;
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        return  try {
            val currentPage = params.key ?: 1
            val response = apiService.getPosts(currentPage)
            val data = response.body()?.posts ?: emptyList()
            val responseData = mutableListOf<Post>()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
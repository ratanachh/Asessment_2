package com.allweb.asessment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.allweb.asessment.api.ApiService
import com.allweb.asessment.paging.PostPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val apiService: ApiService): ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 1)) {
        PostPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)


}
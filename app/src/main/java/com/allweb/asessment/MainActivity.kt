package com.allweb.asessment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.allweb.asessment.adapter.PostPagedAdapter
import com.allweb.asessment.databinding.ActivityMainBinding
import com.allweb.asessment.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: PostPagedAdapter
    private val postViewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycler()
        loadingData()
    }

    private fun loadingData() {
        lifecycleScope.launch {
            postViewModel.listData.collect { pagingData ->
                postAdapter.submitData(pagingData)
            }
        }
    }

    private fun initRecycler() {
        postAdapter = PostPagedAdapter()
        binding.recyclerViewPost.apply {
            adapter = postAdapter
            setHasFixedSize(true)
        }
    }
}
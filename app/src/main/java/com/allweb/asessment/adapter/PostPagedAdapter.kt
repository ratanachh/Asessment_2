package com.allweb.asessment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.allweb.asessment.adapter.PostPagedAdapter.PostViewHolder
import com.allweb.asessment.databinding.PostItemBinding
import com.allweb.asessment.model.Post

class PostPagedAdapter : PagingDataAdapter<Post, PostViewHolder>(diffCallback) {

    inner class PostViewHolder(val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.apply {
            // loading using coroutine image loader(coil) to display
            userImg.load(currentItem?.userPicture) {
                crossfade(true)
                crossfade(1000)
            }
            usernameTv.text = currentItem?.username
            postDateTv.text = currentItem?.date
            messageTv.text = currentItem?.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            PostItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}
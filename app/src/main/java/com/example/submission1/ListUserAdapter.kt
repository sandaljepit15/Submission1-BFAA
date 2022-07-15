package com.example.submission1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submission1.databinding.ListUserBinding

class ListUserAdapter(private val listUser : ArrayList<GithubUser>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    private var onListClick: OnListClick? = null

    fun setOnListClick(onListClick: OnListClick) {
        this.onListClick = onListClick
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding =
            ListUserBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size

    inner class ListViewHolder(private val binding: ListUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: GithubUser) {
            Glide.with(itemView.context)
                .load(user.avatar)
                .apply(RequestOptions().override(55, 55))
                .into(binding.listPhoto)
            binding.listUsername.text = user.username
            binding.listName.text = user.name
            itemView.setOnClickListener { onListClick?.onItemClicked(user) }
        }
    }


    interface OnListClick {
        fun onItemClicked(data: GithubUser)
    }
}


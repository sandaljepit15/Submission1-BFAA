package com.example.submission1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submission1.databinding.UserProfilBinding

class ProfileActivity : AppCompatActivity() {

    companion object {
        const val SELECTED_USER = "username"
    }

    private lateinit var binding: UserProfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val user = intent.getParcelableExtra<GithubUser>(SELECTED_USER)

        Glide.with(this)
            .load(user?.avatar)
            .apply(RequestOptions().override(70, 70))
            .into(binding.avatar)

        binding.apply {
            username.text = user?.username
            name.text = user?.name
            location.text = user?.location
            company.text = user?.company
            numberRepository.text = user?.numberOfRepository
            numberFollowers.text = user?.numberOfFollowers
            numberFollowing.text = user?.numberOfFollowing
        }
        supportActionBar?.apply {
            title = user?.username
        }

    }
}
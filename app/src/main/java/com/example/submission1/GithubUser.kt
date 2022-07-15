package com.example.submission1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class GithubUser (
        val username: String,
        val name: String,
        val location: String,
        val company: String,
        val numberOfRepository: String,
        val numberOfFollowers: String,
        val numberOfFollowing: String,
        val avatar: Int
):Parcelable

package com.example.submission1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var list = ArrayList<GithubUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvList.setHasFixedSize(true)

        list.addAll(getListUser())
        showRecycleView()
    }

    @SuppressLint("Recycle")
    private fun getListUser(): ArrayList<GithubUser> {
        val listUserName = resources.getStringArray(R.array.username)
        val listName = resources.getStringArray(R.array.name)
        val listAvatar = resources.obtainTypedArray(R.array.avatar)
        val listLocation = resources.getStringArray(R.array.location)
        val listCompany = resources.getStringArray(R.array.company)
        val listNumberOfRepository = resources.getStringArray(R.array.repository)
        val listNumberOfFollowers = resources.getStringArray(R.array.followers)
        val listNumberOfFollowing = resources.getStringArray(R.array.following)



        val listUser = ArrayList<GithubUser>()
        for (position in listUserName.indices) {
            val githubUser = GithubUser (
               username = listUserName[position],
                name = listName[position],
                avatar = listAvatar.getResourceId(position, 0),
                location = listLocation[position],
                company = listCompany[position],
                numberOfRepository = listNumberOfRepository[position],
                numberOfFollowers = listNumberOfFollowers[position],
                numberOfFollowing = listNumberOfFollowing[position]
                    )
            listUser.add(githubUser)
        }
        return listUser
    }
    private fun showRecycleView(){
        binding.rvList.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        binding.rvList.adapter = listUserAdapter
        listUserAdapter.setOnListClick(object: ListUserAdapter.OnListClick{
            override fun onItemClicked(data : GithubUser) {
                detailUser(data)            }
        } )
    }

    private fun detailUser(user: GithubUser){
      val intent = Intent(this@MainActivity,ProfileActivity::class.java)
        intent.putExtra(ProfileActivity.SELECTED_USER, user)
        startActivity(intent)
    }
}
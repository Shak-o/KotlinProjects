package com.example.apis.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apis.R
import com.example.apis.adapters.UserRecyclerAdapter
import com.example.apis.api.RestClient
import com.example.apis.api.dtos.UserList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerReview : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerReview = findViewById(R.id.recyclerView)
        RestClient.initClient()
        RestClient.reqResApi.getUsers(1).enqueue(object : Callback<UserList> {
            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                if (response.isSuccessful) {
                    response.body()?.data?.let {
                        recyclerReview.adapter = UserRecyclerAdapter(it)
                        recyclerReview.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }

            override fun onFailure(call: Call<UserList>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
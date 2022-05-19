package com.example.apis.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.apis.R
import com.example.apis.adapters.UserRecyclerAdapter.Companion.USER_ID
import com.example.apis.api.RestClient
import com.example.apis.api.dtos.User
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {
    private lateinit var name : TextView
    private lateinit var email: TextView
    private lateinit var image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        name = findViewById(R.id.textView3)
        email = findViewById(R.id.textView5)
        image = findViewById(R.id.imageView2)

        val userId = intent.extras?.getInt(USER_ID, -1)
        if (userId != -1) {
            RestClient.reqResApi.getUser(userId!!).enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        response.body()?.data?.let {
                            Picasso.get().load(it.avatar).into(image);
                            name.text = "${it.first_name} ${it.last_name}"
                            email.text = it.email
                        }
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}
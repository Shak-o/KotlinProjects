package com.example.apis.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.apis.R
import com.example.apis.adapters.ResourceRecyclerAdapter
import com.example.apis.api.RestClient
import com.example.apis.api.dtos.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResourceActivity : AppCompatActivity() {
    private lateinit var name : TextView
    private lateinit var color : TextView
    private lateinit var year : TextView
    private lateinit var panton : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)
        name = findViewById(R.id.textView9)
        color = findViewById(R.id.textView10)
        panton = findViewById(R.id.textView11)
        year = findViewById(R.id.textView12)

        val resourceId = intent.extras?.getInt(ResourceRecyclerAdapter.RESOURCE_ID, -1)
        if (resourceId != -1) {
            RestClient.reqResApi.getResource(resourceId!!).enqueue(object : Callback<Resource> {
                override fun onResponse(call: Call<Resource>, response: Response<Resource>) {
                    if (response.isSuccessful) {
                        response.body()?.data?.let {
                            name.text = it.name
                            color.text = it.color
                            year.text = it.year.toString()
                            panton.text = it.pantone_value
                        }
                    }
                }

                override fun onFailure(call: Call<Resource>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}
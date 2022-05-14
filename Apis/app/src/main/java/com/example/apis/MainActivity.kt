package com.example.apis

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import retrofit2.HttpException
import java.io.IOException
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launchWhenCreated {
            val responseUsers  = try {
                RetrofitInstance.api.getUsers();
            }
            catch (e: HttpException) {
                Log.e(TAG,e.message.toString())
                return@launchWhenCreated
            }
            catch (e: IOException) {
                Log.e(TAG, e.message.toString())
                return@launchWhenCreated
            }

            val responseUser  = try {
                RetrofitInstance.api.getUser();
            }
            catch (e: HttpException) {
                Log.e(TAG,e.message.toString())
                return@launchWhenCreated
            }
            catch (e: IOException) {
                Log.e(TAG, e.message.toString())
                return@launchWhenCreated
            }

            val responsePutUser  = try {
                RetrofitInstance.api.updateUser(CreateUserCommand("test up", "bad"));
            }
            catch (e: HttpException) {
                Log.e(TAG,e.message.toString())
                return@launchWhenCreated
            }
            catch (e: IOException) {
                Log.e(TAG, e.message.toString())
                return@launchWhenCreated
            }

            val responsePostUser  = try {
                RetrofitInstance.api.createUser(CreateUserCommand("test", "jobTest"));
            }
            catch (e: HttpException) {
                Log.e(TAG,e.message.toString())
                return@launchWhenCreated
            }
            catch (e: IOException) {
                Log.e(TAG, e.message.toString())
                return@launchWhenCreated
            }

            if (responsePutUser.body() != null && responsePutUser.isSuccessful ) {
                var resp = responsePutUser.body()!!
                println("Updated: " + resp.name + " " + resp.job)
            }

            if (responsePostUser.body() != null && responsePostUser.isSuccessful ) {
                var resp = responsePostUser.body()!!
                println("Created: " + resp.name + " " + resp.job)
            }

            if (responseUser.body() != null && responseUser.isSuccessful ) {
                println(responseUser.body()!!.data.first_name)
            }

            if (responseUsers.body() != null && responseUsers.isSuccessful ){
                for(u in responseUsers.body()!!.data) {
                    println(u.first_name + " " + u.last_name)
                }
            }
        }
    }
}
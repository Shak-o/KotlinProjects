package com.example.apis.api

import com.example.apis.api.dtos.*
import retrofit2.Response
import retrofit2.Call
import retrofit2.http.*

interface ReqResApi {
    @GET("/api/users/{userId}")
    fun getUser(@Path("userId") userId: Int) : Call<User>

    @GET("/api/users")
    fun getUsers(@Query("page") page: Int) : Call<UserList>

    @POST("/api/users")
    fun createUser(@Body user: CreateUserCommand) : Call<CreateUserResponse>

    @PUT("/api/users/{userId}}")
    fun updateUser(@Path("userId") userId: Long, @Body user: CreateUserCommand) : Call<UpdateUserResponse>
}

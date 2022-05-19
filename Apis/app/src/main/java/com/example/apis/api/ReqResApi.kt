package com.example.apis.api

import retrofit2.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ReqResApi {
    @GET("/api/users/1")
    fun getUser() : Call<User>

    @GET("/api/users?page=1")
    fun getUsers() : Call<UserList>

    @POST("/api/users")
    fun createUser(@Body user: CreateUserCommand) : Call<CreateUserResponse>

    @PUT("/api/users/1")
    fun updateUser(@Body user: CreateUserCommand) : Call<UpdateUserResponse>
}

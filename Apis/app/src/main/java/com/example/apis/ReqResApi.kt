package com.example.apis

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ReqResApi {
    @GET("/api/users/1")
    suspend fun getUser() : Response<User>

    @GET("/api/users?page=1")
    suspend fun getUsers() : Response<UserList>

    @POST("/api/users")
    suspend fun createUser(@Body user: CreateUserCommand) : Response<CreateUserResponse>

    @PUT("/api/users/1")
    suspend fun updateUser(@Body user: CreateUserCommand) : Response<UpdateUserResponse>
}

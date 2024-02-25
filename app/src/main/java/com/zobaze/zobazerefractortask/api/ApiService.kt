package com.zobaze.zobazerefractortask.api

import retrofit2.http.GET

interface ApiService {
    @GET("employees")
    suspend fun getEmployees(): GetEmployeeResponse
}
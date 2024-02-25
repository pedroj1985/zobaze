package com.zobaze.zobazerefractortask.base

import RetrofitClient
import com.zobaze.zobazerefractortask.MainApplication
import com.zobaze.zobazerefractortask.api.GetEmployeeResponse
import com.zobaze.zobazerefractortask.utils.NetworkHandler
import retrofit2.HttpException
import java.net.SocketTimeoutException


class MainRepository(application: MainApplication) {

    val networkHandler by lazy {
        NetworkHandler(application)
    }

    private val apiService by lazy {
        RetrofitClient().apiService
    }

    suspend fun getEmployeeList(): GetEmployeeResponse {

        val siteListResponse = try {
            apiService.getEmployees()
        } catch (e: java.lang.Exception) {
            GetEmployeeResponse.empty().copy(message = getMessage(e))
        }

        return siteListResponse
    }

    private fun getMessage(e: java.lang.Exception): String {
        return when (e) {
            is HttpException -> {
                when (e.code()) {
                    401 -> "Unauthorised"
                    404 -> "Resource not found"
                    else -> "Something went wrong"
                }
            }
            is SocketTimeoutException -> {
                "Timeout"
            }
            else -> "Something went wrong"
        }
    }
}
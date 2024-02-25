package com.zobaze.zobazerefractortask.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class
GetEmployeeResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val data: ArrayList<Employee>
): Parcelable {
    companion object {
        fun empty() = GetEmployeeResponse(status = "", data = arrayListOf(), message = "")
    }
}
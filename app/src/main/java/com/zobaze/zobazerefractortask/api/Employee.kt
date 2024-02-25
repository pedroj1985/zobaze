package com.zobaze.zobazerefractortask.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Employee(
    @SerializedName("id")
    val id: Int,
    @SerializedName("employee_name")
    val employeeName: String,
    @SerializedName("employee_salary")
    val employeeSalary: Int,
    @SerializedName("employee_age")
    val employeeAge: Int,
    @SerializedName("profile_image")
    val profileImage: String
) : Parcelable




package com.zobaze.zobazerefractortask.ui

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zobaze.zobazerefractortask.MainApplication
import com.zobaze.zobazerefractortask.api.Employee
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val mainRepository by lazy {
        (application as MainApplication).appCompositionRoot.repository
    }

    private val _employeeList: MutableLiveData<ArrayList<Employee>> = MutableLiveData(arrayListOf())
    val employeeList: LiveData<ArrayList<Employee>> = _employeeList

    private val _showProgress: MutableLiveData<Int> = MutableLiveData(View.GONE)
    val showProgress: LiveData<Int> = _showProgress

    private val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String> = _errorMessage


    fun getEmployees() {
        viewModelScope.launch {
            if (mainRepository.networkHandler.isNetworkAvailable()) {
                _showProgress.postValue(View.VISIBLE)
                val employeeListResponse = mainRepository.getEmployeeList()
                _showProgress.postValue(View.GONE)
                if(employeeListResponse.status == "success") {
                    val list = arrayListOf<Employee>()
                    employeeListResponse.data.filterTo(list) { it.id % 3 == 0 }
                    employeeListResponse.data.filterTo(list) { it.id % 7 == 0 }
                    employeeListResponse.data.filterTo(list) { it.id % 4 == 0 }
                    _employeeList.postValue(list)
                }else {
                    _errorMessage.postValue(employeeListResponse.message)
                }

            } else {
                _errorMessage.postValue("No internet")
            }

        }
    }


}
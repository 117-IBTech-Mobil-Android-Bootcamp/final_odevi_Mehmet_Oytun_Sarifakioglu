package com.oytuns.finalhomework.viewmodel

import android.location.Location
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oytuns.finalhomework.model.Cities
import com.oytuns.finalhomework.repository.LocationRepository
import com.oytuns.finalhomework.resource.Resource
import com.oytuns.finalhomework.service.WeatherAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: LocationRepository) : ViewModel() {

    var locationList = mutableStateOf<List<Cities>>(listOf())
    var errorMessage = mutableStateOf("")
    var loading = mutableStateOf(false)

    private var initalList = listOf<Cities>()
    private var isSearchStart = Boolean

    init {
        loadLocations()
    }

    fun searchList(query : String){
        val listToSearch = if(isSearchStart.equals(true)){
            locationList.value
        }else{
            initalList
        }

        viewModelScope.launch(Dispatchers.Default) {
            if (query.isEmpty()){
                locationList.value = initalList
                //isSearchStart = true
                return@launch
            }

            val results = listToSearch.filter {
                it.name.contains(query.trim(),ignoreCase = true)
            }

            if (isSearchStart.equals(true)){
                initalList = locationList.value
            }

            locationList.value = results
        }
    }

    fun loadLocations(){
        viewModelScope.launch {
            loading.value = true
            val result = repository.getLocationList()
            when(result){
                is Resource.Success -> {
                    val localItem = result.data!!
                    errorMessage.value = ""
                    loading.value = false
                    locationList.value = localItem
                }
                is Resource.Error -> {
                    errorMessage.value = result.message!!
                    loading.value = true
                }
            }


        }
    }
}
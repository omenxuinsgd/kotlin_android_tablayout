package com.example.ghapi.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ghapi.network.GithubApi
import com.example.ghapi.network.GithubData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewViewModel: ViewModel() {
//    private val _response = MutableLiveData<String>()
//
//    val response : LiveData<String>
//        get() = _response
    private val _items = MutableLiveData<List<GithubData>>()

    val items : LiveData<List<GithubData>>
        get() = _items

    private val _response = MutableLiveData<String>()

    val response : LiveData<String>
        get() = _response

    private var vmJob = Job()
    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)

    init {
        initData()
    }

    private fun initData(){
//        _response.value = "just data placeholder"
//        GithubApi.retrofitService.showList().enqueue(object: Callback<List<GithubData>>{
//            override fun onFailure(call: Call<List<GithubData>>, t: Throwable){
//                _response.value = "FAILED"
//            }
//            override fun onResponse(call: Call<List<GithubData>>, response: Response<List<GithubData>>){
////                _response.value = response.body()
//                _response.value = "Berhasil..."
//            }
//        })
//        _response.value = "just data placeholder"
        _response.value = "Loading..."
        crScope.launch{
            try{
//                val item = GithubApi.retrofitService.showList()
//                _response.value = "berhasil"
                val result = GithubApi.retrofitService.showList()
                if(result.size > 0){
                    _items.value = result
                    _response.value = "OK"
                }
            }catch(t: Throwable){
//                _response.value = "gagal"
                _response.value = "Failed, internet OFF"

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}

package com.example.ghapi.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ghapi.network.GithubApi
import com.example.ghapi.network.GithubData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DeatilViewModel(username: String): ViewModel() {
    private val _item = MutableLiveData<GithubData>()

    val item : LiveData<GithubData>
        get() = _item

    private var vmJob = Job()
    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)

    init {
        Log.d("debug", "in view model " + username)
        crScope.launch{
            try{
//                val item = GithubApi.retrofitService.showList()
//                _response.value = "berhasil"
                val result = GithubApi.retrofitService.showUser(username)
                    _item.value = result
            }catch(t: Throwable){
//                _response.value = "gagal"

            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}
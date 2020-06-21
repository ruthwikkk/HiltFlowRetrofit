package com.ruthwikkk.sample.flowhiltretrofit.viewmodels

import android.app.Application
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ruthwikkk.sample.flowhiltretrofit.api.AppRepository
import com.ruthwikkk.sample.flowhiltretrofit.models.Rocket
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

class MainViewModel @ViewModelInject constructor(application: Application, private val repository: AppRepository) : AndroidViewModel(application) {

   val rocketsLiveData = liveData<List<Rocket>> {
        repository.getRocketsData()
            .onStart {
                //Set loading here
            }
            .catch {
                //Set Error here
            }
            .collect {
               emit(it)
            }
    }
}
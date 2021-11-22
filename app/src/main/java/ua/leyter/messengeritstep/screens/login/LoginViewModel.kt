package ua.leyter.messengeritstep.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ua.leyter.messengeritstep.data.cache.sharedPreference.SharedPreferenceUserService
import ua.leyter.messengeritstep.domain.common.Response
import ua.leyter.messengeritstep.domain.models.LoginRequest
import ua.leyter.messengeritstep.domain.models.LoginResponse
import ua.leyter.messengeritstep.domain.repositories.AuthRepository

class LoginViewModel(
    private val repository: AuthRepository,
    private val preference: SharedPreferenceUserService
    ) : ViewModel() {

    lateinit var loadingResult:MutableLiveData<Response<LoginResponse>>

    fun Login(data:LoginRequest):Unit{
        repository.login(data)
    }

}
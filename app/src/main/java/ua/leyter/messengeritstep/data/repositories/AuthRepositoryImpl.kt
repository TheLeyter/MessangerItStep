package ua.leyter.messengeritstep.data.repositories

import android.util.Log
import android.view.KeyEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response as RetrofitResponse
import ua.leyter.messengeritstep.data.network.services.AuthServices
import ua.leyter.messengeritstep.domain.models.*
import ua.leyter.messengeritstep.domain.repositories.AuthReposieory
import ua.leyter.messengeritstep.domain.common.Response

class AuthRepositoryImpl(private val authServices: AuthServices) : AuthReposieory {

    override fun register(data: RegisterRequest): RegisterResponse {
        TODO("Not yet implemented")
    }

    override fun login(data: LoginRequest): Flow<Response<LoginResponse>> {
        return flow{
            emit(Response.Loading<LoginResponse>())
            try {
                var data = authServices.Login(data)
                if(data.isSuccessful){
                    emit(Response.Success<LoginResponse>(data.body()!!))
                }
                else{
                    when(data.code()){
                        404 -> emit(Response.Error<LoginResponse>(data.message()))
                        505 -> emit(Response.Error<LoginResponse>("Server error!!!"))
                    }
                }
            }
            catch (e: Exception){
                Log.e("LoginRepository",e.message!!)
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun confirmEmail(data: ConfirmRequest): ConfirmResponse {
        TODO("Not yet implemented")
    }

}



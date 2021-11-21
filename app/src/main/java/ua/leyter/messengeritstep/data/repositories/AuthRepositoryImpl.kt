package ua.leyter.messengeritstep.data.repositories

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import ua.leyter.messengeritstep.data.network.services.AuthServices
import ua.leyter.messengeritstep.domain.models.*
import ua.leyter.messengeritstep.domain.common.Response
import ua.leyter.messengeritstep.domain.repositories.AuthRepository

class AuthRepositoryImpl(private val authServices: AuthServices) : AuthRepository {

    override fun register(data: RegisterRequest): Flow<Response<RegisterResponse>> {
        return flow{
            emit(Response.Loading<RegisterResponse>())
            try {
                var response = authServices.Register(data)
                if(response.isSuccessful){
                    emit(Response.Success<RegisterResponse>(response.body()))
                }
                else{
                    when(response.code()){
                        404 -> emit(Response.Error<RegisterResponse>(response.message()))
                        505 -> emit(Response.Error<RegisterResponse>("Server error!!!"))
                    }
                }
            }
            catch (e: Exception){
                Log.e("AuthRepository",e.message!!)
            }

        }.flowOn(Dispatchers.IO)
    }

    override fun login(data: LoginRequest): Flow<Response<LoginResponse>> {
        return flow{
            emit(Response.Loading<LoginResponse>())
            try {
                var response = authServices.Login(data)
                if(response.isSuccessful){
                    emit(Response.Success<LoginResponse>(response.body()))
                }
                else{
                    when(response.code()){
                        404 -> emit(Response.Error<LoginResponse>(response.message()))
                        505 -> emit(Response.Error<LoginResponse>("Server error!!!"))
                    }
                }
            }
            catch (e: Exception){
                Log.e("AuthRepository",e.message!!)
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun confirmEmail(data: ConfirmRequest): Flow<Response<ConfirmResponse>> {
        return flow {
            emit(Response.Loading<ConfirmResponse>())
            try {
                var response = authServices.Confirm(data)
                if(response.isSuccessful){
                    emit(Response.Success<ConfirmResponse>(response.body()))
                }
                else{
                    when(response.code()){
                        404 -> emit(Response.Error<ConfirmResponse>(response.message()))
                        505 -> emit(Response.Error<ConfirmResponse>("Server error!!!"))
                    }
                }
            }
            catch (e: Exception){
                Log.e("AuthRepository",e.message!!)
            }
        }.flowOn(Dispatchers.IO)
    }

}



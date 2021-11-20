package ua.leyter.messengeritstep.data.network.services

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import ua.leyter.messengeritstep.domain.models.*

interface AuthServices {

    companion object{
        private const val controllerName = "auth"
    }

    @POST("$controllerName/login")
    suspend fun Login(@Body request:LoginRequest): Response<LoginResponse>

    @POST("$controllerName/register")
    suspend fun Register(@Body request: RegisterRequest): Response<RegisterResponse>

    @POST("$controllerName/confirm")
    suspend fun Confirm(@Body request: ConfirmRequest): Response<ConfirmResponse>

}
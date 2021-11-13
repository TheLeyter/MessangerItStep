package ua.leyter.messengeritstep.data.network.services

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import ua.leyter.messengeritstep.domain.models.*

interface AuthServices {

    companion object{
        private const val controllerName = "auth"
    }

    @POST("$controllerName/login")
    fun Login(@Body request:LoginRequest): Call<LoginResponse>

    @POST("$controllerName/register")
    fun Register(@Body request: RegisterRequest): Call<RegisterResponse>

    @POST("$controllerName/confirm")
    fun Confirm(@Body request: ConfirmRequest):Call<ConfirmResponse>

}
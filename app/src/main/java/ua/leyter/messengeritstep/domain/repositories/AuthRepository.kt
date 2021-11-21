package ua.leyter.messengeritstep.domain.repositories

import kotlinx.coroutines.flow.Flow
import ua.leyter.messengeritstep.domain.common.Response
import ua.leyter.messengeritstep.domain.models.*

interface AuthRepository {

    fun register(data:RegisterRequest): Flow<Response<RegisterResponse>>

    fun login(data:LoginRequest): Flow<Response<LoginResponse>>

    fun confirmEmail(data:ConfirmRequest):Flow<Response<ConfirmResponse>>

//    create controller on backend for recovery password
//    fun recoveryPassword(data:RecoveryPasswordRequest):RecoveryPasswordResponse
}
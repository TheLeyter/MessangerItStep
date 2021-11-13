package ua.leyter.messengeritstep.domain.repositories

import ua.leyter.messengeritstep.domain.models.*

interface AuthReposieory {

    fun register(data:RegisterRequest):RegisterResponse

    fun login(data:LoginRequest):LoginResponse

    fun confirmEmail(data:ConfirmRequest):ConfirmResponse

//    create controller on backend for recovery password
//    fun recoveryPassword(data:RecoveryPasswordRequest):RecoveryPasswordResponse
}
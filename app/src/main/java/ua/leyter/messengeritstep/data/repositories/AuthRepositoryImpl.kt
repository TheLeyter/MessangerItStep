package ua.leyter.messengeritstep.data.repositories

import ua.leyter.messengeritstep.data.network.services.AuthServices
import ua.leyter.messengeritstep.domain.models.*
import ua.leyter.messengeritstep.domain.repositories.AuthReposieory

class AuthRepositoryImpl(private val authServices: AuthServices) : AuthReposieory {

    override fun register(data: RegisterRequest): RegisterResponse {
        TODO("Not yet implemented")
    }

    override fun login(data: LoginRequest): LoginResponse {
        TODO("Not yet implemented")
    }

    override fun confirmEmail(data: ConfirmRequest): ConfirmResponse {
        TODO("Not yet implemented")
    }

}
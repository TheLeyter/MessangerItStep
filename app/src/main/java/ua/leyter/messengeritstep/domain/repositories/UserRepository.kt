package ua.leyter.messengeritstep.domain.repositories

import kotlinx.coroutines.flow.Flow
import ua.leyter.messengeritstep.domain.entities.User

interface UserRepository {

    fun getAllUsers():Flow<List<User>>

}
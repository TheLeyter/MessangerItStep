package ua.leyter.messengeritstep.domain.models

data class RegisterResponse(
    var secret:String,
    var email:String,
    var expiredAt:String
)
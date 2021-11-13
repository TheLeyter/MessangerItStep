package ua.leyter.messengeritstep.domain.models

data class LoginResponse(
    var Id:Long,
    var RefreshToken:String,
    var AccessToken:String
)

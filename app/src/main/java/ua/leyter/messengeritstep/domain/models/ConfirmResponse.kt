package ua.leyter.messengeritstep.domain.models

data class ConfirmResponse(
    var Id:Long,
    var RefreshToken:String,
    var AccessToken:String
)

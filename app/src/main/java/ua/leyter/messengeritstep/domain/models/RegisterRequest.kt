package ua.leyter.messengeritstep.domain.models

data class RegisterRequest(
    var Email:String,
    var UserName:String,
    var FirstName:String,
    var LastName:String,
)

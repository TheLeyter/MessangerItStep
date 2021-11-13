package ua.leyter.messengeritstep.domain.models

data class ConfirmRequest(
    var secret:String,
    var code:String
)

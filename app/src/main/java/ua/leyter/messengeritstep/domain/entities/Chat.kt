package ua.leyter.messengeritstep.domain.entities

data class Chat(
    var Id:Long,
    var UserCreator:Long,
    var User:Long,
    var CreatedAt:ULong
)
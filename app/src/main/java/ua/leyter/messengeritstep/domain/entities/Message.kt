package ua.leyter.messengeritstep.domain.entities

import ua.leyter.messengeritstep.domain.MessageStatus

data class Message(
    var Id:Long,
    var Chat:Long,
    var User:Long,
    var Message:String,
    var CreatedAt:ULong,
    var Updated:Boolean,
    var Status:MessageStatus
)

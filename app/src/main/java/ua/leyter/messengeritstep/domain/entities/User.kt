package ua.leyter.messengeritstep.domain.entities

data class User(
    var Id:Long,
    var UserName:String,
    var Email:String? = null,
    var FirstName:String,
    var LastName:String,
    var UserImage:String? = null,
    var Bio:String? = null
)
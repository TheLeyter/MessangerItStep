package ua.leyter.messengeritstep.data.cache.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import ua.leyter.messengeritstep.domain.MessageStatus

@Entity(tableName = "Messages")
data class Message(
    @NotNull @PrimaryKey(autoGenerate = true) var Id:Long,
    @NotNull @ColumnInfo(name = "Chat") var Chat:Long,
    @NotNull @ColumnInfo(name = "User") var User:Long,
    @NotNull @ColumnInfo(name = "Message") var Message:String,
    @NotNull @ColumnInfo(name = "CreatedAt") var CreatedAt:ULong,
    @NotNull @ColumnInfo(name = "Updated") var Updated:Boolean? = false,
    @NotNull @ColumnInfo(name = "Status") var Status:MessageStatus? = MessageStatus.SENT,
)

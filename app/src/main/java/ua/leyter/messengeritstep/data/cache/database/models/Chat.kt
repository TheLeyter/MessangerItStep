package ua.leyter.messengeritstep.data.cache.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Chats")
data class Chat(
    @NotNull @PrimaryKey(autoGenerate = true) var id:Long,
    @NotNull @ColumnInfo(name = "UserCreator") var UserCreator:Long,
    @NotNull @ColumnInfo(name = "User") var User:Long,
    @NotNull @ColumnInfo(name = "CreatedAt") var CreatedAt:ULong,
)

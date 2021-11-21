package ua.leyter.messengeritstep.data.cache.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Users")
data class User(
    @NotNull @PrimaryKey(autoGenerate = true) var id:Long,
    @NotNull @ColumnInfo(name = "UserName") var UserName:String,
    @NotNull @ColumnInfo(name = "FirstName") var FirstName:String,
    @NotNull @ColumnInfo(name = "LastName") var LastName:String,
    @ColumnInfo(name = "UserImage") var UserImage:String,
    @ColumnInfo(name = "Bio") var Bio:String,
    @ColumnInfo(name = "UpdatedAt") var UpdatedAt:ULong
)
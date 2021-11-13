package ua.leyter.messengeritstep.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ua.leyter.messengeritstep.data.cache.database.dao.UserDao
import ua.leyter.messengeritstep.data.cache.database.models.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
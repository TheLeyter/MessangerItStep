package ua.leyter.messengeritstep.data.cache.database.dao

import androidx.room.*
import ua.leyter.messengeritstep.data.cache.database.models.User

@Dao
interface UserDao {

//    @Query("SELECT * FROM Users")
//    suspend fun getAllUsers():List<User>

//    @Query("SELECT * FROM Users WHERE :id LIKE id")
//    suspend fun getUserById(id:Long):User

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun createUser(user:User):User

//    @Update
//    suspend fun updateUser(user:User)

//    @Delete
//    suspend fun deleteUser(user:User)

//    @Query("DELETE FROM Users WHERE :id LIKE id")
//    suspend fun deleteUserById(id: Long)

}
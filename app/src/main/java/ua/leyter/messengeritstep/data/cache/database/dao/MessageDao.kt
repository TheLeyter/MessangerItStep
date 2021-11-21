package ua.leyter.messengeritstep.data.cache.database.dao

import androidx.room.*
import ua.leyter.messengeritstep.data.cache.database.models.Message
import ua.leyter.messengeritstep.data.cache.database.models.User

@Dao
interface MessageDao {
    @Query("SELECT * FROM Messages")
    suspend fun getAllMessage():List<Message>

    @Query("SELECT * FROM Messages WHERE :id LIKE id")
    suspend fun getMessageById(id:Long): Message

    @Query("SELECT * FROM Messages WHERE :chatId LIKE Chat")
    suspend fun getAllMessagesByChat(chatId:Long): List<Message>

    @Query("SELECT * FROM Messages WHERE :chatId LIKE Chat ORDER BY CreatedAt LIMIT 10")
    suspend fun getLastTenMessageByChat(chatId:Long): List<Message>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createMessage(message: Message): Message

    @Update
    suspend fun updateMessage(message: Message)

    @Delete
    suspend fun deleteMessage(message: Message)

    @Query("DELETE FROM Messages WHERE :id LIKE id")
    suspend fun deleteMessageById(id: Long)
}
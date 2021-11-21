package ua.leyter.messengeritstep.data.cache.database.dao

import androidx.room.*
import ua.leyter.messengeritstep.data.cache.database.models.Chat

@Dao
interface ChatDao {

    @Query("SELECT * FROM Chats")
    suspend fun getAllChats(): List<Chat>

    @Query("SELECT * FROM Chats WHERE :id LIKE id")
    suspend fun getChatById(id: Long):Chat

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createChat(chat: Chat): Chat

    @Update
    suspend fun updateChat(chat: Chat)

    @Delete
    suspend fun deleteChat(chat: Chat)

    @Query("DELETE FROM Chats WHERE :id LIKE id")
    suspend fun deleteById(id:Long)
}
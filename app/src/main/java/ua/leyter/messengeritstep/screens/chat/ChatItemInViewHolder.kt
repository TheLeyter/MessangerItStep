package ua.leyter.messengeritstep.screens.chat

import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.view.ViewGroup
import ua.leyter.messengeritstep.screens.chat.ChatItemInViewHolder
import android.view.LayoutInflater
import android.view.View
import ua.leyter.messengeritstep.R

/** A simple single line list item.  */
class ChatItemInViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val chatMessage: TextView = itemView.findViewById(R.id.chatMessage)

    companion object {
        fun create(parent: ViewGroup): ChatItemInViewHolder {
            return ChatItemInViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.chat_item_in, parent, false)
            )
        }
    }
}
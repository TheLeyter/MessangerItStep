package ua.leyter.messengeritstep.screens.chat

import ua.leyter.messengeritstep.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
class ChatItemOutViewHolder(view: View) : ViewHolder(view) {
    val chatMessage: TextView = itemView.findViewById(R.id.chatMessage)

    companion object {
        fun create(parent: ViewGroup): ChatItemOutViewHolder {
            return ChatItemOutViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.chat_item_out, parent, false)
            )
        }
    }
}

package ua.leyter.messengeritstep.screens.chat

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CustomRecyclerAdapter(private val messages: List<ChatMessage>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> ChatItemOutViewHolder.create(parent)
            else -> {
                ChatItemInViewHolder.create(parent)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ChatItemOutViewHolder -> holder.chatMessage.text = messages[position].text
            is ChatItemInViewHolder -> holder.chatMessage.text = messages[position].text
        }
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun getItemViewType(itemPos: Int): Int {
        return if (messages[itemPos].isOut) {
            1
        } else 0
    }
}

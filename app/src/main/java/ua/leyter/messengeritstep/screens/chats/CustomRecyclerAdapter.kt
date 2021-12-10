package ua.leyter.messengeritstep.screens.chats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.leyter.messengeritstep.R
import ua.leyter.messengeritstep.domain.entities.User

class CustomRecyclerAdapter(private val users: List<User>) :
    RecyclerView.Adapter<TwoLineItemViewHolder>() {

    private val imageDownloader = ImageDownloader()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwoLineItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.material_list_item_two_line, parent, false)
        return TwoLineItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TwoLineItemViewHolder, position: Int) {
        holder.firstLine?.text = users[position].UserName
//        holder.secondLine?.text = "Last message bla bla bla..."
        users[position].UserImage?.let {
            imageDownloader.setImage("https://i.pravatar.cc/150?u=$it", holder.image)
            holder.secondLine?.text = it
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}

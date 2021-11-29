package ua.leyter.messengeritstep.screens.chats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.leyter.messengeritstep.R

class CustomRecyclerAdapter(private val names: List<String>) :
    RecyclerView.Adapter<TwoLineItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwoLineItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.material_list_item_two_line, parent, false)
        return TwoLineItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TwoLineItemViewHolder, position: Int) {
        holder.firstLine?.text = names[position]
        holder.secondLine?.text = "Last message bla bla bla..."
    }

    override fun getItemCount(): Int {
        return names.size
    }
}

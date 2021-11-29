package ua.leyter.messengeritstep.screens.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.leyter.messengeritstep.R

class ChatsView : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val viewOfLayout: View =
            inflater.inflate(R.layout.fragment_chats_view, container, false)

        val recyclerView: RecyclerView = viewOfLayout.findViewById(R.id.RecyclerView)

        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)
        recyclerView.adapter = CustomRecyclerAdapter(fillList())

        recyclerView.setDivider(R.drawable.recycler_view_divider)

        return viewOfLayout
    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..15).forEach { i -> data.add("User Name $i") }
        return data
    }
}
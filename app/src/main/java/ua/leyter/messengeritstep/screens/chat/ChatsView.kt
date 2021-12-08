package ua.leyter.messengeritstep.screens.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.leyter.messengeritstep.R
import ua.leyter.messengeritstep.domain.entities.User

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

        return viewOfLayout
    }

    private fun fillList(): List<User> {
        val data = mutableListOf<User>()
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        (0..15).forEach { i ->
            val user = User(
                Id = i.toLong(),
                FirstName = "User",
                LastName = "Name $i",
                UserName = "User Name $i",
                UserImage = (1..19)
                    .map { kotlin.random.Random.nextInt(0, charPool.size) }
                    .map(charPool::get)
                    .joinToString("")
            )
            data.add(user)
        }
        return data
    }
}
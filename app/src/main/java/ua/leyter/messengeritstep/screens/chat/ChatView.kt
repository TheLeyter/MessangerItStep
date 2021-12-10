package ua.leyter.messengeritstep.screens.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ua.leyter.messengeritstep.R
import ua.leyter.messengeritstep.screens.chats.ImageDownloader

class ChatView : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val viewOfLayout: View =
            inflater.inflate(R.layout.fragment_one_chat_view, container, false)

        viewOfLayout.findViewById<View>(R.id.backButton).setOnClickListener { view ->
            view.findNavController().navigateUp()
        }

        viewOfLayout.findViewById<TextView>(R.id.userName).text =
            arguments?.getString("UserName")

        val imageDownloader = ImageDownloader()

        arguments?.getString("UserImage")?.let {
            imageDownloader.setImage("https://i.pravatar.cc/150?u=$it",
                viewOfLayout.findViewById(R.id.userImage))
        }

        val recyclerView: RecyclerView = viewOfLayout.findViewById(R.id.RecyclerView)

        val lm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)
        lm.stackFromEnd = true

        recyclerView.layoutManager = lm
        recyclerView.adapter = CustomRecyclerAdapter(fillList())

        return viewOfLayout
    }

    private fun fillList(): List<ChatMessage> {
        val data = mutableListOf<ChatMessage>()
        data.add(ChatMessage(false, "Hi, how are you, friend!"))
        data.add(ChatMessage(true, "Yes, I'm fine! And you"))
        data.add(ChatMessage(false, "Fine thanks!\nWhat are you doing?"))
        data.add(ChatMessage(true, "Drive and drunk!"))
        data.add(ChatMessage(false, "@@!\nBecareful!"))
        return data
    }
}
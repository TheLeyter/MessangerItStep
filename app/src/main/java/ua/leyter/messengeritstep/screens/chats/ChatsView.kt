package ua.leyter.messengeritstep.screens.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import ua.leyter.messengeritstep.MainActivity
import ua.leyter.messengeritstep.R
import ua.leyter.messengeritstep.domain.entities.User

class ChatsView : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val viewOfLayout: View =
            inflater.inflate(R.layout.fragment_chats_view, container, false)

        ViewCompat.setOnApplyWindowInsetsListener(viewOfLayout.findViewById(R.id.constraintChats)) { root, windowInset ->
            val inset = windowInset.getInsets(WindowInsetsCompat.Type.systemBars())
            root.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                leftMargin = inset.left
                bottomMargin = inset.bottom
                rightMargin = inset.right
            }
            viewOfLayout.findViewById<View>(R.id.header2).updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = inset.top
            }
            WindowInsetsCompat.CONSUMED
        }

        viewOfLayout.findViewById<View>(R.id.backButton).setOnClickListener {
            val imageDownloader = ImageDownloader()

            imageDownloader.setImage("https://i.pravatar.cc/100",
                (activity as MainActivity).findViewById<NavigationView>(R.id.nav_view)
                    .getHeaderView(0).findViewById(R.id.userImage))

            (activity as MainActivity).openCloseNavigationDrawer()
        }

        val recyclerView: RecyclerView = viewOfLayout.findViewById(R.id.RecyclerView)

        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)

        val users = fillList()

        recyclerView.adapter = CustomRecyclerAdapter(users)

        recyclerView.setDivider(R.drawable.recycler_view_divider)

        recyclerView.addOnItemTouchListener(object : RecyclerView.SimpleOnItemTouchListener() {
            var downTouch = false
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                when (e.action) {
                    MotionEvent.ACTION_DOWN -> downTouch = true
                    MotionEvent.ACTION_UP -> if (downTouch) {
                        downTouch = false
                        recyclerView.findChildViewUnder(e.x, e.y)?.let {
                            val position = rv.getChildAdapterPosition(it)

                            val bundle = bundleOf(
                                "UserName" to users[position].UserName,
                                "UserImage" to users[position].UserImage
                            )
                            recyclerView.findNavController().navigate(R.id.action_chatsView_to_chatView, bundle)
                        }
                    }
                    else -> downTouch = false
                }
                return super.onInterceptTouchEvent(rv, e)
            }
        })

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
package ua.leyter.messengeritstep.screens.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import ua.leyter.messengeritstep.MainActivity
import ua.leyter.messengeritstep.R
import ua.leyter.messengeritstep.screens.chats.ImageDownloader


class SettingsView : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val viewOfLayout: View =
            inflater.inflate(R.layout.fragment_settings_view, container, false)

        (activity as MainActivity)
            .setStatusBarTransparent(requireActivity(), viewOfLayout.findViewById(R.id.header))

        viewOfLayout.findViewById<View>(R.id.backButton).setOnClickListener { view ->
            view.findNavController().navigateUp()
        }

        val imageDownloader = ImageDownloader()

        imageDownloader.setImage("https://i.pravatar.cc/300",
                viewOfLayout.findViewById(R.id.userBigImage))

        return viewOfLayout
    }
}
package ua.leyter.messengeritstep.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import ua.leyter.messengeritstep.MainActivity
import ua.leyter.messengeritstep.R

class LoginView : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val viewOfLayout: View =
            inflater.inflate(R.layout.fragment_login_view, container, false)

        (activity as MainActivity)
            .setStatusBarTransparent(requireActivity(), viewOfLayout.findViewById(R.id.constraintLogin))

        viewOfLayout.findViewById<View>(R.id.register_link).setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_loginView_to_registerView)
            }
        return viewOfLayout
    }


}
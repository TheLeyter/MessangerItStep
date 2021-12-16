package ua.leyter.messengeritstep.screens.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import ua.leyter.messengeritstep.MainActivity
import ua.leyter.messengeritstep.R

class RegisterView : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val viewOfLayout: View =
            inflater.inflate(R.layout.fragment_register_view, container, false)

        (activity as MainActivity)
            .setStatusBarTransparent(requireActivity(), viewOfLayout.findViewById(R.id.constraintRegister))

        viewOfLayout.findViewById<View>(R.id.backButton).setOnClickListener { view ->
            view.findNavController().navigateUp()
        }

        viewOfLayout.findViewById<View>(R.id.ConfirmBtn).setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_registerView_to_confirmView)
        }

        return viewOfLayout
    }

}
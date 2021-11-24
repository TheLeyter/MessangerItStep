package ua.leyter.messengeritstep.screens.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import ua.leyter.messengeritstep.R

class RegisterView : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val viewOfLayout: View =
            inflater.inflate(R.layout.fragment_register_view, container, false)

        viewOfLayout.findViewById<View>(R.id.backButton).setOnClickListener { view ->
            view.findNavController().navigateUp()
        }
        return viewOfLayout
    }

}
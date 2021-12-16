package ua.leyter.messengeritstep.screens.confirm

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import ua.leyter.messengeritstep.R
import android.widget.TextView
import ua.leyter.messengeritstep.MainActivity

class ConfirmView : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val viewOfLayout: View =
            inflater.inflate(R.layout.fragment_confirm_view, container, false)

        (activity as MainActivity)
            .setStatusBarTransparent(requireActivity(), viewOfLayout.findViewById(R.id.constraintConfirm))

        viewOfLayout.findViewById<View>(R.id.backButton).setOnClickListener { view ->
            view.findNavController().navigateUp()
        }

        val groupOfDigits: ViewGroup = viewOfLayout.findViewById(R.id.groupOfDigits)

        addTextWatcherToEditTexts(groupOfDigits)

        viewOfLayout.findViewById<View>(R.id.ConfirmBtn).setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_confirmView_to_chatsView)
        }

        return viewOfLayout
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            // no-op
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // no-op
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val text = activity?.currentFocus as? TextView?

            if (text != null && text.length() > 0) {
                val next = text.focusSearch(View.FOCUS_RIGHT) // or FOCUS_FORWARD
                next?.requestFocus()
            }
        }
    }

    private fun addTextWatcherToEditTexts(groupOfDigits: ViewGroup) {
        groupOfDigits.children.forEach { view ->
            (view as? EditText)?.addTextChangedListener(textWatcher)
        }
    }
}
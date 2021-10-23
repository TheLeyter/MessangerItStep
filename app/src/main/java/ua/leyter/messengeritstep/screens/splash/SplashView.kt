package ua.leyter.messengeritstep.screens.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import ua.leyter.messengeritstep.R

class SplashView : Fragment() {


    private lateinit var vm:SplashViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vm = ViewModelProvider(this).get(SplashViewModel::class.java)

        navController = findNavController()

        vm.navigate.observe(viewLifecycleOwner, Observer {
            if(it){
                navController.navigate(R.id.action_splashView_to_loginView)
            }
        })

        return inflater.inflate(R.layout.fragment_splash_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.splash()
    }
}
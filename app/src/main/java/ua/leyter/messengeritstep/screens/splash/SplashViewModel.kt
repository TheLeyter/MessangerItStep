package ua.leyter.messengeritstep.screens.splash

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {

    val navigate = MutableLiveData<Boolean>()

    fun splash(){
        object : CountDownTimer(3000,1000){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                navigate.value = true
            }

        }.start()
    }

}
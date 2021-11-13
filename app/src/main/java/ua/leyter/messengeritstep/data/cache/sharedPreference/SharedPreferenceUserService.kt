package ua.leyter.messengeritstep.data.cache.sharedPreference

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceUserService(private val context:Context) {

    private var preference : SharedPreferences

    init{
        preference = context.getSharedPreferences(UserPreferenceName, Context.MODE_PRIVATE)
    }

    companion object{
        private const val UserPreferenceName = "USER_PREFERENCE"

        private const val UserIdPreferenceKey = "ID"
        private const val UserAccessPreferenceKey = "ACCESS_TOKEN"
        private const val UserRefreshPreferenceKey = "REFRESH_TOKEN"
    }

    fun getUserId():Long {
        return preference.getLong(UserIdPreferenceKey, 0L)
    }

    fun getAccessToken():String?{
        return preference.getString(UserAccessPreferenceKey,null)
    }

    fun getRefreshToken():String?{
        return preference.getString(UserRefreshPreferenceKey,null)
    }

}
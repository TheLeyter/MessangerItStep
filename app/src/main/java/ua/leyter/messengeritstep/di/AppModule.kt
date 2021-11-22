package ua.leyter.messengeritstep.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ua.leyter.messengeritstep.data.cache.database.AppDatabase
import ua.leyter.messengeritstep.data.cache.sharedPreference.SharedPreferenceUserService
import ua.leyter.messengeritstep.data.network.services.AuthServices
import ua.leyter.messengeritstep.data.repositories.AuthRepositoryImpl
import ua.leyter.messengeritstep.domain.repositories.AuthRepository

var AppModule = module{

    //network services
    single<Retrofit>{
        Retrofit.Builder()
            .baseUrl("http//:127.0.0.1:5000/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory<AuthServices> {
        get<Retrofit>().create(AuthServices::class.java)
    }

    //database
    single<AppDatabase> {
        Room.databaseBuilder(
            get<Context>(),
            AppDatabase::class.java,
            "MessengerDatabase"
        ).build()
    }

    //preferences
    single<SharedPreferenceUserService> {
        SharedPreferenceUserService(get<Context>())
    }

    //Repositories
    factory<AuthRepository> {
        AuthRepositoryImpl(get<AuthServices>())
    }



    //view models

 }
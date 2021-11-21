package ua.leyter.messengeritstep.domain.common

sealed class Response<T>(val loading:Boolean, val error:String?, val data:T?) {

        class Success<T>(data: T?) : Response<T>(loading = true, error = null, data = data)
        class Error<T>(error: String) : Response<T>(loading = false, error = error, data = null)
        class Loading<T>() : Response<T>(loading = true, null, null)
}
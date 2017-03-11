package booboo.thelocalnick.services

import booboo.thelocalnick.models.Tours
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface SearchService {
    @GET("bins/14n9hr?")
    fun getTours(@Query("location") location: String): Observable<Tours>
}
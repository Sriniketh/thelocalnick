package booboo.thelocalnick.services

import booboo.thelocalnick.models.Tours
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface SearchService {
    @GET("/bins/17z9jz?")
    fun getTours(@Query("location") location: String): Observable<Tours>
}
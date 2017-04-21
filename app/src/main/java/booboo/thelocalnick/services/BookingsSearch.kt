package booboo.thelocalnick.services

import booboo.thelocalnick.models.Bookings
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface BookingsSearch {
    @GET("bins/17qndb")
    fun getBookings(@Query("userid") userid: String): Observable<Bookings>
}
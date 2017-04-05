package booboo.thelocalnick.gettingstarted

import booboo.thelocalnick.models.Tour
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by AshwinKumar on 2/8/17.
 */

interface testclass {
    @GET("search?")
    fun getTours(@Query("location") location: String): Observable<Tour>
}
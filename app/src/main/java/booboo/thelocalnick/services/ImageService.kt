package booboo.thelocalnick.services

import android.graphics.Bitmap
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url


interface ImageService {
    @GET
    fun getImage(@Url a:String): Observable<Bitmap>
}
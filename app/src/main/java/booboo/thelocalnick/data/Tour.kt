package booboo.thelocalnick.data

import android.util.Log
import java.util.ArrayList

class Tour(spots: List<Spot>?, time: Float?, cost: Float?, photos: List<Photo>?, schedules: List<Schedule>?) {
    var spots: List<Spot>? = ArrayList()
    var time: Float? = null
    var cost: Float? = null
    var photos: List<Photo>? = ArrayList()
    var schedule: List<Schedule>? = ArrayList()

    init {
        this.spots = spots
        this.time = time
        this.cost = cost
        this.photos = photos
        this.schedule = schedules
    }

    fun printEverything() {
        Log.d("LOCALNICKTAG", this.spots.toString())
        Log.d("LOCALNICKTAG", this.time.toString())
        Log.d("LOCALNICKTAG", this.cost.toString())
        Log.d("LOCALNICKTAG", this.photos.toString())
        Log.d("LOCALNICKTAG", this.schedule.toString())
    }
}
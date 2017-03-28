package booboo.thelocalnick.data

import java.util.ArrayList

class Tour(spots: List<Spot>?) {
    var spots: List<Spot>? = ArrayList()
    var time: Float? = null
    var cost: Float? = null

    init {
        this.spots = spots
    }
}
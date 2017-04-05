package booboo.thelocalnick.tourListing

/**
 * Created by Sandeep on 01-03-2017.
 */

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

import booboo.thelocalnick.R
import booboo.thelocalnick.exploreTour.ExploreTourFragment
import booboo.thelocalnick.models.Tour


class TourTiles(itemView: View, internal var activity: Activity) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var tripDesc: TextView
    var tripReviewCount: TextView
    var tripCost: TextView
    var tripImage: ImageView
    var tripRate: RatingBar
    var tour:Tour? = null



    init {
        itemView.setOnClickListener(this)
        tripDesc = itemView.findViewById(R.id.trip_Desc) as TextView
        tripReviewCount = itemView.findViewById(R.id.trip_reviewCount) as TextView
        tripImage = itemView.findViewById(R.id.trip_image) as ImageView
        tripRate = itemView.findViewById(R.id.trip_rate) as RatingBar
        tripCost = itemView.findViewById(R.id.trip_Cost) as TextView
    }

    override fun onClick(view: View) {
        val exp = ExploreTourFragment()
        exp.tour = tour
        val fm = activity.fragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.output,exp)
        ft.addToBackStack(null)
        ft.commit()
    }
}

internal class tileData(author: String, var desc: String, rate: Double, price: Double, var ratingCount: Int, var imageRes: Int) {
    var rate: Double = 0.toDouble()
    var price: Double = 0.toDouble()

    init {
        this.rate = java.lang.Double.parseDouble(String.format("%.1f", rate % 5))
        this.price = java.lang.Double.parseDouble(String.format("%.2f", price))
    }
}
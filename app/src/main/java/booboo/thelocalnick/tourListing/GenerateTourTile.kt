package booboo.thelocalnick.tourListing

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import booboo.thelocalnick.R
import booboo.thelocalnick.models.Tour
import com.squareup.picasso.Picasso


class GenerateTourTile(private val context: Activity, private val itemList: List<Tour>) : RecyclerView.Adapter<TourTiles>() {

    init {
        this.setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourTiles {

        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_tour_tiles, null)
        val rcv = TourTiles(layoutView,context)
        return rcv
    }

    override fun onBindViewHolder(holder: TourTiles, position: Int) {
        //holder.tripImage.setImageDrawable();
//         Observable.just( BitmapFactory.decodeStream(URL(itemList[position].tourImage).openConnection().getInputStream())).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe { bmp ->
//                    holder.tripImage.setImageBitmap(bmp)
//
//                }
        Picasso.with(context)
                .load(itemList[position].tourPhoto[0])
                .error(R.drawable.gs1)
                .into(holder.tripImage);
        //holder.setIsRecyclable(false);

        holder.tripCost.text = "$ " + itemList[position].totalCost!!
        if (itemList[position].tourDescription.length > 40) {
            holder.tripDesc.text = itemList[position].tourDescription.substring(0, 40) + "..."
        } else {
            holder.tripDesc.text = itemList[position].tourDescription
        }
        holder.tripRate.rating = itemList[position].averageRating
        holder.tripReviewCount.text = " (" + itemList[position].reviewCount + ")"
        holder.tour = itemList[position]

    }

    override fun getItemCount(): Int {
        return this.itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}

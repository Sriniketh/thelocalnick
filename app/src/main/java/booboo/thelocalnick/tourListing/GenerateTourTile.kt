package booboo.thelocalnick.tourListing

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import booboo.thelocalnick.R
import booboo.thelocalnick.models.Tour
import com.squareup.picasso.Picasso


class GenerateTourTile(private val context: Context, private val itemList: List<Tour>) : RecyclerView.Adapter<TourTiles>() {

    init {
        this.setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourTiles {

        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_tour_tiles, null)
        val rcv = TourTiles(layoutView)
        /* this.setHasStableIds(true);*/
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
                .load(itemList[position].tourImage)
                .error(R.drawable.gs1)
                .into(holder.tripImage);
        //holder.setIsRecyclable(false);
        holder.tripCost.text = "$ " + itemList[position].price!!
        if (itemList[position].description.length > 40) {
            holder.tripDesc.text = itemList[position].description.substring(0, 40) + "..."
        } else {
            holder.tripDesc.text = itemList[position].description
        }
        holder.tripRate.rating = (itemList[position].price as Int).toFloat()
        holder.tripReviewCount.text = " (" + itemList[position].reviews + ")"
    }

    override fun getItemCount(): Int {
        return this.itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}

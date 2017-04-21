package booboo.thelocalnick.BookedTours

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.squareup.picasso.Picasso

import java.util.ArrayList

import booboo.thelocalnick.R
import booboo.thelocalnick.models.BookedTour
import booboo.thelocalnick.models.Bookings


/**
 * Created by jancy on 4/18/17.
 */
class bookedToursRecyclerAdapter(private val context: Activity, tourList: Bookings) : RecyclerView.Adapter<bookedToursRecyclerAdapter.ViewHolder>() {

    internal var tourList: ArrayList<*>

    init {
        this.tourList = tourList.bookedTours as ArrayList<*>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.booked_tours_card_view, parent, false))
        // val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_tour_tiles, null)
        // val rcv = TourTiles(layoutView,context)
        // return rcv
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val t = tourList[position] as BookedTour

       // holder.b_tour_image.setImageResource(Integer.parseInt(t.tourImage))

        Picasso.with(context)
                .load(t.tourImage)
                .error(R.drawable.gs1)
                .into(holder.b_tour_image)

        holder.b_tour_name.text = t.tourTitle

        holder.b_tour_guide.text = "Guided by " + t.guideName!!

        if (t.description!!.length > 40) {
            holder.b_tour_desc.text = t.description!!.substring(0, 40) + "..."
        } else {
            holder.b_tour_desc.text = t.description
        }

        holder.b_tour_date.text = "Date of the Tour: " + t.time!!

        holder.b_tour_guest.text = "No. of guests: " + t.guests!!

        holder.b_tour_cost.text = "Total Cost: $" + t.price!!

    }

    override fun getItemCount(): Int {
        return tourList.size

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var b_tour_image: ImageView
        internal var b_tour_name: TextView
        internal var b_tour_guide: TextView
        internal var b_tour_desc: TextView
        internal var b_tour_date: TextView
        internal var b_tour_guest: TextView
        internal var b_tour_cost: TextView

        init {
            b_tour_image = itemView.findViewById(R.id.booked_tours_image) as ImageView
            b_tour_name = itemView.findViewById(R.id.booked_tours_name) as TextView
            b_tour_guide = itemView.findViewById(R.id.booked_tours_guide) as TextView
            b_tour_desc = itemView.findViewById(R.id.booked_tours_desc) as TextView
            b_tour_date = itemView.findViewById(R.id.booked_tours_date) as TextView
            b_tour_guest = itemView.findViewById(R.id.booked_tours_guests) as TextView
            b_tour_cost = itemView.findViewById(R.id.booked_tours_cost) as TextView
        }
    }
}

/*class tourData {

    public int t_image;
    public String t_name;
    public String t_guide;
    public String t_desc;
    public String t_date;
    public int t_guests;
    public double t_cost;

    public tourData(int t_image, String t_name, String t_guide, String t_desc, String t_date, int t_guests, double t_cost)
    {
        this.t_image=t_image;
        this.t_name=t_name;
        this.t_guide=t_guide;
        this.t_desc=t_desc;
        this.t_date=t_date;
        this.t_guests=t_guests;
        this.t_cost=t_cost;
    }
}*/
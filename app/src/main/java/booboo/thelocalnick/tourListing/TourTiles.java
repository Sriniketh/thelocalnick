package booboo.thelocalnick.tourListing;

/**
 * Created by Sandeep on 01-03-2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import booboo.thelocalnick.R;


public class TourTiles extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tripAuthor, tripDesc, tripReviewCount, tripCost;
    public ImageView tripImage;
    public RatingBar tripRate;

    public TourTiles(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        tripAuthor = (TextView) itemView.findViewById(R.id.trip_Author);
        tripDesc = (TextView) itemView.findViewById(R.id.trip_Desc);
        tripReviewCount = (TextView) itemView.findViewById(R.id.trip_reviewCount);
        tripImage = (ImageView) itemView.findViewById(R.id.trip_image);
        tripRate = (RatingBar) itemView.findViewById(R.id.trip_rate);
        tripCost = (TextView) itemView.findViewById(R.id.trip_Cost);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}

class tileData {
    public String author;
    public String desc;
    public int imageRes;
    public double rate;
    public double price;
    public int ratingCount;

    public tileData(String author, String desc, double rate, double price, int ratingCount, int imageRes) {
        this.author = author;
        this.desc = desc;
        this.rate = Double.parseDouble(String.format("%.1f", rate % 5));
        this.price = Double.parseDouble(String.format("%.2f", price));
        this.ratingCount = ratingCount;
        this.imageRes = imageRes;
    }
}
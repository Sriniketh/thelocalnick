package booboo.thelocalnick.tourListing;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import booboo.thelocalnick.R;

/**
 * Created by Sandeep on 01-03-2017.
 */


public class GenerateTourTile extends RecyclerView.Adapter<TourTiles> {
    private List<tileData> itemList;
    private Context context;

    public GenerateTourTile(Context context, List<tileData> itemList) {
        this.setHasStableIds(true);
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public TourTiles onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_tour_tiles, null);
        TourTiles rcv = new TourTiles(layoutView);
       /* this.setHasStableIds(true);*/
        return rcv;
    }

    @Override
    public void onBindViewHolder(TourTiles holder, int position) {
        holder.tripAuthor.setText(itemList.get(position).author);
        holder.tripImage.setImageResource(itemList.get(position).imageRes);
        holder.tripCost.setText("$ " + itemList.get(position).price);
        if (itemList.get(position).desc.length() > 20) {
            holder.tripDesc.setText(itemList.get(position).desc.substring(0, 20) + "...");
        } else {
            holder.tripDesc.setText(itemList.get(position).desc);
        }
        holder.tripRate.setRating((float) itemList.get(position).rate);
        holder.tripReviewCount.setText(" " + itemList.get(position).ratingCount + "");
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}

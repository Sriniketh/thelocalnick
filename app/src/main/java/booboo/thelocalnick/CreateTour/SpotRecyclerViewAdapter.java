package booboo.thelocalnick.CreateTour;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import booboo.thelocalnick.R;
import booboo.thelocalnick.data.Spot;

class SpotRecyclerViewAdapter extends RecyclerView.Adapter<SpotViewHolder> {
    private List<Spot> spots;

    public SpotRecyclerViewAdapter(List<Spot> spots) {
        this.spots = spots;
    }

    @Override
    public SpotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View container = inflater.inflate(R.layout.spot_card_view, parent, false);

        return new SpotViewHolder(container);
    }

    @Override
    public void onBindViewHolder(SpotViewHolder holder, int position) {
        Spot spotItem = spots.get(position);
        holder.bind(spotItem);
    }

    @Override
    public int getItemCount() {
        return spots.size();
    }
}

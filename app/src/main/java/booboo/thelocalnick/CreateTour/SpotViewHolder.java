package booboo.thelocalnick.CreateTour;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import booboo.thelocalnick.data.Spot;
import booboo.thelocalnick.databinding.SpotCardViewBinding;

public class SpotViewHolder extends RecyclerView.ViewHolder {
    private SpotCardViewBinding spotCardviewBinding;

    public SpotViewHolder(View itemView) {
        super(itemView);
        spotCardviewBinding = DataBindingUtil.bind(itemView);
    }

    public void bind(Spot spot) {
        spotCardviewBinding.setSpot(spot);
    }
}

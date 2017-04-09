package booboo.thelocalnick.CreateTour;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import booboo.thelocalnick.R;
import booboo.thelocalnick.data.Photo;

public class PhotoRecyclerViewAdapter extends RecyclerView.Adapter<PhotoViewHolder> {
    private List<Photo> feedItemList;

    public PhotoRecyclerViewAdapter(Context context, List<Photo> feedItemList) {
        this.feedItemList = feedItemList;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_card_view, viewGroup, false);
        PhotoViewHolder viewHolder = new PhotoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder customViewHolder, int i) {
        Photo feedItem = feedItemList.get(i);
        customViewHolder.bind(feedItem);
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }
}
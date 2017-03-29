package booboo.thelocalnick.CreateTour;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import booboo.thelocalnick.R;
import booboo.thelocalnick.data.Photo;

public class PhotoRecyclerViewAdapter extends RecyclerView.Adapter<PhotoViewHolder> {
    private List<Photo> feedItemList;
    private Context mContext;

    public PhotoRecyclerViewAdapter(Context context, List<Photo> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
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
        /*if (!TextUtils.isEmpty(feedItem.getThumbnail())) {
            Log.d("TAG", "picisso picasso");
            Picasso.with(mContext).load(feedItem.getThumbnail())
                    .error(R.drawable.logo)
                    .placeholder(R.drawable.logo)
                    .into(customViewHolder.imageView);
        }*/
        customViewHolder.bind(feedItem);
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }
}
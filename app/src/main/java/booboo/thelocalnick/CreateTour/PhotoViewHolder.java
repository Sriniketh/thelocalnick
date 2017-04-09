package booboo.thelocalnick.CreateTour;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import booboo.thelocalnick.data.Photo;
import booboo.thelocalnick.databinding.PhotoCardViewBinding;

class PhotoViewHolder extends RecyclerView.ViewHolder {
    private PhotoCardViewBinding photoCardViewBinding;

    public PhotoViewHolder(View view) {
        super(view);
        photoCardViewBinding = DataBindingUtil.bind(view);
    }

    public void bind(Photo photo) {
        photoCardViewBinding.setPhoto(photo);
    }

    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}
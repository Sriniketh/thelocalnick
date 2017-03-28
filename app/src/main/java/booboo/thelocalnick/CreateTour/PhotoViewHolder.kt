package booboo.thelocalnick.CreateTour

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import booboo.thelocalnick.data.Spot

import booboo.thelocalnick.databinding.PhotoCardViewBinding

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val photoCardViewBinding: PhotoCardViewBinding = DataBindingUtil.bind<PhotoCardViewBinding>(itemView)

    fun bind(spot: Spot) {
        photoCardViewBinding.spot = spot
    }
}

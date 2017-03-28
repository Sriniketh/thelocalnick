package booboo.thelocalnick.CreateTour

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import booboo.thelocalnick.R
import booboo.thelocalnick.data.Spot

class PhotoRecylerViewAdapter(private val pics: List<Spot>) : RecyclerView.Adapter<PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val container = inflater.inflate(R.layout.photo_card_view, parent, false)

        return PhotoViewHolder(container)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = pics[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return pics.size
    }
}

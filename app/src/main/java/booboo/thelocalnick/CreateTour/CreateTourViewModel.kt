package booboo.thelocalnick.CreateTour

import android.support.v7.widget.RecyclerView
import android.view.View

class CreateTourViewModel {
    var spotFragment: SpotFragment? = null
    var recyclerView: RecyclerView? = null

    fun onAddSpotClicked(): View.OnClickListener {
        return View.OnClickListener { view ->
            spotFragment?.showAddSpotDialog()
        }
    }
}
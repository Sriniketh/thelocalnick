package booboo.thelocalnick.CreateTour

import android.view.View
import booboo.thelocalnick.data.Photo
import booboo.thelocalnick.data.Schedule
import booboo.thelocalnick.data.Spot
import booboo.thelocalnick.data.Tour
import java.util.ArrayList

class CreateTourViewModel {
    var spotFragment: SpotFragment? = null
    var tourTimeCostFragment: TourTimeCostFragment? = null
    var tourPhotosFragment: TourPhotosFragment? = null
    var tourScheduleFragment: TourScheduleFragment? = null
    var tour: Tour? = null
    var spots: List<Spot>? = ArrayList()
    var time: Float? = null
    var cost: Float? = null
    var schedule: List<Schedule>? = ArrayList()
    var photos: List<Photo>? = ArrayList()

    fun onAddSpotClicked(): View.OnClickListener {
        return View.OnClickListener { view ->
            spotFragment?.showAddSpotDialog()
        }
    }

    fun onAddTimeClicked(): View.OnClickListener {
        return View.OnClickListener {
            tourScheduleFragment?.showAddTimeDialog()
        }
    }

    fun onAddPhotosClicked(): View.OnClickListener {
        return View.OnClickListener { view ->
            tourPhotosFragment?.onClickAddPhotos()
        }
    }
}
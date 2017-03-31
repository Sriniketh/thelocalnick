package booboo.thelocalnick.CreateTour

import android.os.Bundle
import com.github.fcannizzaro.materialstepper.AbstractStep
import com.github.fcannizzaro.materialstepper.style.DotStepper

class CreateTourStepper : DotStepper() {
    var i: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        setTitle("Create Tour")
        var ctvm: CreateTourViewModel = CreateTourViewModel()
        addStep(createFragment(SpotFragment(ctvm)))
        addStep(createFragment(TourTimeCostFragment(ctvm)))
        addStep(createFragment(TourPhotosFragment(ctvm)))
        addStep(createFragment(TourScheduleFragment(ctvm)))
        super.onCreate(savedInstanceState)
    }

    private fun createFragment(fragment: AbstractStep): AbstractStep {
        val b = Bundle()
        b.putInt("position", i++)
        fragment.arguments = b
        return fragment
    }
}

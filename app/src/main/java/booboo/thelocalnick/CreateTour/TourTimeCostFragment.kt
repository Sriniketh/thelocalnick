package booboo.thelocalnick.CreateTour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import booboo.thelocalnick.databinding.FragmentCreateTourTimeCostBinding
import com.github.fcannizzaro.materialstepper.AbstractStep

class TourTimeCostFragment(createTourViewModel: CreateTourViewModel) : AbstractStep() {
    var binding: FragmentCreateTourTimeCostBinding? = null
    var createTourViewModel: CreateTourViewModel? = null

    init {
        this.createTourViewModel = createTourViewModel
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentCreateTourTimeCostBinding.inflate(inflater, container, false)
        createTourViewModel?.tourTimeCostFragment = this
        binding?.ctvm = createTourViewModel
        return binding?.root
    }

    override fun name(): String {
        return "Tab " + getArguments().getInt("position", 0)
    }

    override fun onNext() {
        createTourViewModel?.cost = binding?.tourCost?.text.toString().toFloat()
        createTourViewModel?.time = binding?.tourTime?.text.toString().toFloat()
        super.onNext()
    }

    override fun nextIf(): Boolean {
        return binding?.tourTime?.text.toString().isNotEmpty() && binding?.tourCost?.text.toString().isNotEmpty()
    }

    override fun error(): String {
        return "Please enter time and cost"
    }
}

package booboo.thelocalnick.CreateTour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import booboo.thelocalnick.databinding.FragmentCreateTourPhotosBinding
import booboo.thelocalnick.utils.BaseFragment
import com.github.fcannizzaro.materialstepper.AbstractStep

class TourPhotosFragment() : AbstractStep() {
    override fun name(): String {
        return "Tab " + getArguments().getInt("position", 0)
    }

    var binding: FragmentCreateTourPhotosBinding? = null
    var ctvm: CreateTourViewModel? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentCreateTourPhotosBinding.inflate(inflater, container, false)
        binding?.ctvm = ctvm
        return binding?.root
    }
}
package booboo.thelocalnick.exploreTour

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import booboo.thelocalnick.R

class ConfirmTourFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, parent: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, parent, savedInstanceState)
        val rootView = inflater!!.inflate(R.layout.activity_confirm_tour_fragment, parent, false)
        val bookBtn = rootView.findViewById(R.id.confirmBtn) as Button
        val passCount = rootView.findViewById(R.id.tourpass) as TextView

        return rootView
    }
}
package booboo.thelocalnick.tourListing

import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import booboo.thelocalnick.R
import booboo.thelocalnick.databinding.FragmentConfirmEmailBinding
import booboo.thelocalnick.signin.ConfirmEmailViewModel
import booboo.thelocalnick.utils.BaseFragment
import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.design.widget.FloatingActionButton
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.widget.AdapterView
import io.apptik.widget.MultiSlider
import android.widget.TextView
import booboo.thelocalnick.models.Tour
import java.util.*
import android.widget.AdapterView.OnItemSelectedListener




class FilterFragment(tourListingContent: TourListingContent) : DialogFragment() {


    var tourListing : TourListingContent? = null
    init {
        this.tourListing=tourListingContent
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            dialog.window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mainview = inflater.inflate(R.layout.content_filters, container,false)
        val spinnerSortBy = mainview.findViewById(R.id.spinnerSortBy) as Spinner
        val arrayAdapterSort = ArrayAdapter.createFromResource(context, R.array.sort_by, android.R.layout.simple_spinner_item)
        arrayAdapterSort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSortBy.adapter = arrayAdapterSort




        val s:Array<String>  = resources.getStringArray(R.array.sort_by)
        spinnerSortBy.setOnItemSelectedListener(object : OnItemSelectedListener {

            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View, position: Int, id: Long) {
                var sortedList = tourListing?.filterTour?.tours as MutableList<Tour>

                if(spinnerSortBy.selectedItem.equals(s[1])){

                    Collections.sort(sortedList, object : Comparator<Tour> {
                        override fun compare(x : Tour, y: Tour) = (x.rating.compareTo(y.rating)) as Int
                    })
                    val tileGenerator = GenerateTourTile(activity,sortedList)
                    tourListing!!.recyclerView?.adapter = tileGenerator
                    tourListing!!.recyclerView?.invalidate()

                }

                if(spinnerSortBy.selectedItem.equals(s[3])){
                    Collections.sort(sortedList, object : Comparator<Tour> {
                        override fun compare(x : Tour, y: Tour) = (x.price - y.price) as Int
                    })
                    val tileGenerator = GenerateTourTile(activity,sortedList)

                    tourListing!!.recyclerView?.adapter = tileGenerator
                    tourListing!!.recyclerView?.invalidate()
                }
                if(spinnerSortBy.selectedItem.equals(s[4])){
                    Collections.sort(sortedList, object : Comparator<Tour> {
                        override fun compare(x : Tour, y: Tour) = (y.price - x.price) as Int
                    })
                    val tileGenerator = GenerateTourTile(activity,sortedList)

                    tourListing!!.recyclerView?.adapter = tileGenerator
                    tourListing!!.recyclerView?.invalidate()
                }


            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                return;
            }

        })


        val tvPriceMin = mainview.findViewById(R.id.tvPriceMin) as TextView
        val tvPriceMax = mainview.findViewById(R.id.tvPriceMax) as TextView

        val priceRange = mainview.findViewById(R.id.seekbarPriceRange) as MultiSlider
        priceRange.setOnThumbValueChangeListener { multiSlider, thumb, thumbIndex, value ->
            var value = value
            value *= 5
            if (thumbIndex == 0) {
                tvPriceMin.text = value.toString()
            } else {
                tvPriceMax.text = value.toString()
            }
        }

        val spinnerDuration = mainview.findViewById(R.id.spinnerDuration) as Spinner
        val arrayAdapterDuration = ArrayAdapter.createFromResource(context, R.array.duration, android.R.layout.simple_spinner_item)
        arrayAdapterDuration.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDuration.adapter = arrayAdapterDuration
        val applyButton = mainview.findViewById(R.id.applyFilterButton)
        applyButton.setOnClickListener {
            dismiss()
        }

        return mainview

    }


}
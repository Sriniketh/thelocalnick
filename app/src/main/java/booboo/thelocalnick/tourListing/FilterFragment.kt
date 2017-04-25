package booboo.thelocalnick.tourListing

import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import booboo.thelocalnick.R
import booboo.thelocalnick.models.Tour
import io.apptik.widget.MultiSlider
import java.util.*




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
                        override fun compare(x : Tour, y: Tour) = (y.averageRating.compareTo(x.averageRating)) as Int
                    })
                    val tileGenerator = GenerateTourTile(activity,sortedList)
                    tourListing!!.recyclerView?.adapter = tileGenerator
                    tourListing!!.recyclerView?.invalidate()

                }

                if(spinnerSortBy.selectedItem.equals(s[3])){
                    Collections.sort(sortedList, object : Comparator<Tour> {
                        override fun compare(x : Tour, y: Tour) = (x.totalCost - y.totalCost) as Int
                    })
                    val tileGenerator = GenerateTourTile(activity,sortedList)

                    tourListing!!.recyclerView?.adapter = tileGenerator
                    tourListing!!.recyclerView?.invalidate()
                }
                if(spinnerSortBy.selectedItem.equals(s[4])){
                    Collections.sort(sortedList, object : Comparator<Tour> {
                        override fun compare(x : Tour, y: Tour) = (y.totalCost - x.totalCost) as Int
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
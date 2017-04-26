package booboo.thelocalnick.exploreTour

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import booboo.thelocalnick.R
import booboo.thelocalnick.models.Tour
import booboo.thelocalnick.utils.BaseFragment
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.squareup.picasso.Picasso
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import java.util.*
import booboo.thelocalnick.R.drawable.book
import booboo.thelocalnick.R.layout.fragment_explore_tour
import booboo.thelocalnick.gettingstarted.OnBoarding


class ExploreTourFragment : BaseFragment() {

    var tour: Tour? = null
    var slider: SliderLayout? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mainview = inflater.inflate(R.layout.fragment_explore_tour, container, false)
        slider = mainview.findViewById(R.id.onboardimageslider) as SliderLayout
        val titleTextView = mainview.findViewById(R.id.tour_title) as TextView
        titleTextView.text = tour?.tourTitle
        val priceTextView = mainview.findViewById(R.id.tour_price) as TextView
        priceTextView.text = '$' + tour?.totalCost.toString()
        val detailDescriptonTextView = mainview.findViewById(R.id.tour_description) as TextView
        detailDescriptonTextView.text = tour?.tourDescription
        val durationTextView = mainview.findViewById(R.id.tour_duration) as TextView
        durationTextView.text = tour?.tourDuration.toString() + " Hours"
        val guideNameTextView = mainview.findViewById(R.id.guide_name) as TextView
        guideNameTextView.text = tour?.guideName
        val guideImageView = mainview.findViewById(R.id.guide_image) as ImageView
        Picasso.with(activity)
                .load(tour!!.guideImage)
                .error(R.drawable.gs1)
                .into(guideImageView);
        mainview.visibility = View.VISIBLE
        //val headerImage = mainview.findViewById(R.id.header_image) as ImageView
//        Picasso.with(activity)
//                .load(tour!!.tourPhoto[0])
//                .error(R.drawable.gs1)
//                .into(headerImage);

        val now = Calendar.getInstance()
        val tpd = TimePickerDialog.newInstance(
                { view, hourOfDay, minute, second -> val time = "You picked the following time: " + hourOfDay + "h" + minute + "m" + second },
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                false
        )


        tpd.setAccentColor(resources.getColor(R.color.colorPrimary))
        val clockBtn = mainview.findViewById(R.id.pickTimeBtn) as ImageView
        clockBtn.setOnClickListener { tpd.show(fragmentManager, "TimePickerDialog") }

        val bookImage = mainview.findViewById(R.id.bookBtn) as ImageView
        bookImage.setOnClickListener {


            val fm = activity.fragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.fragment_explore_tour,ConfirmTourFragment()).commit()

        }


        initSlider(tour!!.tourPhoto)
        mainview.visibility = View.VISIBLE
        return mainview
    }


    fun initSlider(photos: List<String>) {

        for (url in photos) {
            val textSliderView = TextSliderView(activity)
            // initialize a SliderLayout
            textSliderView
                    .image(url)
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
            //add your extra information
            textSliderView.bundle(Bundle())
            textSliderView.bundle
                    .putString("extra", "")
            slider?.addSlider(textSliderView)
        }
        slider?.setPresetTransformer(SliderLayout.Transformer.Accordion)
        slider?.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        slider?.setCustomAnimation(DescriptionAnimation())
        slider?.setDuration(4000)
    }
}

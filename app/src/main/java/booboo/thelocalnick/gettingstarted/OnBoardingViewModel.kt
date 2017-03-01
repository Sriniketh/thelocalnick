package booboo.thelocalnick.gettingstarted

import android.databinding.BaseObservable
import android.os.Bundle
import android.view.View
import booboo.thelocalnick.R
import booboo.thelocalnick.signin.SignInFragment
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import java.util.*

class OnBoardingViewModel():BaseObservable() {
    var activity: OnBoarding? = null

    fun initSlider() {
        val url_maps = HashMap<String, Int>()
        url_maps.put("One",R.drawable.gs1)
        url_maps.put("Two", R.drawable.gs2)
        url_maps.put("Three", R.drawable.gs3)
        for (name in url_maps.keys) {
            val textSliderView = TextSliderView(activity?.activity)
            // initialize a SliderLayout
            textSliderView
                    .image(url_maps[name] as Int)
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
            //add your extra information
            textSliderView.bundle(Bundle())
            textSliderView.bundle
                    .putString("extra", name)

            activity?.binding?.onboardimageslider?.addSlider(textSliderView)
        }
        activity?.binding?.onboardimageslider?.setPresetTransformer(SliderLayout.Transformer.Accordion)
        activity?.binding?.onboardimageslider?.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        activity?.binding?.onboardimageslider?.setCustomAnimation(DescriptionAnimation())
        activity?.binding?.onboardimageslider?.setDuration(4000)
    }
    fun onGetStartedclicked(): View.OnClickListener {
        return View.OnClickListener { view ->
                SignInFragment().show(activity?.fragmentManager)
        }
    }
}
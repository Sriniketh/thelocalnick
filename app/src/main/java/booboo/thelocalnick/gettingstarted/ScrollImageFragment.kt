package booboo.thelocalnick.gettingstarted

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.daimajia.slider.library.Tricks.ViewPagerEx

import java.util.HashMap

import booboo.thelocalnick.R

import booboo.thelocalnick.R.layout.scroll_image_layout

public class ScrollImageFragment : Fragment(), BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private var mDemoSlider: SliderLayout? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View? {

        var view = inflater?.inflate(scroll_image_layout, container, false) as View

        mDemoSlider = view.findViewById(R.id.slider) as SliderLayout

        val file_maps = HashMap<String, Int>()
        file_maps.put("Explore local tours", R.drawable.gettingstarted1)
        file_maps.put("Share your local sights", R.drawable.gettingstarted2)
        file_maps.put("Become a guide", R.drawable.gettingstarted3)

        for (name in file_maps.keys) {
            val textSliderView = TextSliderView(inflater.inflate(scroll_image_layout, container, false).context)
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps[name] as Int)
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this)

            //add your extra information
            textSliderView.bundle(Bundle())
            textSliderView.bundle
                    .putString("extra", name)

            mDemoSlider!!.addSlider(textSliderView)
        }
        mDemoSlider!!.setPresetTransformer(SliderLayout.Transformer.Accordion)
        mDemoSlider!!.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        mDemoSlider!!.setCustomAnimation(DescriptionAnimation())
        mDemoSlider!!.setDuration(4000)
        mDemoSlider!!.addOnPageChangeListener(this)
        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onSliderClick(slider: BaseSliderView) {

    }
}

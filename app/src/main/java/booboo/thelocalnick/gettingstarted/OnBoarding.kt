package booboo.thelocalnick.gettingstarted


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.Button
import booboo.thelocalnick.AmazonCognito.AmazonCognitoHelper
import booboo.thelocalnick.R
import booboo.thelocalnick.signin.SignInFragment
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.facebook.CallbackManager
import java.util.*


class OnBoarding : FragmentActivity(), BaseSliderView.OnSliderClickListener {


    private var mImageSlider: SliderLayout? = null
    private var gettingStartedBtn: Button? = null
    private val signFrag: SignInFragment? = null
    var callbackManager: CallbackManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        AmazonCognitoHelper.init(applicationContext)
        callbackManager=CallbackManager.Factory.create();
        mImageSlider = findViewById(R.id.onboardimageslider) as SliderLayout
        gettingStartedBtn = findViewById(R.id.gettingstartedBtn) as Button

        val url_maps = HashMap<String, String>()
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg")
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png")
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg")
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg")

        val file_maps = HashMap<String, Int>()
        /*  file_maps.put("Hannibal",R.drawable.hannibal);
        file_maps.put("Big Bang Theory",R.drawable.bigbang);
        file_maps.put("House of Cards",R.drawable.house);
        file_maps.put("Game of Thrones", R.drawable.game_of_thrones);
*/
        for (name in url_maps.keys) {
            val textSliderView = TextSliderView(this)
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps[name])
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this)

            //add your extra information
            textSliderView.bundle(Bundle())
            textSliderView.bundle
                    .putString("extra", name)

            mImageSlider!!.addSlider(textSliderView)
        }
        mImageSlider!!.setPresetTransformer(SliderLayout.Transformer.Accordion)
        mImageSlider!!.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        mImageSlider!!.setCustomAnimation(DescriptionAnimation())
        mImageSlider!!.setDuration(4000)

        gettingStartedBtn!!.setOnClickListener {
            //signFrag=(SignInFragment)getFragmentManager();
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction()
                    .replace(R.id.activity_on_boarding, SignInFragment())
                    .commit()
        }


    }


    override fun onSliderClick(slider: BaseSliderView) {
        /* Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();*/
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager?.onActivityResult(requestCode, resultCode, data)
    }


}
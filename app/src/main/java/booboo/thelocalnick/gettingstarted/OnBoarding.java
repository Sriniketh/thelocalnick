package booboo.thelocalnick.gettingstarted;



import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.view.Window;
import android.view.WindowManager;

import android.widget.Button;



import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;


import java.util.HashMap;

import booboo.thelocalnick.R;
import booboo.thelocalnick.signin.SignInFragment;

public class OnBoarding extends FragmentActivity implements BaseSliderView.OnSliderClickListener {

        private SliderLayout mImageSlider;
        private Button gettingStartedBtn;
        private SignInFragment signFrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity_on_boarding);

        mImageSlider= (SliderLayout)findViewById(R.id.onboardimageslider);
        gettingStartedBtn= (Button) findViewById(R.id.gettingstartedBtn);

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
      /*  file_maps.put("Hannibal",R.drawable.hannibal);
        file_maps.put("Big Bang Theory",R.drawable.bigbang);
        file_maps.put("House of Cards",R.drawable.house);
        file_maps.put("Game of Thrones", R.drawable.game_of_thrones);
*/
        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mImageSlider.addSlider(textSliderView);
        }
        mImageSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mImageSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mImageSlider.setCustomAnimation(new DescriptionAnimation());
        mImageSlider.setDuration(4000);

        gettingStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //signFrag=(SignInFragment)getFragmentManager();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.activity_on_boarding, new SignInFragment())
                        .commit();
            }
        });



    }


    @Override
    public void onSliderClick(BaseSliderView slider) {
       /* Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();*/
    }


}

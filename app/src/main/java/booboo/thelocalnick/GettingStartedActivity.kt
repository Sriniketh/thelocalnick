package booboo.thelocalnick

import android.app.Activity
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import booboo.thelocalnick.databinding.ActivityGettingStartedBinding
import booboo.thelocalnick.gettingstarted.GettingStartedViewModel

import booboo.thelocalnick.gettingstarted.ScrollImageFragment

class GettingStartedActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_getting_started)
        var binding:ActivityGettingStartedBinding = DataBindingUtil.setContentView<ActivityGettingStartedBinding>(this , R.layout.activity_getting_started) as ActivityGettingStartedBinding
        val scrollImageFragment = ScrollImageFragment() as ScrollImageFragment
        var gsvm = GettingStartedViewModel(this) as GettingStartedViewModel;
        binding.gsvm = gsvm

            fragmentManager.beginTransaction()
                    .add(R.id.image_scroll_fragment, scrollImageFragment).commit()

    }
}

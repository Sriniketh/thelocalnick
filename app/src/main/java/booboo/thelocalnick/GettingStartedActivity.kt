package booboo.thelocalnick

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import booboo.thelocalnick.AmazonCognito.AmazonCognitoHelper
import booboo.thelocalnick.databinding.ActivityGettingStartedBinding
import booboo.thelocalnick.gettingstarted.GettingStartedViewModel
import booboo.thelocalnick.gettingstarted.ScrollImageFragment
import booboo.thelocalnick.signin.SignInFragment

class GettingStartedActivity : AppCompatActivity() {

    var gettingStartedActivity: GettingStartedActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_getting_started)

        AmazonCognitoHelper.init(applicationContext)

        var binding: ActivityGettingStartedBinding = DataBindingUtil.setContentView<ActivityGettingStartedBinding>(this, R.layout.activity_getting_started) as ActivityGettingStartedBinding
        val scrollImageFragment = ScrollImageFragment() as ScrollImageFragment
        val signInFragment = SignInFragment()
        var gsvm = GettingStartedViewModel(this) as GettingStartedViewModel;
        binding.gsvm = gsvm
        supportFragmentManager.beginTransaction()
                .add(R.id.image_scroll_fragment, signInFragment).commit()
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


    }
}

package booboo.thelocalnick.gettingstarted


import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import booboo.thelocalnick.databinding.ActivityOnBoardingBinding
import com.facebook.CallbackManager


class OnBoarding : Fragment(){

    var binding: ActivityOnBoardingBinding? =null
    val callbackManager = CallbackManager.Factory.create()
    override fun onCreateView(inflater: LayoutInflater?, parent: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, parent, savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(inflater, parent, false)
        var obvm = OnBoardingViewModel()
        obvm.activity = this
        binding?.obvm = obvm
        obvm.initSlider()
        return binding?.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

}
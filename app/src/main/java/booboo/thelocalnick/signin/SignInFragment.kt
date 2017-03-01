package booboo.thelocalnick.signin


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import booboo.thelocalnick.databinding.FragmentSignInBinding
import booboo.thelocalnick.utils.BaseFragment

class SignInFragment : BaseFragment() {
    var binding:FragmentSignInBinding? = null
    override fun onCreateView(inflater: LayoutInflater?, parent: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, parent, savedInstanceState)
        binding = FragmentSignInBinding.inflate(inflater, parent, false)
        var sivm = SignInViewModel()
        sivm.signInFragment = this
        binding?.sivm = sivm
        return binding?.root
    }
}
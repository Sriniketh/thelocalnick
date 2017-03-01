package booboo.thelocalnick.signin


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import booboo.thelocalnick.databinding.FragmentCreateAccountBinding
import booboo.thelocalnick.utils.BaseFragment

class SignUpFragment : BaseFragment() {
    var binding:FragmentCreateAccountBinding? = null
    override fun onCreateView(inflater: LayoutInflater?, parent: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, parent, savedInstanceState)
        binding= FragmentCreateAccountBinding.inflate(inflater, parent, false) as FragmentCreateAccountBinding
        var suvm = SignUpViewModel() as SignUpViewModel;
        binding?.suvm = suvm
        suvm.signUpFragment = this
        return binding?.root
    }
}
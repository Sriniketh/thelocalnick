package booboo.thelocalnick.signin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import booboo.thelocalnick.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, parent: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, parent, savedInstanceState)
        var binding:FragmentSignInBinding = FragmentSignInBinding.inflate(inflater, parent, false) as FragmentSignInBinding
        var sivm = SignInViewModel(binding) as SignInViewModel;
        binding.sivm = sivm
        return binding.root
    }

}
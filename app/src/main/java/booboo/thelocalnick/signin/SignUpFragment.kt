package booboo.thelocalnick.signin


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import booboo.thelocalnick.R
import booboo.thelocalnick.databinding.FragmentCreateAccountBinding
import booboo.thelocalnick.databinding.FragmentSignInBinding

class SignUpFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, parent: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, parent, savedInstanceState)
        var binding:FragmentCreateAccountBinding = FragmentCreateAccountBinding.inflate(inflater, parent, false) as FragmentCreateAccountBinding
        var suvm = SignUpViewModel(binding) as SignUpViewModel;
        binding.suvm = suvm
        return binding.root

    }
}
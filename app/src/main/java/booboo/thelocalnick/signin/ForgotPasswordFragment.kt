package booboo.thelocalnick.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import booboo.thelocalnick.databinding.FragmentConfirmEmailBinding
import booboo.thelocalnick.databinding.FragmentForgotPasswordBinding
import booboo.thelocalnick.utils.BaseFragment

class ForgotPasswordFragment : BaseFragment() {

    var binding: FragmentForgotPasswordBinding? = null
    override fun onCreateView(inflater: LayoutInflater?, parent: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, parent, savedInstanceState)
        binding= FragmentForgotPasswordBinding.inflate(inflater, parent, false) as FragmentForgotPasswordBinding
        var cevm = ForgotPasswordViewModel()
        binding?.cevm = cevm
        //cevm.confirmEmailFragment = this
        return binding?.root
    }
}
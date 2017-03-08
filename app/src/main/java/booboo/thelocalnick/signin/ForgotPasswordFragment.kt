package booboo.thelocalnick.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import booboo.thelocalnick.databinding.FragmentConfirmEmailBinding
import booboo.thelocalnick.utils.BaseFragment

class ForgotPasswordFragment : BaseFragment() {

    var binding: FragmentConfirmEmailBinding? = null
    override fun onCreateView(inflater: LayoutInflater?, parent: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, parent, savedInstanceState)
        var binding: FragmentConfirmEmailBinding = FragmentConfirmEmailBinding.inflate(inflater, parent, false) as FragmentConfirmEmailBinding
        var cevm = ConfirmEmailViewModel()
        binding.cevm = cevm
        //cevm.confirmEmailFragment = this
        return binding.root
    }
}
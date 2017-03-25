package booboo.thelocalnick.signin


import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import booboo.thelocalnick.databinding.FragmentSignInBinding

class SigninDialog : DialogFragment() {
    var binding:FragmentSignInBinding? = null
    override fun onCreateView(inflater: LayoutInflater?, parent: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, parent, savedInstanceState)
        binding = FragmentSignInBinding.inflate(inflater, parent, false)
        return binding?.root
    }
}
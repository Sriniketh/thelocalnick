package booboo.thelocalnick.user

import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import booboo.thelocalnick.R
import booboo.thelocalnick.utils.BaseFragment

class UserAccountScreen : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mainview = inflater.inflate(R.layout.user_profile, container, false)

        return mainview
    }
}
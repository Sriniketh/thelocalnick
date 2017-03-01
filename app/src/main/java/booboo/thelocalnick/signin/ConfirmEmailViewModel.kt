package booboo.thelocalnick.signin

import android.databinding.BaseObservable
import android.view.View
import booboo.thelocalnick.AmazonCognito.AmazonCognitoHelper
import booboo.thelocalnick.R

class ConfirmEmailViewModel:BaseObservable() {
    var confirmEmailFragment: ConfirmEmailFragment? = null

    fun onConfirmclicked(): View.OnClickListener {
        return View.OnClickListener { view ->
            validateInputs()
        }
    }

    fun validateInputs() {
        if(confirmEmailFragment?.binding?.etConfirmationCode == null) {
            confirmEmailFragment?.showDialogMessage(confirmEmailFragment?.getString(R.string.sign_up_failed),confirmEmailFragment?.getString(R.string.confirmation_code_empty))
        }
        else {
            AmazonCognitoHelper.getAppHelper().performConfirmation(this)
        }

    }

    fun onResendclicked(): View.OnClickListener {
        return View.OnClickListener { view ->
            AmazonCognitoHelper.getAppHelper().performResend(this)
        }
    }
}

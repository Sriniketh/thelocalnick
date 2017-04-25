package booboo.thelocalnick.signin

import android.databinding.BaseObservable
import android.view.View
import booboo.thelocalnick.R

class ForgotPasswordViewModel: BaseObservable() {
    var forgotPasswordFragment: ForgotPasswordFragment? = null

    fun onConfirmclicked(): View.OnClickListener {
        return View.OnClickListener { view ->
            validateInputs()
        }
    }

    fun validateInputs() {
        if(forgotPasswordFragment?.binding?.etVerificationCode?.text == null||forgotPasswordFragment?.binding?.etVerificationCode?.text.toString().equals("")) {
            forgotPasswordFragment?.showDialogMessage(forgotPasswordFragment?.getString(R.string.sign_up_failed),forgotPasswordFragment?.getString(R.string.confirmation_code_empty))
        }
        else {
            //AmazonCognitoHelper.getAppHelper().performConfirmation(this)
        }

    }

}
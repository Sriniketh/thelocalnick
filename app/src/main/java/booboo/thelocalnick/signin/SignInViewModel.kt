package booboo.thelocalnick.signin


import android.databinding.BaseObservable
import android.view.View
import booboo.thelocalnick.AmazonCognito.AmazonCognitoHelper
import booboo.thelocalnick.AmazonCognito.FacebookCognitoHelper
import booboo.thelocalnick.R

class SignInViewModel():BaseObservable() {

    var signInFragment:SignInFragment? = null

    fun onSignInclicked(): View.OnClickListener {
        return View.OnClickListener { view ->
            validateInput()
        }
    }

    fun validateInput(){
        if((signInFragment?.binding?.emailID?.text==null)||(signInFragment?.binding?.etPassword?.text==null)||signInFragment?.binding?.emailID?.text.toString()==""||signInFragment?.binding?.etPassword?.text.toString()=="") {
            signInFragment?.showDialogMessage(signInFragment?.getString(R.string.sign_in_failed),signInFragment?.getString(R.string.username_password_empty))
        }
        else {
            AmazonCognitoHelper.getAppHelper().performLogin(this)
        }
    }

    fun onFacebookSignInclicked(): View.OnClickListener {
        return View.OnClickListener { view ->
            FacebookCognitoHelper(signInFragment?.activity).performFbLogin()
        }
    }

    fun onCreateAccountclicked(): View.OnClickListener {
        return View.OnClickListener { view ->
            SignUpFragment().show(signInFragment?.activity?.fragmentManager)
        }
    }

    fun showConfirmationCodePage(){
        ConfirmEmailFragment().show(signInFragment?.activity?.fragmentManager)
    }

}


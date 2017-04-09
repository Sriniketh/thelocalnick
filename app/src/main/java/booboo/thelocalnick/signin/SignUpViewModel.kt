
package booboo.thelocalnick.signin


import android.view.View
import booboo.thelocalnick.AmazonCognito.AmazonCognitoHelper
import booboo.thelocalnick.AmazonCognito.FacebookCognitoHelper

class SignUpViewModel() {


    var signUpFragment:SignUpFragment?=null

    fun showConfirmationCodePage(){
        ConfirmEmailFragment().show(signUpFragment?.activity?.fragmentManager)
    }
    fun onSignupclicked(): View.OnClickListener {
        return View.OnClickListener { view ->
            AmazonCognitoHelper.getAppHelper().performSignUp(this)
        }
    }

    fun onFacebookSignInclicked(): View.OnClickListener {
        return View.OnClickListener { view ->
            FacebookCognitoHelper(signUpFragment?.activity).performFbLogin()
        }
    }

}


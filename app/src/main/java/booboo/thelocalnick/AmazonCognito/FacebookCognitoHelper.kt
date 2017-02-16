package booboo.thelocalnick.AmazonCognito

import android.app.Activity
import booboo.thelocalnick.GettingStartedActivity
import booboo.thelocalnick.databinding.FragmentSignInBinding
import com.amazonaws.auth.AWSAbstractCognitoIdentityProvider
import com.amazonaws.auth.CognitoCachingCredentialsProvider
import com.amazonaws.mobileconnectors.cognito.CognitoSyncManager
import com.amazonaws.regions.Regions
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import java.util.*

class FacebookCognitoHelper(binding: FragmentSignInBinding?) {
    var callbackManager: CallbackManager? = null
    var syncClient: CognitoSyncManager? = null
    var credentialsProvider: CognitoCachingCredentialsProvider? = null
    var developerIdentityProvider: AWSAbstractCognitoIdentityProvider? = null
    var binding: FragmentSignInBinding?
    val cognitoRegion = Regions.DEFAULT_REGION

    init {
        callbackManager = (binding?.root as GettingStartedActivity).getCallbackManager()
        this.binding = binding
        credentialsProvider = CognitoCachingCredentialsProvider(binding?.root?.context, "us-west-2:366db6a1-22aa-4c2b-b5f6-34a75e1d7b20", cognitoRegion)
        //syncClient = CognitoSyncManager(context, REGION, credentialsProvider)
    }

    var fbcallback = object : FacebookCallback<LoginResult> {

        override fun onSuccess(loginResult: LoginResult) {
            System.out.println("Login Successful");
            addLogins("graph.facebook.com", loginResult.accessToken.token)
            //btnLoginFacebook.setVisibility(View.GONE)
            //GetFbName(loginResult).execute()
            //setFacebookSession(loginResult.getAccessToken())
        }

        override fun onCancel() {
            System.out.println("Login UnSuccessful");
            //Toast.makeText(this@MainActivity, "Facebook login cancelled",
            //Toast.LENGTH_LONG).show()
        }

        override fun onError(error: FacebookException) {
            System.out.println("Login UnSuccessful");
            //Toast.makeText(this, "Error in Facebook login " + error.getMessage(), Toast.LENGTH_LONG).show()
        }
    }

    fun performFbLogin() {
        LoginManager.getInstance().logInWithReadPermissions((binding?.root?.context) as Activity, Arrays.asList("public_profile"))
        LoginManager.getInstance().registerCallback(callbackManager, fbcallback)
    }

    fun addLogins(providerName: String, token: String) {
        if (syncClient == null) {
            throw IllegalStateException("CognitoSyncClientManager not initialized yet")
        }

        var logins: MutableMap<String, String>? = credentialsProvider?.getLogins()
        if (logins == null) {
            logins = HashMap<String, String>()
        }
        logins.put(providerName, token)
        credentialsProvider?.setLogins(logins)
    }

}
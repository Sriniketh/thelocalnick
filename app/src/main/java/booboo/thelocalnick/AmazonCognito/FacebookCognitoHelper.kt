package booboo.thelocalnick.AmazonCognito

import android.app.Activity
import android.util.Log
import booboo.thelocalnick.gettingstarted.OnBoarding
import com.amazonaws.auth.AWSAbstractCognitoIdentityProvider
import com.amazonaws.auth.CognitoCachingCredentialsProvider
import com.amazonaws.mobileconnectors.cognito.CognitoSyncManager
import com.amazonaws.regions.Regions
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import java.util.*

class FacebookCognitoHelper(activity: Activity?) {
    var callbackManager: CallbackManager? = null
    var syncClient: CognitoSyncManager? = null
    var credentialsProvider: CognitoCachingCredentialsProvider? = null
    var developerIdentityProvider: AWSAbstractCognitoIdentityProvider? = null
    val cognitoRegion = Regions.DEFAULT_REGION
    var activity = activity

    init {
        callbackManager = (activity as OnBoarding).callbackManager
        credentialsProvider = CognitoCachingCredentialsProvider(activity, "us-west-2:366db6a1-22aa-4c2b-b5f6-34a75e1d7b20", cognitoRegion)
        syncClient = CognitoSyncManager(activity, cognitoRegion, credentialsProvider)
    }

    var fbcallback = object : FacebookCallback<LoginResult> {

        override fun onSuccess(loginResult: LoginResult) {
            System.out.println("Login Successful");
            Thread(Runnable {
                try {
                    addLogins("graph.facebook.com", loginResult.accessToken.token)
                } catch (e: Exception) {
                    Log.w("oauth fail", e)
                }
            }).start()

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
        LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList("public_profile"))
        LoginManager.getInstance().registerCallback(callbackManager, fbcallback)
    }

    fun addLogins(providerName: String, token: String) {

        var logins: MutableMap<String, String>? = credentialsProvider?.getLogins()
        if (logins == null) {
            logins = HashMap<String, String>()
        }
        logins.put(providerName, token)
        credentialsProvider?.setLogins(logins)
        credentialsProvider?.refresh();
        credentialsProvider?.logins
    }

}
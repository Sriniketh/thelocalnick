package booboo.thelocalnick.AmazonCognito;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.NewPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import booboo.thelocalnick.signin.SignInViewModel;

/**
 * Created by AshwinKumar on 2/10/17.
 */

public class AmazonCognitoHelper {

    private static AmazonCognitoHelper appHelper;
    private static CognitoUserPool userPool;
    private static CognitoUserAttributes attributesChanged;
    private static List<AttributeType> attributesToDelete;
    private static CognitoDevice newDevice;

    private static  int itemCount;

    private static int trustedDevicesCount;
    private static List<CognitoDevice> deviceDetails;
    private static CognitoDevice thisDevice;
    private static boolean thisDeviceTrustState;

    private static Map<String, String> firstTimeLogInUserAttributes;
    private static List<String> firstTimeLogInRequiredAttributes;
    private static int firstTimeLogInItemsCount;
    private static Map<String, String> firstTimeLogInUpDatedAttributes;
    private static String firstTimeLoginNewPassword;
    private String TAG = "AMAZON COGNITO HELPER";
    private String username;
    private String password;

    /**
     * Add your pool id here
     */
    private static final String userPoolId = "us-west-2_qi9gL7F6h";

    /**
     * Add you app id
     */
    private static final String clientId = "2qg2at4k67166m7egghflughek";

    /**
     * App secret associated with your app id - if the App id does not have an associated App secret,
     * set the App secret to null.
     * e.g. clientSecret = null;
     */
    private static final String clientSecret = null;

    /**
     * Set Your User Pools region.
     * e.g. if your user pools are in US East (N Virginia) then set cognitoRegion = Regions.US_EAST_1.
     */
    private static final Regions cognitoRegion = Regions.DEFAULT_REGION;

    // User details from the service
    private static CognitoUserSession currSession;
    private static CognitoUserDetails userDetails;

    // User details to display - they are the current values, including any local modification
    private static boolean phoneVerified;
    private static boolean emailVerified;

    private static boolean phoneAvailable;
    private static boolean emailAvailable;

    private static Set<String> currUserAttributes;

    AuthenticationHandler authenticationHandler = new AuthenticationHandler() {
        @Override
        public void onSuccess(CognitoUserSession cognitoUserSession, CognitoDevice device) {
            Log.e("AWS", "Auth Success");
            AmazonCognitoHelper.setCurrSession(cognitoUserSession);
            AmazonCognitoHelper.newDevice(device);
            //closeWaitDialog();
            //launchUser();
        }

        @Override
        public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String username) {
            //closeWaitDialog();
            Locale.setDefault(Locale.US);
            getUserAuthentication(authenticationContinuation);
        }

        @Override
        public void getMFACode(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
            //closeWaitDialog();
            //mfaAuth(multiFactorAuthenticationContinuation);
        }

        @Override
        public void onFailure(Exception e) {
            System.out.println("wrong password");
            //closeWaitDialog();
            //TextView label = (TextView) findViewById(R.id.textViewUserIdMessage);
            //label.setText("Sign-in failed");
            //inPassword.setBackground(getDrawable(R.drawable.text_border_error));

            //label = (TextView) findViewById(R.id.textViewUserIdMessage);
            //label.setText("Sign-in failed");
            //inUsername.setBackground(getDrawable(R.drawable.text_border_error));

            //showDialogMessage("Sign-in failed", AppHelper.formatException(e));
        }

        @Override
        public void authenticationChallenge(ChallengeContinuation continuation) {
            /**
             * For Custom authentication challenge, implement your logic to present challenge to the
             * user and pass the user's responses to the continuation.
             */
            if ("NEW_PASSWORD_REQUIRED".equals(continuation.getChallengeName())) {
                // This is the first sign-in attempt for an admin created user
//                newPasswordContinuation = (NewPasswordContinuation) continuation;
//                AppHelper.setUserAttributeForDisplayFirstLogIn(newPasswordContinuation.getCurrentUserAttributes(),
//                        newPasswordContinuation.getRequiredAttributes());
//                closeWaitDialog();
//                firstTimeSignIn();
            }
        }
    };

    public static void init(Context context) {
        //setData();

        if (appHelper != null && userPool != null) {
            return;
        }

        if (appHelper == null) {
            appHelper = new AmazonCognitoHelper();
        }

        if (userPool == null) {

            // Create a user pool with default ClientConfiguration
            userPool = new CognitoUserPool(context, userPoolId, clientId, clientSecret, cognitoRegion);

            // This will also work
            /*
            ClientConfiguration clientConfiguration = new ClientConfiguration();
            AmazonCognitoIdentityProvider cipClient = new AmazonCognitoIdentityProviderClient(new AnonymousAWSCredentials(), clientConfiguration);
            cipClient.setRegion(Region.getRegion(cognitoRegion));
            userPool = new CognitoUserPool(context, userPoolId, clientId, clientSecret, cipClient);
            */

        }

        phoneVerified = false;
        phoneAvailable = false;
        emailVerified = false;
        emailAvailable = false;

        currUserAttributes = new HashSet<String>();
        firstTimeLogInUpDatedAttributes= new HashMap<String, String>();

        thisDevice = null;
        thisDeviceTrustState = false;
    }

    public void performLogin(SignInViewModel signInViewModel,String userName,String password) {
        this.username = userName;
        this.password = password;

        AmazonCognitoHelper.userPool.getUser(userName).getSessionInBackground(authenticationHandler);
    }

    private void getUserAuthentication(AuthenticationContinuation continuation) {

        if(this.password == null) {
            if(password == null) {
//                TextView label = (TextView) findViewById(R.id.textViewUserPasswordMessage);
//                label.setText(inPassword.getHint()+" enter password");
//                inPassword.setBackground(getDrawable(R.drawable.text_border_error));
                return;
            }

            if(password.length() < 1) {
//                TextView label = (TextView) findViewById(R.id.textViewUserPasswordMessage);
//                label.setText(inPassword.getHint()+" enter password");
//                inPassword.setBackground(getDrawable(R.drawable.text_border_error));
                return;
            }
        }
        AuthenticationDetails authenticationDetails = new AuthenticationDetails(this.username, this.password, null);
        continuation.setAuthenticationDetails(authenticationDetails);
        continuation.continueTask();
    }




    public static void setCurrSession(CognitoUserSession session) {
        currSession = session;
    }
    public static void newDevice(CognitoDevice device) {
        newDevice = device;
    }
    public static CognitoUserPool getPool() {return userPool;}
    public static String formatException(Exception exception) {
        String formattedString = "Internal Error";
        Log.e("App Error",exception.toString());
        Log.getStackTraceString(exception);

        String temp = exception.getMessage();

        if(temp != null && temp.length() > 0) {
            formattedString = temp.split("\\(")[0];
            if(temp != null && temp.length() > 0) {
                return formattedString;
            }
        }

        return  formattedString;
    }
}

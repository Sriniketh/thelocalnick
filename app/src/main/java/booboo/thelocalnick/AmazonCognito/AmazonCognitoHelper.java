package booboo.thelocalnick.AmazonCognito;
import android.content.Context;
import android.util.Log;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.VerificationHandler;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import booboo.thelocalnick.R;
import booboo.thelocalnick.databinding.FragmentCreateAccountBinding;
import booboo.thelocalnick.signin.ConfirmEmailViewModel;
import booboo.thelocalnick.signin.SignInViewModel;
import booboo.thelocalnick.signin.SignUpViewModel;

public class AmazonCognitoHelper {

    private static AmazonCognitoHelper appHelper;
    private static CognitoUserPool userPool;
    private static CognitoUserAttributes attributesChanged;
    private static List<AttributeType> attributesToDelete;
    private static CognitoDevice newDevice;
    CognitoUserAttributes userAttributes = new CognitoUserAttributes();
    private static  int itemCount;
    private static Map<String, String> signUpFieldsC2O;
    private static Map<String, String> signUpFieldsO2C;
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
    SignInViewModel signInViewModel;
    SignUpViewModel signUpViewModel;
    ConfirmEmailViewModel confirmEmailViewModel;

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
        }

        @Override
        public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String username) {
            Locale.setDefault(Locale.US);
            getUserAuthentication(authenticationContinuation);
        }

        @Override
        public void getMFACode(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
        }

        @Override
        public void onFailure(Exception e) {
            if(e.getClass().getName().equalsIgnoreCase("com.amazonaws.services.cognitoidentityprovider.model.UserNotConfirmedException")){
                signInViewModel.showConfirmationCodePage();
            }
            else {
                signInViewModel.getSignInFragment().showDialogMessage("",formatException(e));
            }
        }

        @Override
        public void authenticationChallenge(ChallengeContinuation continuation) {
            if ("NEW_PASSWORD_REQUIRED".equals(continuation.getChallengeName())) {

            }
        }
    };

    SignUpHandler signUpHandler = new SignUpHandler() {
        @Override
        public void onSuccess(CognitoUser user, boolean signUpConfirmationState,
                              CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails) {
            signUpViewModel.getSignUpFragment().closeWaitDialog();
            Boolean regState = signUpConfirmationState;
            if (signUpConfirmationState) {
                // User is already confirmed
                signUpViewModel.showConfirmationCodePage();
            }
            else {
                // User is not confirmed
                //confirmSignUp(cognitoUserCodeDeliveryDetails);
                signUpViewModel.showConfirmationCodePage();
            }
        }
        public void onFailure(Exception exception) {
            signUpViewModel.getSignUpFragment().closeWaitDialog();
            signUpViewModel.getSignUpFragment().showDialogMessage("",formatException(exception));
            signUpViewModel.showConfirmationCodePage();
        }
    };

    GenericHandler confHandler = new GenericHandler() {
        @Override
        public void onSuccess() {
            //Move to homepage
            //TO-DO
            confirmEmailViewModel.getConfirmEmailFragment().closeWaitDialog();
        }

        @Override
        public void onFailure(Exception exception) {
            confirmEmailViewModel.getConfirmEmailFragment().closeWaitDialog();
        }
    };

    VerificationHandler resendConfCodeHandler = new VerificationHandler() {
        @Override
        public void onSuccess(CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails) {
            confirmEmailViewModel.getConfirmEmailFragment().showDialogMessage("Confirmation code sent.","Code sent to "+cognitoUserCodeDeliveryDetails.getDestination()+" via "+cognitoUserCodeDeliveryDetails.getDeliveryMedium()+".");
        }

        @Override
        public void onFailure(Exception exception) {
            confirmEmailViewModel.getConfirmEmailFragment().showDialogMessage("Confirmation code request has failed", formatException(exception));
        }
    };

    public static void init(Context context) {

        if (appHelper != null && userPool != null) {
            return;
        }

        if (appHelper == null) {
            appHelper = new AmazonCognitoHelper();
        }

        if (userPool == null) {
            // Create a user pool with default ClientConfiguration
            userPool = new CognitoUserPool(context, userPoolId, clientId, clientSecret, cognitoRegion);
        }

        phoneVerified = false;
        phoneAvailable = false;
        emailVerified = false;
        emailAvailable = false;

        currUserAttributes = new HashSet<String>();
        firstTimeLogInUpDatedAttributes= new HashMap<String, String>();

        thisDevice = null;
        thisDeviceTrustState = false;

        signUpFieldsC2O = new HashMap<String, String>();
        signUpFieldsC2O.put("name", "name");
        signUpFieldsC2O.put("Family name", "family_name");
        signUpFieldsC2O.put("Nick name", "nickname");
        signUpFieldsC2O.put("Phone number", "phone_number");
        signUpFieldsC2O.put("Phone number verified", "phone_number_verified");
        signUpFieldsC2O.put("Email verified", "email_verified");
        signUpFieldsC2O.put("Email","email");
        signUpFieldsC2O.put("Middle name","middle_name");
        signUpFieldsO2C = new HashMap<String, String>();
        signUpFieldsO2C.put("name", "name");
        signUpFieldsO2C.put("family_name", "Family name");
        signUpFieldsO2C.put("nickname", "Nick name");
        signUpFieldsO2C.put("phone_number", "Phone number");
        signUpFieldsO2C.put("phone_number_verified", "Phone number verified");
        signUpFieldsO2C.put("email_verified", "Email verified");
        signUpFieldsO2C.put("email", "Email");
        signUpFieldsO2C.put("middle_name", "Middle name");
    }

    public void performLogin(SignInViewModel signInViewModel) {
        this.signInViewModel = signInViewModel;
        this.username = signInViewModel.getSignInFragment().getBinding().emailID.getText().toString();
        this.password = signInViewModel.getSignInFragment().getBinding().etPassword.getText().toString();
        AmazonCognitoHelper.userPool.getUser(username).getSessionInBackground(authenticationHandler);
    }

    public void performSignUp(SignUpViewModel signUpViewModel) {
        this.signUpViewModel = signUpViewModel;
        FragmentCreateAccountBinding binding = signUpViewModel.getSignUpFragment().getBinding();
        this.username = binding.signUpEmailID.getText().toString();
        this.password = binding.signUpPassword.getText().toString();
        userAttributes.addAttribute(signUpFieldsC2O.get("name"),binding.name.getText().toString());
        userAttributes.addAttribute(signUpFieldsC2O.get("Phone number"),binding.signUpPhonenumber.getText().toString());
        userAttributes.addAttribute(signUpFieldsC2O.get("Email"),username);
        signUpViewModel.getSignUpFragment().showWaitDialog(signUpViewModel.getSignUpFragment().getString(R.string.signing_up));
        getPool().signUpInBackground(username, password, userAttributes, null, signUpHandler);
    }

    public void performConfirmation(ConfirmEmailViewModel confirmEmailViewModel){
        this.confirmEmailViewModel = confirmEmailViewModel;
        String confirmCode = confirmEmailViewModel.getConfirmEmailFragment().getBinding().etConfirmationCode.getText().toString();
        confirmEmailViewModel.getConfirmEmailFragment().showWaitDialog(confirmEmailViewModel.getConfirmEmailFragment().getString(R.string.signing_up));
        getPool().getUser(username).confirmSignUpInBackground(confirmCode, true, confHandler);
    }

    public void performResend(ConfirmEmailViewModel confirmEmailViewModel){
        this.confirmEmailViewModel = confirmEmailViewModel;
        getPool().getUser(username).resendConfirmationCodeInBackground(resendConfCodeHandler);
    }


    private void getUserAuthentication(AuthenticationContinuation continuation) {

        if(this.password == null) {
            if(password == null) {
                return;
            }

            if(password.length() < 1) {
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
    public static AmazonCognitoHelper getAppHelper(){
        return appHelper;
    }
}

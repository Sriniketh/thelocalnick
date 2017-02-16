package booboo.thelocalnick.signin


import android.view.View

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import booboo.thelocalnick.AmazonCognito.AmazonCognitoHelper
import booboo.thelocalnick.AmazonCognito.FacebookCognitoHelper
import booboo.thelocalnick.R
import booboo.thelocalnick.databinding.FragmentSignInBinding
import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.CognitoCachingCredentialsProvider
import com.amazonaws.auth.CognitoCredentialsProvider
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult


import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import java.util.*


/**
 * Created by AshwinKumar on 2/13/17.
 */

class SignInViewModel(binding: FragmentSignInBinding) {

    var binding:FragmentSignInBinding? = null
    var activity:Activity? = null
    var subject1 = PublishSubject.create<String>()

    val ob = object : Observer<String> {

        override fun onSubscribe(d: Disposable) {

        }

        override fun onNext(value: String?) {

        }

        override fun onError(e: Throwable) {

        }

        override fun onComplete() {

        }
    }

    init {
        this.binding = binding
    }

    public fun updateUI(){
        subject1.subscribe(ob)
        binding?.forgotPassword?.text = "HI"
        subject1.onNext("Fuck you")
    }

    fun onSignInclicked(): View.OnClickListener {
        return View.OnClickListener { view ->
            System.out.println("Clicked SignIn");
            AmazonCognitoHelper().performLogin(this,binding?.emailID?.text.toString(),binding?.etPassword?.text.toString())
        }
    }

    fun onFacebookSignInclicked(): View.OnClickListener {
        return View.OnClickListener { view ->
            FacebookCognitoHelper(activity).performFbLogin()
        }
    }


}


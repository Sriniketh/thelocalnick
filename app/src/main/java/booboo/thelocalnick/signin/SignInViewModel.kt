package booboo.thelocalnick.signin


import android.view.View
import booboo.thelocalnick.AmazonCognito.AmazonCognitoHelper
import booboo.thelocalnick.databinding.FragmentSignInBinding
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject


/**
 * Created by AshwinKumar on 2/13/17.
 */

class SignInViewModel(binding: FragmentSignInBinding) {

    var binding:FragmentSignInBinding? = null
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


}


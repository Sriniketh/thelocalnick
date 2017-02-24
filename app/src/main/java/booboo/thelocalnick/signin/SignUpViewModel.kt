
package booboo.thelocalnick.signin


import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.TextView
import booboo.thelocalnick.AmazonCognito.AmazonCognitoHelper
import booboo.thelocalnick.R
import booboo.thelocalnick.databinding.FragmentCreateAccountBinding
import booboo.thelocalnick.databinding.FragmentSignInBinding


import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subscribers.*

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


/**
 * Created by AshwinKumar on 2/13/17.
 */

class SignUpViewModel(binding: FragmentCreateAccountBinding) {

    var binding: FragmentCreateAccountBinding? = null
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

    fun onSignupclicked(): View.OnClickListener {
        return View.OnClickListener { view ->

        }
    }


}


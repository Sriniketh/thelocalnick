package booboo.thelocalnick.gettingstarted

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import booboo.thelocalnick.R
import booboo.thelocalnick.signup.LoginFragment

/**
 * Created by AshwinKumar on 2/8/17.
 */
public class GettingStartedViewModel(context: Context) {
        var context:Context? = null;
        init {
            this.context = context
        }
        fun onGetStartedClicked(): View.OnClickListener {
            return View.OnClickListener { view ->
                (context as Activity).getFragmentManager().beginTransaction()
                        .replace(R.id.image_scroll_fragment, LoginFragment()).commit()
            }
        }
}
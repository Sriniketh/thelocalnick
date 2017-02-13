package booboo.thelocalnick.gettingstarted

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.View
import booboo.thelocalnick.R
import booboo.thelocalnick.signin.SignInFragment

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
                (context as AppCompatActivity).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.image_scroll_fragment, SignInFragment()).commit()
            }
        }
}
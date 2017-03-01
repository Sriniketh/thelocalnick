package booboo.thelocalnick.utils

import android.app.Activity
import android.app.Fragment
import booboo.thelocalnick.R

/**
 * Created by AshwinKumar on 2/27/17.
 */

open class BaseActivity:Activity(){
    public fun show(fragment: Fragment){
        val fm = fragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.output,fragment)
        ft.commit()
    }

    public fun present(fragment: Fragment) {
        val ft = fragmentManager.beginTransaction()
        ft.replace(R.id.output, fragment)
        ft.commit()
    }

}
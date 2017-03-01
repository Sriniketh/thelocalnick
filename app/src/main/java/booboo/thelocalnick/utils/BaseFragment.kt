package booboo.thelocalnick.utils

import android.app.Fragment
import android.app.FragmentManager
import android.app.ProgressDialog
import android.support.v7.app.AlertDialog
import booboo.thelocalnick.R

/**
 * Created by AshwinKumar on 2/27/17.
 */
open public class BaseFragment : Fragment() {
    var userDialog: AlertDialog? = null
    var waitDialog: ProgressDialog? = null
    public fun show(fragmentManager: FragmentManager?) {
        val fm = fragmentManager
        val ft = fm?.beginTransaction()
        ft?.replace(R.id.output, this)
        ft?.addToBackStack(null)
        ft?.commit()
    }

    public fun present(){
        val fm = fragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.output, this)
        ft.commit()
    }

     fun showDialogMessage(title: String?, body: String?) {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle(title).setMessage(body).setNeutralButton("OK") { dialog, which ->

        }
        userDialog = builder.create()
        userDialog!!.show()
    }

     fun showWaitDialog(message: String) {
        closeWaitDialog()
        waitDialog = ProgressDialog(activity)
        waitDialog?.setTitle(message)
        waitDialog?.show()
    }

     fun closeWaitDialog() {
        try {
            waitDialog?.dismiss()
        } catch (e: Exception) {
            //
        }

    }

}
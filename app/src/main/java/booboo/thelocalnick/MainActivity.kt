package booboo.thelocalnick

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import booboo.thelocalnick.AmazonCognito.AmazonCognitoHelper
import booboo.thelocalnick.gettingstarted.OnBoarding
import booboo.thelocalnick.tourListing.HomeScreenActivity





class MainActivity : AppCompatActivity() {

    val callbackManager = com.facebook.CallbackManager.Factory.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AmazonCognitoHelper.init(this)
        val fm = fragmentManager
        val ft = fm.beginTransaction()
        if(!getPreferences(Context.MODE_PRIVATE).contains(getString(R.string.app_opened_first_time))) {
            ft.add(R.id.output, OnBoarding())
            val sharedPref = getPreferences(Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putBoolean(getString(R.string.app_opened_first_time), false)
            editor.commit()

        }
        else {
            //Change this to home fragment
            val i = Intent(this, HomeScreenActivity::class.java)
            i.flags = i.flags or Intent.FLAG_ACTIVITY_NO_HISTORY
            startActivity(i)
        }
        ft.commit()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }
}

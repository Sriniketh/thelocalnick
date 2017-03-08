package booboo.thelocalnick

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import booboo.thelocalnick.AmazonCognito.AmazonCognitoHelper
import booboo.thelocalnick.gettingstarted.OnBoarding

class MainActivity : AppCompatActivity() {

    val callbackManager = com.facebook.CallbackManager.Factory.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AmazonCognitoHelper.init(this)
        val fm = fragmentManager
        val ft = fm.beginTransaction()
        if(!getSharedPreferences(getString(R.string.preference_file), 0).contains(getString(R.string.app_opened_first_time))) {
            ft.add(R.id.output, OnBoarding())
        }
        else {
            val settings = getSharedPreferences(getString(R.string.preference_file), 0)
            val editor = settings.edit()
            editor.putBoolean(getString(R.string.app_opened_first_time), false)
            //Change this to home fragment
            ft.add(R.id.output, OnBoarding())
        }
        ft.commit()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }
}

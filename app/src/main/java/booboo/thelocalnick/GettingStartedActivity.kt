package booboo.thelocalnick

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager

import booboo.thelocalnick.gettingstarted.ScrollImageFragment

class GettingStartedActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_fragment)
        val scrollImageFragment = ScrollImageFragment()
//        fragmentManager.beginTransaction()
//                .add(R.id.image_scroll_fragment, scrollImageFragment).commit()
    }
}

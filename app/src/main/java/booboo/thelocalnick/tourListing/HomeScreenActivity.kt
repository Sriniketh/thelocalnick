package booboo.thelocalnick.tourListing

import android.app.Fragment
import android.app.FragmentTransaction
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import booboo.thelocalnick.R
import booboo.thelocalnick.tourListing.DateFragment
import booboo.thelocalnick.tourListing.GuestFragment
import booboo.thelocalnick.tourListing.LocationFragment
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.view.View
import android.databinding.adapters.TextViewBindingAdapter.setText





class HomeScreenActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tourlistingdrawer)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)


        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val location = findViewById(R.id.location) as TextView
        val guest = findViewById(R.id.guests)
        val date = findViewById(R.id.date)

        location.setOnClickListener{
            val ft = fragmentManager.beginTransaction()
            val prev = fragmentManager.findFragmentByTag("dialog")
            if (prev != null) {
                ft.remove(prev)
            }
            ft.addToBackStack(null)

            // Create and show the dialog.
            val newFragment = LocationFragment()
            newFragment.show(ft, "dialog")
        }

        guest.setOnClickListener{
            val ft = fragmentManager.beginTransaction()
            val prev = fragmentManager.findFragmentByTag("dialog")
            if (prev != null) {
                ft.remove(prev)
            }
            ft.addToBackStack(null)

            // Create and show the dialog.
            val newFragment = GuestFragment()
            newFragment.show(ft, "dialog")
        }

        date.setOnClickListener{
            val ft = fragmentManager.beginTransaction()
            val prev = fragmentManager.findFragmentByTag("dialog")
            if (prev != null) {
                ft.remove(prev)
            }
            ft.addToBackStack(null)

            // Create and show the dialog.
            val newFragment = DateFragment()
            newFragment.show(ft, "dialog")
        }

        val toggle = android.support.v7.app.ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        selectItem(0);

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.more_popup, menu)
        return true
    }

    private fun selectItem(position: Int) {

        val fragment = TourListingContent.newInstance(position)

        val fragmentManager = fragmentManager
        val ft = fragmentManager.beginTransaction()
        ft.replace(R.id.content_frame, TourListingContent())
        ft.commit()

    }




}

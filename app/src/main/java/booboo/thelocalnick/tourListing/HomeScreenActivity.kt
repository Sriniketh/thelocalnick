package booboo.thelocalnick.tourListing

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.LocationManager
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import booboo.thelocalnick.R
import java.io.IOException
import java.util.*






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

        //setLocationName()

//        findViewById(R.id.search_action).setOnClickListener { view ->
//            val ft = fragmentManager.beginTransaction()
//            val newFragment = SigninDialog()
//            newFragment.show(ft, "dialog")

//        }


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

    fun checkPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    fun setLocationName() {

        var cityName = "Not Found"
//        if (checkPermission()) {
//            ActivityCompat.requestPermissions(
//                    this,
//                    arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),
//                    PERMISSION_LOCATION_REQUEST_CODE)
//        }
        val locationManager=getSystemService(LOCATION_SERVICE) as LocationManager
        val location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        val gcd = Geocoder(baseContext, Locale.getDefault())
        val lattitude = location.latitude
        val longitude = location.longitude
        try {

            val addresses = gcd.getFromLocation(lattitude, longitude,
                    10)

            for (adrs in addresses) {
                if (adrs != null) {

                    val city = adrs.locality
                    if (city != null && city != "") {
                        cityName = city
                        println("city ::  " + cityName)
                    } else {

                    }
                    // // you should also try with addresses.get(0).toSring();

                }

            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val textLocation = findViewById(R.id.location) as TextView
        textLocation.text = cityName


    }


}

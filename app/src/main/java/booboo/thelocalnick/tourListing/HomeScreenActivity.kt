package booboo.thelocalnick.tourListing

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import booboo.thelocalnick.CreateTour.CreateTourStepper
import booboo.thelocalnick.R
import java.io.IOException
import java.util.*
import android.support.v4.content.ContextCompat
import android.support.annotation.NonNull

//import android.location.LocationManager;
var locationManager: LocationManager? = null

private val REQUEST_PERMISSION_LOCATION = 255

//class HomeScreenActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
//
//<<<<<<< HEAD
class HomeScreenActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
//=======

//    override fun onLocationChanged(location: Location?) {
//
//        locationManager?.removeUpdates(this);
//        var cityName = "Not Found"
//        val lattitude = location?.latitude
//        val longitude = location?.longitude
//        try {
//            Log.v("city ::  ", "lalala3")
//            val gcd = Geocoder(baseContext, Locale.getDefault())
//            val addresses = gcd.getFromLocation(lattitude!!, longitude!!,
//                    10)
//
//            for (adrs in addresses) {
//                if (adrs != null) {
//
//                    val city = adrs.locality
//                    if (city != null && city != "") {
//                        cityName = city
//                        Log.v("city ::  ", cityName)
//                        //                        return cityName.toString();
//                        //                        val textLocation = findViewById(R.id.location) as TextView
//                        //                        textLocation.text = cityName
//                    } else {
//
//                    }
//                    // // you should also try with addresses.get(0).toSring();
//
//                }
//
//            }
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//
//    }
//>>>>>>> fixed the geolocation problem

    var tourListingContent : TourListingContent?=null

    var drawer:DrawerLayout? = null
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_create -> {
                var intent: Intent = Intent(this, CreateTourStepper::class.java)
                startActivity(intent)
            }
        }

        when (item.itemId) {
            R.id.nav_account -> {
                selectItem(3)
            }

        }

        return true
    }


    //<<<<<<< HEAD
    //throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
//<<<<<<< HEAD
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_tourlistingdrawer)
    val toolbar = findViewById(R.id.toolbar) as Toolbar
    setSupportActionBar(toolbar)
   

    drawer = findViewById(R.id.drawer_layout) as DrawerLayout
    val location = findViewById(R.id.location) as TextView
    val guest = findViewById(R.id.guests)
    val date = findViewById(R.id.date)
//=======
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_tourlistingdrawer)
//        val toolbar = findViewById(R.id.toolbar) as Toolbar
//        setSupportActionBar(toolbar)


//    val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
//    val location = findViewById(R.id.location) as TextView
//    val guest = findViewById(R.id.guests)
//    val date = findViewById(R.id.date)
//=======
//        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
//        val location = findViewById(R.id.location) as TextView
//        val guest = findViewById(R.id.guests)
//        val date = findViewById(R.id.date)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), REQUEST_PERMISSION_LOCATION)
        } else {
            setLocationName()
        }

//        location.setOnClickListener{
//            val ft = fragmentManager.beginTransaction()
//            val prev = fragmentManager.findFragmentByTag("dialog")
//            if (prev != null) {
//                ft.remove(prev)
//            }
//            ft.addToBackStack(null)
//>>>>>>> fixed the geolocation problem

        location.setOnClickListener{
            val ft = fragmentManager.beginTransaction()
            val prev = fragmentManager.findFragmentByTag("dialog")
            if (prev != null) {
                ft.remove(prev)
            }
            ft.addToBackStack(null)
//>>>>>>> fixed the geolocation problem

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

//<<<<<<< HEAD
    val toggle = android.support.v7.app.ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
    drawer?.setDrawerListener(toggle)
    toggle.syncState()

//    val navigationView = findViewById(R.id.nav_view) as NavigationView
//    navigationView.setNavigationItemSelectedListener(this)
//    navigationView.setCheckedItem(0);
//    navigationView.getMenu().getItem(0).setChecked(true);
//    selectItem(0)
//
//
//=======
//        val toggle = android.support.v7.app.ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
//        drawer.setDrawerListener(toggle)
//        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.setCheckedItem(0);
        navigationView.getMenu().getItem(0).setChecked(true);
        selectItem(0);
//>>>>>>> fixed the geolocation problem

        //setLocationName()

//        findViewById(R.id.search_action).setOnClickListener { view ->
//            val ft = fragmentManager.beginTransaction()
//            val newFragment = SigninDialog()
//            newFragment.show(ft, "dialog")

//        }


//<<<<<<< HEAD
    }
//=======
//    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSION_LOCATION) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setLocationName()
            }
        }
    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//>>>>>>> fixed the geolocation problem

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
    }

//<<<<<<< HEAD
override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    if(item?.itemId==R.id.filter_action){

        FilterFragment(tourListingContent!!).show(fragmentManager,"dialog")
    }
    return super.onOptionsItemSelected(item)
}
override fun onCreateOptionsMenu(menu: Menu): Boolean {
    val inflater = menuInflater
    inflater.inflate(R.menu.more_popup, menu)
    return true
}
//=======
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.more_popup, menu)
//        return true
//    }
//>>>>>>> fixed the geolocation problem

    private fun selectItem(position: Int) {

//<<<<<<< HEAD
    val fragment = TourListingContent.newInstance(position)
    tourListingContent = fragment as TourListingContent
    val fragmentManager = fragmentManager
    val ft = fragmentManager.beginTransaction()
    if (position!=0)
        ft.replace(R.id.output, fragment)
    else
        ft.replace(R.id.content_frame,fragment)
    ft.addToBackStack(null)
    drawer?.closeDrawers()
    ft.commit()


}
//=======
//        val fragment = TourListingContent.newInstance(position)
//
//        val fragmentManager = fragmentManager
//        val ft = fragmentManager.beginTransaction()
//        ft.replace(R.id.content_frame, fragment)
//        ft.commit()
//
//    }
//>>>>>>> fixed the geolocation problem

    fun checkPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    //<<<<<<< HEAD
    fun setLocationName() {

        var cityName = "Not Found"
//=======

//        fun setLocationName() {
        Log.v("city ::  ", "lalala1")
//        var cityName = "Not Found"

//>>>>>>> fixed the geolocation problem
//        if (checkPermission()) {
//            ActivityCompat.requestPermissions(
//                    this,
//                    arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),
//                    PERMISSION_LOCATION_REQUEST_CODE)
//        }
//<<<<<<< HEAD
//    val locationManager=getSystemService(LOCATION_SERVICE) as LocationManager
//    val location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//    val gcd = Geocoder(baseContext, Locale.getDefault())
//    val lattitude = location.latitude
//    val longitude = location.longitude
//    try {
//
//        val addresses = gcd.getFromLocation(lattitude, longitude,
//                10)
//
//        for (adrs in addresses) {
//            if (adrs != null) {
//
//                val city = adrs.locality
//                if (city != null && city != "") {
//                    cityName = city
//                    println("city ::  " + cityName)
//                } else {
//=======
        Log.v("city ::  ", "lalala2")
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
//        List<String> providers = mLocationManager.getProviders(true);
        val location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        val gcd = Geocoder(baseContext, Locale.getDefault())
        Log.v("location before ::  ", "lalala2")
        if(location!=null) {
            Log.v("locationnotnull", "notnull")
            val lattitude = location.latitude
            val longitude = location.longitude
            try {
                Log.v("city ::  ", "lalala3")
                val addresses = gcd.getFromLocation(lattitude, longitude,
                        10)

                for (adrs in addresses) {
                    if (adrs != null) {

                        val city = adrs.locality
                        if (city != null && city != "") {
                            cityName = city
                            Log.v("city ::  ", cityName)
                            //                        return cityName.toString();
                            //                        val textLocation = findViewById(R.id.location) as TextView
                            //                        textLocation.text = cityName
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
        else {
            Log.v("locationnotnull", "isnull")
//            List<String> providers = locationManager.getProviders(true);
            val locationListener = object : LocationListener {
                override fun onLocationChanged(location: Location) {
                    Log.v("onlocchange ::  ", "inside")
                    // getting location of user
                    val lattitude = location.latitude
                    val longitude = location.longitude
                    try {
                        Log.v("city ::  ", "lalala3")
                        val addresses = gcd.getFromLocation(lattitude, longitude,
                                10)

                        for (adrs in addresses) {
                            if (adrs != null) {

                                val city = adrs.locality
                                if (city != null && city != "") {
                                    cityName = city
                                    Log.v("city ::  ", cityName)

                                } else {

                                }


                            }

                        }
                    } catch (e: IOException) {
                        Log.v("inside catch","inside catch")
                        e.printStackTrace()
                    }
                    val textLocation = findViewById(R.id.location) as TextView
                    textLocation.text = cityName
                    locationManager.removeUpdates(this)

                    //do something with Lat and Lng
                }

                override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
//>>>>>>> fixed the geolocation problem

                override fun onProviderEnabled(provider: String) {
                    //when user enables the GPS setting, this method is triggered.
                }
                // // you should also try with addresses.get(0).toSring();

                override fun onProviderDisabled(provider: String) {
                    //when no provider is available in this case GPS provider, trigger your gpsDialog here.
                }
            }

//<<<<<<< HEAD
//=======
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0F, locationListener);



//>>>>>>> fixed the geolocation problem
        }
//    } catch (e: IOException) {
//        e.printStackTrace()
//    }

//<<<<<<< HEAD
        val textLocation = findViewById(R.id.location) as TextView
        textLocation.text = cityName
//=======

//>>>>>>> fixed the geolocation problem


    }




}

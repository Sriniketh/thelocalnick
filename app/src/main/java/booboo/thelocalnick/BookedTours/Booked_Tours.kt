package booboo.thelocalnick.BookedTours

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import java.util.ArrayList

import booboo.thelocalnick.R
import booboo.thelocalnick.networkutils.HttpClient
import booboo.thelocalnick.services.BookingsSearch
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Booked_Tours :AppCompatActivity() {
    var bookedToursRecyclerView: RecyclerView? = null

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.booked_tours_recycler_view)
        bookedToursRecyclerView = findViewById(R.id.booked_tours_RecyclerView) as RecyclerView
        bookedToursRecyclerView?.setHasFixedSize(true)

        bookedToursRecyclerView?.layoutManager = LinearLayoutManager(this)

        val fragContext = this

        /*
        ArrayList tourList= new ArrayList();
        tourList.add(new tourData(R.drawable.lacma, "LA Art Museum Tour", "Nicholas", "glittering lights and dinosaurs. The Los Angeles County Museum of Art (LACMA) is an art museum located on Wilshire Boulevard in the Miracle Mile vicinity of Los Angeles. LACMA is on Museum Row, adjacent to the La Brea Tar Pits (George C. Page Museum).LACMA is the largest art museum in the western United States. It attracts nearly a million visitors annually.[3] It holds more than 150,000 works spanning the history of art from ancient times to the present. In addition to art exhibits, the museum features film and concert series","03/18/2017",1 ,80.45));
        tourList.add(new tourData(R.drawable.weird, "WeHo Weird Shops and Stops Tour", "Fahd", "weirdness personified","02/8/2017",2 ,161.98));
        tourList.add(new tourData(R.drawable.wall_art, "Los Angeles Wall Crawl Adventure", "Johnathan", "graffiti on the wall","01/30/2017",2 ,120));
        tourList.add(new tourData(R.drawable.food, "Santa Monica Foodie Tour", "Kimmy", "Food Food Food....","04/20/2017",3 ,120));
        tourList.add(new tourData(R.drawable.surfing, "Santa Monica Surfing", "Abigail", "Come join me for a fun day at the Santa Monica Beach.","05/15/2017",4 ,240));
*/
     val searchService = HttpClient().getClient("http://api.myjson.com").create(BookingsSearch::class.java)
        val searchResult = searchService.getBookings("6767613")

        searchResult.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { bookings ->
                    bookedToursRecyclerView?.adapter = bookedToursRecyclerAdapter(fragContext,bookings)

                }
        /*  ArrayList tourList= new ArrayList();
        for (int i=0;i<100;i++) {
            tourList.add(new tourData(R.drawable.lacma, "LA Art Museum Tour", "Nicholas", "glittering lights and dinosaurs. The Los Angeles County Museum of Art (LACMA) is an art museum located on Wilshire Boulevard in the Miracle Mile vicinity of Los Angeles. LACMA is on Museum Row, adjacent to the La Brea Tar Pits (George C. Page Museum).LACMA is the largest art museum in the western United States. It attracts nearly a million visitors annually.[3] It holds more than 150,000 works spanning the history of art from ancient times to the present. In addition to art exhibits, the museum features film and concert series","03/18/2017",1 ,80.45));
            tourList.add(new tourData(R.drawable.weird, "WeHo Weird Shops and Stops Tour", "Fahd", "weirdness personified","02/8/2017",2 ,161.98));
            tourList.add(new tourData(R.drawable.wall_art, "Los Angeles Wall Crawl Adventure", "Johnathan", "graffiti on the wall","01/30/2017",2 ,120));
            tourList.add(new tourData(R.drawable.food, "Santa Monica Foodie Tour", "Kimmy", "Food Food Food....","04/20/2017",3 ,120));
            tourList.add(new tourData(R.drawable.surfing, "Santa Monica Surfing", "Abigail", "Come join me for a fun day at the Santa Monica Beach.","05/15/2017",4 ,240));
          }*/



        // return rootView;

    }
}


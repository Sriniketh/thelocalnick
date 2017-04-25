package booboo.thelocalnick.tourListing

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import booboo.thelocalnick.R
import booboo.thelocalnick.models.Tours
import booboo.thelocalnick.networkutils.HttpClient
import booboo.thelocalnick.services.SearchService
import booboo.thelocalnick.user.UserAccountScreen
import booboo.thelocalnick.utils.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class TourListingContent : BaseFragment() {
    var filterTour:Tours? = null
    private var gaggeredGridLayoutManager: GridLayoutManager? = null
    var recyclerView:RecyclerView ?= null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val rootView = inflater.inflate(R.layout.fragment_drawer, container, false)
        val i = 0
        recyclerView = rootView.findViewById(R.id.recycler_view) as RecyclerView
        val lLayout = rootView.findViewById(R.id.tourlistgrid) as LinearLayout
        lLayout.setBackgroundColor(Color.parseColor("#ffffff"))
        val fragContext = activity


        val searchService = HttpClient().getClient("http://api.myjson.com").create(SearchService::class.java)
        val searchResult = searchService.getTours("Los Angeles")

        searchResult.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { tours ->
                    Log.e("Current search", tours.toString())
                    val tileGenerator = GenerateTourTile(fragContext,tours.tours)
                    filterTour = tours

                    val recyclerView = rootView.findViewById(R.id.recycler_view) as RecyclerView
                    recyclerView.setHasFixedSize(true)
                    gaggeredGridLayoutManager = GridLayoutManager(fragContext, 2)

                    recyclerView.layoutManager = gaggeredGridLayoutManager
                    recyclerView.recycledViewPool.setMaxRecycledViews(R.id.recycler_view, 0)
                    recyclerView.adapter = tileGenerator

                }



        return rootView


    }


//    private //tileData(String author, String desc, double rate, double price, int ratingCount, int imageRes)
//            /*listViewItems.add(new tileData("Trip 1","This is so cool!",66,5.62144,23, R.drawable.gettingstarted1));
//        listViewItems.add(new tileData("Trip 2","This is so best!",2,642.2,258, R.drawable.gettingstarted2));
//        listViewItems.add(new tileData("Trip 3","This is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing",6,642.2,258, R.drawable.gettingstarted3));
//        listViewItems.add(new tileData("Trip 4","This is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing",9,642.2,258, R.drawable.gs1));
//        listViewItems.add(new tileData("Trip 5","This is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing",6,342,258, R.drawable.gs2));
//        listViewItems.add(new tileData("Trip 6","This is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing",9,54,258, R.drawable.gs3));*/ val listItemData: List<tileData>
//        get() {
//            val listViewItems = ArrayList<tileData>()
//            for (i in 0..99) {
//                listViewItems.add(tileData("Trip 1", "This is so cool!", 66.0, 5.62144, 23, R.drawable.gettingstarted1))
//                listViewItems.add(tileData("Trip 2", "This is the best thing ever!", 2.0, 642.2, 258, R.drawable.gettingstarted2))
//                listViewItems.add(tileData("Trip 3", "This is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing", 6.0, 642.2, 258, R.drawable.gs2))
//                listViewItems.add(tileData("Trip 4", "This is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing", 9.0, 642.2, 258, R.drawable.gs3))
//                listViewItems.add(tileData("Trip 6", "This is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing", 9.0, 54.0, 258, R.drawable.gettingstarted2))
//            }
//            return listViewItems
//        }

    companion object {
        val DRAWER_ITEM = "4"

        fun newInstance(position: Int): BaseFragment {
            val fragment = TourListingContent()
            val args = Bundle()
            args.putInt(TourListingContent.DRAWER_ITEM, position)
            fragment.arguments = args
            if (position == 3){
                return UserAccountScreen()
            }
            return fragment
        }
    }
}
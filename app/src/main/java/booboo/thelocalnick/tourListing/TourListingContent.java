package booboo.thelocalnick.tourListing;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import booboo.thelocalnick.R;


public class TourListingContent extends Fragment {

    private GridLayoutManager gaggeredGridLayoutManager;
    public static final String DRAWER_ITEM = "";

    public static Fragment newInstance(int position) {
        Fragment fragment = new TourListingContent();
        Bundle args = new Bundle();
        args.putInt(TourListingContent.DRAWER_ITEM, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drawer, container, false);
        int i = getArguments().getInt(DRAWER_ITEM);
        String drawEntry = getResources().getStringArray(R.array.drawerEntries)[i];

        LinearLayout lLayout = (LinearLayout) rootView.findViewById(R.id.tourlistgrid);
        lLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        Context fragContext = container.getContext();
        getActivity().setTitle(drawEntry);


        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        gaggeredGridLayoutManager = new GridLayoutManager(fragContext, 2);

        recyclerView.setLayoutManager(gaggeredGridLayoutManager);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(R.id.recycler_view, 0);
        List<tileData> tourTileList = getListItemData();

        GenerateTourTile tileGenerator = new GenerateTourTile(fragContext, tourTileList);
        recyclerView.setAdapter(tileGenerator);

        return rootView;
    }


    private List<tileData> getListItemData() {
        List<tileData> listViewItems = new ArrayList<tileData>();
        //tileData(String author, String desc, double rate, double price, int ratingCount, int imageRes)
        for (int i = 0; i < 100; i++) {
            listViewItems.add(new tileData("Trip 1", "This is so cool!", 66, 5.62144, 23, R.drawable.gettingstarted1));
            listViewItems.add(new tileData("Trip 2", "This is the best thing ever!", 2, 642.2, 258, R.drawable.gettingstarted2));
            listViewItems.add(new tileData("Trip 3", "This is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing", 6, 642.2, 258, R.drawable.gs2));
            listViewItems.add(new tileData("Trip 4", "This is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing", 9, 642.2, 258, R.drawable.gs3));
            listViewItems.add(new tileData("Trip 6", "This is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing", 9, 54, 258, R.drawable.gettingstarted2));
        }

        /*listViewItems.add(new tileData("Trip 1","This is so cool!",66,5.62144,23, R.drawable.gettingstarted1));
        listViewItems.add(new tileData("Trip 2","This is so best!",2,642.2,258, R.drawable.gettingstarted2));
        listViewItems.add(new tileData("Trip 3","This is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing",6,642.2,258, R.drawable.gettingstarted3));
        listViewItems.add(new tileData("Trip 4","This is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing",9,642.2,258, R.drawable.gs1));
        listViewItems.add(new tileData("Trip 5","This is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing",6,342,258, R.drawable.gs2));
        listViewItems.add(new tileData("Trip 6","This is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing! This is Amazing This is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is AmazingThis is Amazing",9,54,258, R.drawable.gs3));*/
        return listViewItems;
    }
}
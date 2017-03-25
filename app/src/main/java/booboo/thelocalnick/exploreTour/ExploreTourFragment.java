package booboo.thelocalnick.exploreTour;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import booboo.thelocalnick.R;

/**
 * Created by ishankothari on 2/16/17.
 */

public class ExploreTourFragment extends AppCompatActivity {
    //TODO convert to fragment once the other team finishes the home page and this fragment can be linked to

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_explore_tour);


    }

    /*@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_explore_tour, container, false);

        return rootView;
    }*/
}

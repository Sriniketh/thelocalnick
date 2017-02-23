package booboo.thelocalnick.exploreTour;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import booboo.thelocalnick.R;

/**
 * Created by ishankothari on 2/16/17.
 */

public class ExploreTourFragement extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_explore_tour, container, false);

        return rootView;
    }
}

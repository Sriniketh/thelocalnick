package booboo.thelocalnick.tourListing;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import booboo.thelocalnick.R;

/**
 * Created by ishankothari on 4/13/17.
 */

public class PaymentSuccessFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_payment_success, container, false);
        return rootView;
    }
}

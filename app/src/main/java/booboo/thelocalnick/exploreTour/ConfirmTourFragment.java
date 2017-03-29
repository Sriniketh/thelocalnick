package booboo.thelocalnick.exploreTour;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import booboo.thelocalnick.R;

public class ConfirmTourFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreateView(inflater, parent, savedInstanceState);
        View rootView = inflater.inflate(R.layout.activity_confirm_tour, parent, false);
        final Button bookBtn = (Button) rootView.findViewById(R.id.confirmBtn);
        final TextView passCount = (TextView) rootView.findViewById(R.id.tourpass);

        return rootView;
    }
}

package booboo.thelocalnick.createaccount;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import booboo.thelocalnick.R;

/**
 * Created by ishankothari on 2/9/17.
 */
public class CreateAccountFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreateView(inflater, parent, savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        View rootView = inflater.inflate(R.layout.fragment_create_account, parent, false);

        EditText etPassword = (EditText) rootView.findViewById(R.id.etPassword);
        etPassword.setTransformationMethod(new PasswordTransformationMethod());

        EditText etConfirmPassword = (EditText) rootView.findViewById(R.id.etConfirmPassword);
        etConfirmPassword.setTransformationMethod(new PasswordTransformationMethod());

        TextView tvTermsOfUse = (TextView) rootView.findViewById(R.id.tvTermsOfUse);
        tvTermsOfUse.setPaintFlags(tvTermsOfUse.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvTermsOfUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getActivity())
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                dialog.setTitle("Terms of Use");
                dialog.setMessage(getString(R.string.terms_of_use));
                dialog.show();
            }
        });
        return rootView;
    }
}
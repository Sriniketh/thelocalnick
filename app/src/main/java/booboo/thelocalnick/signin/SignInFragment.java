package booboo.thelocalnick.signin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import booboo.thelocalnick.R;
import booboo.thelocalnick.createaccount.CreateAccountFragment;

/**
 * Created by ishankothari on 2/9/17.
 */
public class SignInFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreateView(inflater, parent, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_sign_in, parent, false);

        EditText etPassword = (EditText) rootView.findViewById(R.id.etPassword);
        etPassword.setTransformationMethod(new PasswordTransformationMethod());

        TextView tvCreateAccount = (TextView) rootView.findViewById(R.id.tvCreateAccount);
        tvCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(((ViewGroup)getView().getParent()).getId(),
                                new CreateAccountFragment()).commit();
            }
        });
        return rootView;
    }
}
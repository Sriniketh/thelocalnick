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
                dialog.setMessage("Lorem ipsum dolor sit amet, dolorum minimum definitionem cum " +
                        "ei, cum ei postea detraxit ullamcorper. Justo homero everti ad eam, an" +
                        " vim nulla choro. Sea ne novum detraxit, idque nostrud utroque has id. " +
                        "Illum noster similique eos ad, ut tritani theophrastus interpretaris sed." +
                        " Dicant utroque euripidis ut mei, has ex bonorum lucilius disputando.\n" +
                        "\n" +
                        "Persius sapientem pro ne, no nec ludus adipisci vituperata. Cum ut exerci" +
                        " sadipscing. Has qualisque philosophia at. Pro nihil nemore adipiscing id," +
                        " at integre legendos vix. Eam ad eros alienum.\n" +
                        "\n" +
                        "Ut mel partem detraxit, eam no senserit argumentum. Tractatos mediocritatem" +
                        " ei mei, ea per ceteros rationibus. Et tation virtute assentior his, " +
                        "utroque suscipit salutatus cum et, pro et illud sonet inimicus. His homero" +
                        " conceptam in, vim id idque quando ullamcorper, iudico vocibus at cum." +
                        " Causae deleniti efficiendi at est.\n" +
                        "\n" +
                        "Iudico populo partiendo quo an. Nusquam detracto legendos vis ne, his id" +
                        " elit accumsan copiosae. Noster scaevola honestatis in pri, eum at graece" +
                        " prodesset. Numquam senserit volutpat no qui, sea porro oporteat conceptam" +
                        " ei. Ad mea veri volumus phaedrum, eius civibus voluptaria et mel. Eu nec" +
                        " putent alienum, cibo euripidis voluptatum no eos.\n" +
                        "\n" +
                        "Id vel nusquam delicatissimi, qui solet antiopam persecuti ut, doming" +
                        " commune voluptaria eum in. Vel ea primis persecuti. Ius erat eligendi ex." +
                        " An has commodo incorrupte.");

                dialog.show();
            }
        });
        return rootView;
    }
}
package booboo.thelocalnick.tourListing;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.stripe.android.view.CardInputWidget;

import booboo.thelocalnick.R;

/** 
 * Created by ishankothari on 4/12/17. 
 */
public class PaymentFragment extends Fragment implements View.OnClickListener{
    EditText etName;
    CardInputWidget cardInputWidget;
    EditText etZip;
    int amount;

    public PaymentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_payment, container, false);
        amount = getArguments().getInt("Amount");

        TextView tvAmount = (TextView) rootView.findViewById(R.id.tvAmount);
        tvAmount.setText("$" + amount);

        ((Button) rootView.findViewById(R.id.bMakePayment)).setOnClickListener(this);

        etName = (EditText) rootView.findViewById(R.id.etName);
        cardInputWidget = (CardInputWidget) rootView.findViewById(R.id.cardInputWidget);
        etZip = (EditText) rootView.findViewById(R.id.etZip);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        Card card = cardInputWidget.getCard();
        if (view.getId() == R.id.bMakePayment) {
            if (etName.getText().toString().length() == 0 ||
                    etZip.getText().toString().length() == 0 || card == null) {
                Toast.makeText(getActivity(),
                        "Please ensure all fields are filled", Toast.LENGTH_LONG).show();
                return;
            }
            if (card == null) {
                Toast.makeText(getActivity(),
                        "Please enter valid card details", Toast.LENGTH_LONG).show();
                return;
            }
            card.setName(etName.getText().toString());
            card.setAddressZip(etZip.getText().toString());

            //TODO change to live key in production
            Stripe stripe = new Stripe(getContext(), getString(R.string.stripe_test_publishable_key));
            stripe.createToken(
                    card,
                    new TokenCallback() {
                        @Override
                        public void onError(Exception error) {
                            Toast.makeText(getContext() , error.getLocalizedMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onSuccess(Token token) {
                            //Send token to backend with amount for charging customer
                        }
                    }
            );
        }
    }
}

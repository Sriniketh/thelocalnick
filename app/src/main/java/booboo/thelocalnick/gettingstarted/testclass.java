package booboo.thelocalnick.gettingstarted;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import booboo.thelocalnick.R;
import booboo.thelocalnick.databinding.ActivityGettingStartedBinding;

/**
 * Created by AshwinKumar on 2/8/17.
 */

public class testclass {
    public View.OnClickListener onCommentsClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Opens comments detail", Toast.LENGTH_SHORT).show();
            }
        };
    }
    //ActivityGettingStartedBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_getting_started);

}

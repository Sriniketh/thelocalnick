package booboo.thelocalnick.tourListing

import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.TextView
import booboo.thelocalnick.R


/**
 * Created by sidhesh on 3/25/17.
 */

class GuestFragment : DialogFragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mainview = inflater.inflate(R.layout.guest_picker_layout, container, false)

        return mainview
    }
    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            dialog.window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            //dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val number = view.findViewById(R.id.numberPicker) as NumberPicker
        number.maxValue=5
        number.minValue=1
        val numberKids = view.findViewById(R.id.numberPicker1) as NumberPicker
        numberKids.maxValue=5
        numberKids.minValue=1
        val saveButton = view.findViewById(R.id.guest_save)
        saveButton.setOnClickListener{
            val guest = activity.findViewById(R.id.guests) as TextView
            if(number.value == 1)
                guest.setText("1 Guest")
            else
                guest.setText((number.value).toString()+" Guests")
            dismiss()
        }

    }
}
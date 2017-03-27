package booboo.thelocalnick.tourListing

import android.app.DialogFragment
import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import booboo.thelocalnick.R
import android.graphics.drawable.ColorDrawable
import android.widget.DatePicker
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by sidhesh on 3/25/17.
 */

class DateFragment : DialogFragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mainview = inflater.inflate(R.layout.date_picker_layout, container, false)

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
        val saveButton = view.findViewById(R.id.save3)



        saveButton.setOnClickListener{
            val date = view.findViewById(R.id.datePicker) as DatePicker

            val dateText = activity.findViewById(R.id.date) as TextView

            dismiss()
        }
    }
}

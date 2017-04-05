package booboo.thelocalnick.tourListing

import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import booboo.thelocalnick.R


/**
 * Created by sidhesh on 3/25/17.
 */

class LocationFragment : DialogFragment(){

    val textView:TextView? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mainview = inflater.inflate(R.layout.location_fragment, container,false)

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
        val saveButton = view.findViewById(R.id.save1)
        val COUNTRIES = arrayOf("San Diego", "Los Angeles", "San Francisco", "Seattle", "San Jose")
        val adapter = ArrayAdapter<String>(activity, android.R.layout.simple_dropdown_item_1line, COUNTRIES)
        val textView = view.findViewById(R.id.autoCompleteTextView) as AutoCompleteTextView
        textView.setAdapter<ArrayAdapter<String>>(adapter)

        saveButton.setOnClickListener{
            dismiss()
        }

        textView.setOnItemClickListener { parent, view, position, id ->
            val location = activity.findViewById(R.id.location) as TextView
            location.text = parent.getItemAtPosition(position) as String
        }


    }
}
package booboo.thelocalnick.CreateTour

import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import booboo.thelocalnick.R
import booboo.thelocalnick.data.Schedule

class ScheduleFragment(tourScheduleFragment: TourScheduleFragment) : DialogFragment(), CompoundButton.OnCheckedChangeListener {

    var tourScheduleFragment: TourScheduleFragment? = null
    var days: ArrayList<String> = java.util.ArrayList()

    init {
        this.tourScheduleFragment = tourScheduleFragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootview = inflater.inflate(R.layout.schedule_fragment, container, false)
        return rootview
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            dialog.window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val from_hrs = view?.findViewById(R.id.numberpicker_from_hrs) as NumberPicker
        from_hrs.minValue = 0
        from_hrs.maxValue = 23
        val from_mins = view.findViewById(R.id.numberpicker_from_mins) as NumberPicker
        from_mins.minValue = 0
        from_mins.maxValue = 59
        val to_hrs = view.findViewById(R.id.numberpicker_to_hrs) as NumberPicker
        to_hrs.minValue = 0
        to_hrs.maxValue = 23
        val to_mins = view.findViewById(R.id.numberpicker_to_mins) as NumberPicker
        to_mins.minValue = 0
        to_mins.maxValue = 59

        val mon = view.findViewById(R.id.checkbox_mon) as CheckBox
        mon.setOnCheckedChangeListener(this)
        val tue = view.findViewById(R.id.checkbox_tue) as CheckBox
        tue.setOnCheckedChangeListener(this)
        val wed = view.findViewById(R.id.checkbox_wed) as CheckBox
        wed.setOnCheckedChangeListener(this)
        val thu = view.findViewById(R.id.checkbox_thu) as CheckBox
        thu.setOnCheckedChangeListener(this)
        val fri = view.findViewById(R.id.checkbox_fri) as CheckBox
        fri.setOnCheckedChangeListener(this)
        val sat = view.findViewById(R.id.checkbox_sat) as CheckBox
        sat.setOnCheckedChangeListener(this)
        val sun = view.findViewById(R.id.checkbox_sun) as CheckBox
        sun.setOnCheckedChangeListener(this)

        val addButton: Button = view.findViewById(R.id.schedule_fragment_add_button) as Button
        addButton.setOnClickListener {
            val schedule: Schedule = Schedule(days, from_hrs.value, from_mins.value, to_hrs.value, to_mins.value)
            tourScheduleFragment?.addToRecyclerView(schedule)
            dismiss()
        }
        val cancelButton: Button = view.findViewById(R.id.schedule_fragment_cancel_button) as Button
        cancelButton.setOnClickListener {
            dismiss()
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        if (isChecked) {
            days.add(buttonView?.text.toString())
        } else {
            days.remove(buttonView?.text.toString())
        }
    }
}
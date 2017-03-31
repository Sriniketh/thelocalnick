package booboo.thelocalnick.CreateTour

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.NumberPicker
import booboo.thelocalnick.R
import booboo.thelocalnick.data.Schedule
import booboo.thelocalnick.databinding.FragmentCreateTourScheduleTimeBinding
import com.github.fcannizzaro.materialstepper.AbstractStep
import java.util.*

class TourScheduleFragment(createTourViewModel: CreateTourViewModel) : AbstractStep() {
    var binding: FragmentCreateTourScheduleTimeBinding? = null
    var createTourViewModel: CreateTourViewModel? = null
    val list: ArrayList<Schedule> = ArrayList()
    var recyclerView: RecyclerView? = null
    private var recyclerAdapter: ScheduleRecyclerViewAdapter? = null

    init {
        this.createTourViewModel = createTourViewModel
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentCreateTourScheduleTimeBinding.inflate(inflater, container, false)
        createTourViewModel?.tourScheduleFragment = this

        recyclerAdapter = ScheduleRecyclerViewAdapter(list)
        recyclerView = binding?.scheduleListView
        recyclerView?.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = recyclerAdapter

        binding?.ctvm = createTourViewModel
        return binding?.root
    }

    fun showAddTimeDialog() {
        val ft = activity.fragmentManager.beginTransaction()
        val prev = activity.fragmentManager.findFragmentByTag("dialog")
        if (prev != null) {
            ft.remove(prev)
        }
        ft.addToBackStack(null)

        // Create and show the dialog.
        val newFragment = ScheduleFragment(this)
        newFragment.show(ft, "dialog")
        /*var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(this.activity)
        val from_hrs = activity.findViewById(R.id.numberpicker_from_hrs) as NumberPicker
        val from_min = activity.findViewById(R.id.numberpicker_from_mins) as NumberPicker
        val to_hrs = activity.findViewById(R.id.numberpicker_to_hrs) as NumberPicker
        val to_mins = activity.findViewById(R.id.numberpicker_to_mins) as NumberPicker
        from_hrs.minValue = 0
        from_hrs.maxValue = 23
        from_min.minValue = 0
        from_min.maxValue = 59
        to_hrs.minValue = 0
        to_hrs.maxValue = 23
        to_mins.minValue = 0
        to_mins.maxValue = 59
        builder.setView(R.layout.schedule_fragment).setPositiveButton("ADD",
                { dialogInterface, i ->
                    val dialog2 = dialogInterface as Dialog
                    val mon = dialog2.findViewById(R.id.checkbox_mon) as CheckBox
                    val tue = dialog2.findViewById(R.id.checkbox_tue) as CheckBox
                    val wed = dialog2.findViewById(R.id.checkbox_wed) as CheckBox
                    val thu = dialog2.findViewById(R.id.checkbox_thu) as CheckBox
                    val fri = dialog2.findViewById(R.id.checkbox_fri) as CheckBox
                    val sat = dialog2.findViewById(R.id.checkbox_sat) as CheckBox
                    val sun = dialog2.findViewById(R.id.checkbox_sun) as CheckBox
                    val from_hrs = dialog2.findViewById(R.id.numberpicker_from_hrs) as NumberPicker
                    val from_min = dialog2.findViewById(R.id.numberpicker_from_mins) as NumberPicker
                    val to_hrs = dialog2.findViewById(R.id.numberpicker_to_hrs) as NumberPicker
                    val to_mins = dialog2.findViewById(R.id.numberpicker_to_mins) as NumberPicker
                    val days: ArrayList<String> = ArrayList()
                    if (mon.isChecked) {
                        days.add("Monday")
                    }
                    if (tue.isChecked) {
                        days.add("Tuesday")
                    }
                    if (wed.isChecked) {
                        days.add("Wednesday")
                    }
                    if (thu.isChecked) {
                        days.add("Thursday")
                    }
                    if (fri.isChecked) {
                        days.add("Friday")
                    }
                    if (sat.isChecked) {
                        days.add("Saturday")
                    }
                    if (sun.isChecked) {
                        days.add("Sunday")
                    }
                    val schedule: Schedule = Schedule(days, from_hrs.value, from_min.value, to_hrs.value, to_mins.value)
                    list.add(schedule)
                    recyclerAdapter?.notifyDataSetChanged()
                })
        dialog = builder.create()
        dialog.show()*/
    }

    fun addToRecyclerView(schedule: Schedule) {
        list.add(schedule)
        recyclerAdapter?.notifyDataSetChanged()
    }

    override fun name(): String {
        return "Tab " + getArguments().getInt("position", 0)
    }
}

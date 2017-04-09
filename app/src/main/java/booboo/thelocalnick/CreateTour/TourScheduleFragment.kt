package booboo.thelocalnick.CreateTour

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import booboo.thelocalnick.data.Schedule
import booboo.thelocalnick.data.Tour
import booboo.thelocalnick.databinding.FragmentCreateTourScheduleTimeBinding
import com.github.fcannizzaro.materialstepper.AbstractStep
import java.util.ArrayList

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

        val newFragment = ScheduleFragment(this)
        newFragment.show(ft, "dialog")
    }

    fun addToRecyclerView(schedule: Schedule) {
        this.list.add(schedule)
        recyclerAdapter?.notifyDataSetChanged()
    }

    override fun name(): String {
        return "Tab " + getArguments().getInt("position", 0)
    }

    override fun onNext() {
        createTourViewModel?.schedule = list
        createTourViewModel?.tour = Tour(createTourViewModel?.spots,
                createTourViewModel?.time,
                createTourViewModel?.cost,
                createTourViewModel?.photos,
                createTourViewModel?.schedule)
        (createTourViewModel?.tour)?.printEverything()
        super.onNext()
    }
}

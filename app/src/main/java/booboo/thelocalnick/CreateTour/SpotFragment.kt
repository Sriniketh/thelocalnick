package booboo.thelocalnick.CreateTour

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import booboo.thelocalnick.R
import booboo.thelocalnick.data.Spot
import booboo.thelocalnick.databinding.FragmentCreateTourSpotDescriptionBinding
import com.github.fcannizzaro.materialstepper.AbstractStep
import java.util.ArrayList


class SpotFragment(createTourViewModel: CreateTourViewModel) : AbstractStep() {
    var binding: FragmentCreateTourSpotDescriptionBinding? = null
    val list: ArrayList<Spot> = ArrayList()
    var recyclerView: RecyclerView? = null
    private var recyclerAdapter: SpotRecyclerViewAdapter? = null
    var createTourViewModel: CreateTourViewModel? = null

    init {
        this.createTourViewModel = createTourViewModel
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentCreateTourSpotDescriptionBinding.inflate(inflater, container, false)
        createTourViewModel?.spotFragment = this

        recyclerAdapter = SpotRecyclerViewAdapter(list)
        recyclerView = binding?.spotListView
        recyclerView?.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = recyclerAdapter
        //ctvm.recyclerView = recyclerView

        binding?.ctvm = createTourViewModel
        return binding?.root
    }

    fun showAddSpotDialog() {
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(this.activity)
        builder.setView(R.layout.add_spot_alert_dialog).setPositiveButton("ADD",
                { dialogInterface, i ->
                    val dialog2 = dialogInterface as Dialog
                    val name = dialog2.findViewById(R.id.add_spot_name) as EditText
                    val address = dialog2.findViewById(R.id.add_spot_address) as EditText
                    val description = dialog2.findViewById(R.id.add_spot_description) as EditText
                    val spot: Spot = Spot(name.text.toString(), address.text.toString(), description.text.toString())
                    list.add(spot)
                    recyclerAdapter?.notifyDataSetChanged()
                })
        dialog = builder.create()
        dialog.show()
    }

    override fun name(): String {
        return "Tab " + getArguments().getInt("position", 0)
    }

    override fun onNext() {
        super.onNext()
    }

    override fun nextIf(): Boolean {
        return list.size > 0
    }

    override fun error(): String {
        return "Please add a spot"
    }
}

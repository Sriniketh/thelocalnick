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
import booboo.thelocalnick.utils.BaseFragment
import java.util.ArrayList


class SpotFragment : BaseFragment() {
    var binding: FragmentCreateTourSpotDescriptionBinding? = null
    val list: ArrayList<Spot> = ArrayList()
    var recyclerView: RecyclerView? = null
    private var recyclerAdapter: SpotRecyclerViewAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentCreateTourSpotDescriptionBinding.inflate(inflater, container, false)
        val ctvm = CreateTourViewModel()
        ctvm.spotFragment = this

        recyclerAdapter = SpotRecyclerViewAdapter(list)
        recyclerView = binding?.spotListView
        recyclerView?.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = recyclerAdapter
        ctvm.recyclerView = recyclerView

        binding?.ctvm = ctvm
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
}

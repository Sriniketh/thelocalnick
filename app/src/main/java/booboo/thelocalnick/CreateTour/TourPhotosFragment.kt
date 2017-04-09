package booboo.thelocalnick.CreateTour

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.content.ContextCompat.checkSelfPermission
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import booboo.thelocalnick.R
import booboo.thelocalnick.data.Photo
import booboo.thelocalnick.databinding.FragmentCreateTourPhotosBinding
import com.github.fcannizzaro.materialstepper.AbstractStep
import droidninja.filepicker.FilePickerBuilder
import droidninja.filepicker.FilePickerConst
import java.util.ArrayList


class TourPhotosFragment(createTourViewModel: CreateTourViewModel) : AbstractStep() {
    var binding: FragmentCreateTourPhotosBinding? = null
    val list: ArrayList<Photo> = ArrayList()
    var filePaths: ArrayList<String> = ArrayList()
    var recyclerView: RecyclerView? = null
    private var recyclerViewAdapter: PhotoRecyclerViewAdapter? = null
    var createTourViewModel: CreateTourViewModel? = null
    val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE: Int = 666

    init {
        this.createTourViewModel = createTourViewModel
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentCreateTourPhotosBinding.inflate(inflater, container, false)
        createTourViewModel?.tourPhotosFragment = this

        recyclerViewAdapter = PhotoRecyclerViewAdapter(this.activity, list)
        recyclerView = binding?.tourPhotosListView
        recyclerView?.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = recyclerViewAdapter

        binding?.ctvm = createTourViewModel
        return binding?.root
    }

    override fun name(): String {
        return "Tab " + getArguments().getInt("position", 0)
    }

    override fun onNext() {
        createTourViewModel?.photos = list
        super.onNext()
    }

    override fun nextIf(): Boolean {
        //TODO NEXT CONDITION FOR PHOTOS
        return super.nextIf()
    }

    fun onClickAddPhotos() {
        if (checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) !== PackageManager.PERMISSION_GRANTED) {

            requestPermissions(arrayOf<String>(Manifest.permission.READ_EXTERNAL_STORAGE),
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)
        } else {
            FilePickerBuilder.getInstance().setMaxCount(5)
                    .setSelectedFiles(filePaths)
                    .setActivityTheme(R.style.AppTheme)
                    .pickPhoto(this);
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    FilePickerBuilder.getInstance().setMaxCount(5)
                            .setSelectedFiles(filePaths)
                            .setActivityTheme(R.style.AppTheme)
                            .pickPhoto(this);
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            FilePickerConst.REQUEST_CODE_PHOTO -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    filePaths = ArrayList()
                    filePaths.addAll(data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_MEDIA))

                    list.clear()
                    for (path in filePaths) {
                        val photo: Photo = Photo()
                        Log.d("TAG", "Path = " + path)
                        photo.thumbnail = path
                        list.add(photo)
                    }
                    recyclerViewAdapter?.notifyDataSetChanged()
                }
            }
        }
    }
}
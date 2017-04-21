package booboo.thelocalnick.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BookedTour {

    @SerializedName("tourId")
    @Expose
    var tourId: String? = null
    @SerializedName("tourTitle")
    @Expose
    var tourTitle: String? = null
    @SerializedName("tourImage")
    @Expose
    var tourImage: String? = null
    @SerializedName("guideName")
    @Expose
    var guideName: String? = null
    @SerializedName("price")
    @Expose
    var price: Int? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("guests")
    @Expose
    var guests: Int? = null
    @SerializedName("time")
    @Expose
    var time: String? = null

}

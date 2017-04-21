
package booboo.thelocalnick.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bookings {

    @SerializedName("bookedTours")
    @Expose
    private List<BookedTour> bookedTours = null;

    public List<BookedTour> getBookedTours() {
        return bookedTours;
    }

    public void setBookedTours(List<BookedTour> bookedTours) {
        this.bookedTours = bookedTours;
    }

}

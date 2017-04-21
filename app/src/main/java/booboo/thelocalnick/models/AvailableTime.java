package booboo.thelocalnick.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AvailableTime {

    @SerializedName("monday")
    @Expose
    private List<String> monday = null;
    @SerializedName("tuesday")
    @Expose
    private List<String> tuesday = null;
    @SerializedName("Wednesday")
    @Expose
    private List<String> wednesday = null;
    @SerializedName("thursday")
    @Expose
    private List<String> thursday = null;
    @SerializedName("friday")
    @Expose
    private List<String> friday = null;
    @SerializedName("saturday")
    @Expose
    private List<String> saturday = null;
    @SerializedName("sunday")
    @Expose
    private List<String> sunday = null;

    public List<String> getMonday() {
        return monday;
    }

    public void setMonday(List<String> monday) {
        this.monday = monday;
    }

    public List<String> getTuesday() {
        return tuesday;
    }

    public void setTuesday(List<String> tuesday) {
        this.tuesday = tuesday;
    }

    public List<String> getWednesday() {
        return wednesday;
    }

    public void setWednesday(List<String> wednesday) {
        this.wednesday = wednesday;
    }

    public List<String> getThursday() {
        return thursday;
    }

    public void setThursday(List<String> thursday) {
        this.thursday = thursday;
    }

    public List<String> getFriday() {
        return friday;
    }

    public void setFriday(List<String> friday) {
        this.friday = friday;
    }

    public List<String> getSaturday() {
        return saturday;
    }

    public void setSaturday(List<String> saturday) {
        this.saturday = saturday;
    }

    public List<String> getSunday() {
        return sunday;
    }

    public void setSunday(List<String> sunday) {
        this.sunday = sunday;
    }

}


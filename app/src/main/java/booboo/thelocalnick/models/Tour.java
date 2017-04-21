package booboo.thelocalnick.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tour {

    @SerializedName("activityId")
    @Expose
    private List<String> activityId = null;
    @SerializedName("availableTime")
    @Expose
    private AvailableTime availableTime;
    @SerializedName("averageRating")
    @Expose
    private Float averageRating;
    @SerializedName("dateNotAvailable")
    @Expose
    private List<String> dateNotAvailable = null;
    @SerializedName("reviewCount")
    @Expose
    private Integer reviewCount;
    @SerializedName("totalCost")
    @Expose
    private Integer totalCost;
    @SerializedName("tourApproved")
    @Expose
    private Boolean tourApproved;
    @SerializedName("tourDescription")
    @Expose
    private String tourDescription;
    @SerializedName("tourDuration")
    @Expose
    private Integer tourDuration;
    @SerializedName("tourId")
    @Expose
    private String tourId;
    @SerializedName("tourName")
    @Expose
    private String tourName;
    @SerializedName("tourTitle")
    @Expose
    private String tourTitle;
    @SerializedName("tourPhoto")
    @Expose
    private List<String> tourPhoto = null;
    @SerializedName("tourReports")
    @Expose
    private String tourReports;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("guideName")
    @Expose
    private String guideName;
    @SerializedName("guideImage")
    @Expose
    private String guideImage;


    public List<String> getActivityId() {
        return activityId;
    }

    public void setActivityId(List<String> activityId) {
        this.activityId = activityId;
    }

    public AvailableTime getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(AvailableTime availableTime) {
        this.availableTime = availableTime;
    }

    public Float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Float averageRating) {
        this.averageRating = averageRating;
    }

    public List<String> getDateNotAvailable() {
        return dateNotAvailable;
    }

    public void setDateNotAvailable(List<String> dateNotAvailable) {
        this.dateNotAvailable = dateNotAvailable;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public Boolean getTourApproved() {
        return tourApproved;
    }

    public void setTourApproved(Boolean tourApproved) {
        this.tourApproved = tourApproved;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    }

    public Integer getTourDuration() {
        return tourDuration;
    }

    public void setTourDuration(Integer tourDuration) {
        this.tourDuration = tourDuration;
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }
    public String getTourTitle() {
        return tourTitle;
    }

    public void setTourTitle(String tourTitle) {
        this.tourTitle = tourTitle;
    }
    public List<String> getTourPhoto() {
        return tourPhoto;
    }

    public void setTourPhoto(List<String> tourPhoto) {
        this.tourPhoto = tourPhoto;
    }

    public String getTourReports() {
        return tourReports;
    }

    public void setTourReports(String tourReports) {
        this.tourReports = tourReports;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getGuideImage() {
        return guideImage;
    }

    public void setGuideImage(String guideImage) {
        this.guideImage = guideImage;
    }

}

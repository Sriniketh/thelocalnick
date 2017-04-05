package booboo.thelocalnick.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tour {

    @SerializedName("tourId")
    @Expose
    private String tourId;
    @SerializedName("tourTitle")
    @Expose
    private String tourTitle;
    @SerializedName("tourImage")
    @Expose
    private String tourImage;
    @SerializedName("guideName")
    @Expose
    private String guideName;
    @SerializedName("guideImage")
    @Expose
    private String guideImage;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("reviews")
    @Expose
    private Integer reviews;
    @SerializedName("isFavorite")
    @Expose
    private Boolean isFavorite;
    @SerializedName("durationHours")
    @Expose
    private Integer durationHours;
    @SerializedName("durationMins")
    @Expose
    private Integer durationMins;
    @SerializedName("nextAvailability")
    @Expose
    private String nextAvailability;

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public String getTourTitle() {
        return tourTitle;
    }

    public void setTourTitle(String tourTitle) {
        this.tourTitle = tourTitle;
    }

    public String getTourImage() {
        return tourImage;
    }

    public void setTourImage(String tourImage) {
        this.tourImage = tourImage;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Integer getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(Integer durationHours) {
        this.durationHours = durationHours;
    }

    public Integer getDurationMins() {
        return durationMins;
    }

    public void setDurationMins(Integer durationMins) {
        this.durationMins = durationMins;
    }

    public String getNextAvailability() {
        return nextAvailability;
    }

    public void setNextAvailability(String nextAvailability) {
        this.nextAvailability = nextAvailability;
    }

}

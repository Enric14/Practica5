package es.travelworld.practica5;

import com.google.gson.annotations.SerializedName;

public class HotelResult {

    @SerializedName("name")
    String name;

    @SerializedName("streetAddress")
    String streetAddress;

    @SerializedName("locality")
    String locality;

    @SerializedName("rating")
    String rating;

    @SerializedName("current")
    String current;

    @SerializedName("srpDesktop")
    String srpDesktop;

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getLocality() {
        return locality;
    }

    public String getRating() {
        return rating;
    }

    public String getCurrent() {
        return current;
    }

    public String getSrpDesktop() {
        return srpDesktop;
    }
}

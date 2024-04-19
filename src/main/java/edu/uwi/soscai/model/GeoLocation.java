package edu.uwi.soscai.model;

import java.io.IOException;

import org.json.JSONObject;

import edu.uwi.soscai.api.GeoLocator;

public class GeoLocation {
    private String name = "N/A";
    private double lat = 0.0;
    private double lon = 0.0;
    private String country = "N/A";
    private String state = "N/A";

    public GeoLocation(String name, double lat, double lon, String country, String state) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.country = country;
        this.state = state;
    }

    public void load(JSONObject js) {
        name = js.getString("name");
        JSONObject localNames = js.getJSONObject("local_names");
        String lang = localNames.keys().next();
        name = localNames.getString(lang);
        lat = js.getDouble("lat");
        lon = js.getDouble("lon");
        country = js.getString("country");
        if (js.has("state"))
            state = js.getString("state");
    }

    public String getName() {
        return name;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public static final GeoLocation getLocationViaName(String name) throws IOException {
        JSONObject response = GeoLocator.getFirstResult(name);
        if (response != null) {
            return new GeoLocation(
                    response.getString("name"),
                    response.getDouble("lat"),
                    response.getDouble("lon"),
                    response.getString("country"),
                    response.getString("state"));
        }
        return null;
    }
}

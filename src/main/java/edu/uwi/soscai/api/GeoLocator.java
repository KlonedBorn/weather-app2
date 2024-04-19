package edu.uwi.soscai.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import edu.uwi.soscai.App;
import edu.uwi.soscai.model.GeoLocation;

public class GeoLocator {

    public static GeoLocation getFirstResult(String name) throws IOException {
        return getLocationSearchResults(name, 1).get(0);
    }

    public static List<GeoLocation> getLocationSearchResults(String name, int limit) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("q", name);
        params.put("limit", String.valueOf(limit));
        String response = ApiRequest.request(GEOCODING_ENDPOINT, GeoLocator.API_KEY, params);
        List<GeoLocation> res = new ArrayList<>();
        JSONTokener tokener = new JSONTokener(response);
        JSONArray results = new JSONArray(tokener);
        if (results.length() == 0)
            return null;
        for (int i = 0; i < results.length(); i++) {
            JSONObject obj = results.getJSONObject(i);
            GeoLocation loc = new GeoLocation(obj.getString("name"), obj.getDouble("lat"), obj.getDouble("lon"),
                    obj.getString("country"), obj.getString("state"));
            res.add(loc);
        }
        return res;
    }

    private static final String API_KEY = App.API_KEY;
    private static final String GEOCODING_ENDPOINT = "http://api.openweathermap.org/geo/1.0/direct";
}
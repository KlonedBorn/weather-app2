package edu.uwi.soscai.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import edu.uwi.soscai.App;

public class GeoLocator {
    public static void main(String[] args) throws IOException {
        System.out.println(getFirstResult("St'John, Antigua"));
    }

    public static JSONObject getFirstResult(String name) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("q", name);
        params.put("limit", "1");
        return ApiRequest.request(GEOCODING_ENDPOINT, GeoLocator.API_KEY, params);
    }

    public static JSONObject getLocationSearchResults(String name, int limit) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("q", name);
        params.put("limit", String.valueOf(limit));
        return ApiRequest.request(GEOCODING_ENDPOINT, GeoLocator.API_KEY, params);
    }

    private static final String API_KEY = App.API_KEY;
    private static final String GEOCODING_ENDPOINT = "http://api.openweathermap.org/geo/1.0/direct";
}
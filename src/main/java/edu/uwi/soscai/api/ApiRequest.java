package edu.uwi.soscai.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;

public class ApiRequest {
    public static String request(String endpoint, String apiKey, Map<String, String> params) throws IOException {
        String query = params.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue().replaceAll(" ", "%20"))
                .collect(Collectors.joining("&"));
        String url = endpoint + "?" + query + "&appid=" + apiKey;
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        try (InputStream is = con.getInputStream()) {
            return IOUtils.toString(is, "UTF-8");
        }
    }

}

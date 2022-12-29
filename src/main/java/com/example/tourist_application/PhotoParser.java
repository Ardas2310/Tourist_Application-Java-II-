package com.example.tourist_application;
import java.net.*;
import java.io.*;

import org.json.*;

public class PhotoParser
{

    private static final String API_KEY = "AIzaSyDK4M6soWgedHy4r6Cf_mLd1lyn2WbRpB8";
    public  static  String[] photosArray = new String[10];
    public static void generatePhotos(String placeId) throws IOException, JSONException {


        String urlString = "https://maps.googleapis.com/maps/api/place/details/json?place_id=" + placeId + "&key=" + API_KEY;
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        if (status != 200) {
            throw new IOException("Request failed with status: " + status);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        JSONObject response = new JSONObject(content.toString());
        JSONObject result = response.getJSONObject("result");
        JSONArray photos = result.getJSONArray("photos");

        for (int i = 0; i < photos.length(); i++) {
            JSONObject photo = photos.getJSONObject(i);
            int height = photo.getInt("height");
            int width = photo.getInt("width");
            String photoReference = photo.getString("photo_reference");
            String imageUrl = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=" + width + "&photoreference=" + photoReference + "&key=" + API_KEY;
            // You can use the photoReference and the width and height to construct a URL to retrieve the photo from the Google Maps API
            photosArray[i] = imageUrl;
            System.out.println(imageUrl);
        }
    }
}
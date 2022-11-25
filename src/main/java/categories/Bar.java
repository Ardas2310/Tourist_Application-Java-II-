package categories;

import com.example.tourist_application.Api;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.lang.String.valueOf;

public class Bar
{
    public Bar()
    {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.088904%2C23.546338&radius=2000&type=bar&key=AIzaSyDK4M6soWgedHy4r6Cf_mLd1lyn2WbRpB8")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                //.thenAccept(System.out::println)
                .thenAccept(Bar::parseBar)
                .join();
    }

    public static  int barCounter;
    public static   String[] barName = new String[20];
    public static   Double[] barRate = new Double[20];
    public static  String[] barType = new String[20];
    public static  Boolean[] barStatus = new Boolean[20];

    public static void parseBar(String responseBody) {
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONArray jsonArray = jsonObject.getJSONArray("results");

        int numOfBar = 0;
        int shopID = 0;

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
            String business_status = (String) jsonObject1.get("business_status");

            JSONArray check_type = jsonObject1.getJSONArray("types");

            if (business_status.equals("OPERATIONAL")) {

                String name = (String) jsonObject1.get("name");
                System.out.println("Name: " + name);

                Boolean open_now;
                try {
                    JSONObject opening_hours = (JSONObject) jsonObject1.get("opening_hours");

                    open_now = opening_hours.getBoolean("open_now");
                } catch (Exception e) {
                    open_now = false;
                }
                System.out.println(" " + open_now);


                business_status = (String) jsonObject1.get("business_status");
                System.out.println("Business status:" + business_status);

                double rating;
                try {
                    rating = ((Number) jsonObject1.get("rating")).doubleValue();
                } catch (Exception e) {
                    rating = 0;
                }
                System.out.println("Rating:" + rating);

                String vicinity = (String) jsonObject1.get("vicinity");
                System.out.println("Vicinity: " + vicinity);

                JSONObject geometry_check = (JSONObject) jsonObject1.get("geometry");
                JSONObject location = geometry_check.getJSONObject("location");
                float longtitude = location.getFloat("lat");
                float latitude = location.getFloat("lng");
                String geometry = valueOf(longtitude)+"  "+ valueOf(latitude);
                System.out.println("Geometry: " + geometry);

                String type = check_type.getString(0)+" , "+check_type.getString(1)+" , "+check_type.getString(2);
                System.out.println("Type: " + type);

                shopID++;

                numOfBar++;
                barName[i]= name;
                barRate[i] = rating;
                barStatus[i] = open_now;
                barType[i] = check_type.getString(0);

                Api.addShopToDatabase(shopID, name, valueOf(open_now)  , business_status, rating, vicinity,type,geometry, check_type);

            }
        }

        barCounter = numOfBar;


        for(int i =0 ; i<barName.length;i++)
        {
            System.out.println(barName[i]);
        }
    }
}



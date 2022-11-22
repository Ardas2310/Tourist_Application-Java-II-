package com.example.tourist_application;

import categories.*;

import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static java.lang.String.valueOf;


public class Api {
    public Api()
    {
        List requests = new ArrayList();

        requests.add("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.088904%2C23.546338&radius=2000&type=cafe&key=AIzaSyDK4M6soWgedHy4r6Cf_mLd1lyn2WbRpB8");
        requests.add("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.088904%2C23.546338&radius=2000&type=restaurant&key=AIzaSyDK4M6soWgedHy4r6Cf_mLd1lyn2WbRpB8");
        requests.add("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.088904%2C23.546338&radius=2000&type=park&key=AIzaSyDK4M6soWgedHy4r6Cf_mLd1lyn2WbRpB8");
        requests.add("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.088904%2C23.546338&radius=2000&type=museum&key=AIzaSyDK4M6soWgedHy4r6Cf_mLd1lyn2WbRpB8");
        requests.add("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.088904%2C23.546338&radius=2000&type=shoe_store&key=AIzaSyDK4M6soWgedHy4r6Cf_mLd1lyn2WbRpB8");
        requests.add("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.088904%2C23.546338&radius=2000&type=clothing_store&key=AIzaSyDK4M6soWgedHy4r6Cf_mLd1lyn2WbRpB8");
        requests.add("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.088904%2C23.546338&radius=2000&type=church&key=AIzaSyDK4M6soWgedHy4r6Cf_mLd1lyn2WbRpB8");
        requests.add("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.088904%2C23.546338&radius=2000&type=bar&key=AIzaSyDK4M6soWgedHy4r6Cf_mLd1lyn2WbRpB8");

        for (int i = 0; i < 8; i++) {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create((String) requests.get(i))).build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    //.thenAccept(System.out::println)
                    .thenAccept(Api::parse)
                    .join();
        }
    }


    public static void parse(String responseBody) {

        JSONObject jsonObject = new JSONObject(responseBody);
        JSONArray jsonArray = jsonObject.getJSONArray("results");

        //Recommended Tables
        String[] shopName = new String[20];
        Double[] shopRate = new Double[20];
        Boolean[] shopOpening = new Boolean[20];
        String[] shopType = new String[20];


        //Initialize Shops
        Recommended recShops = new Recommended();
        Cafe cafe = new Cafe();
        int cafeCounter = 0;

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

                shopName[i]= name;
                shopRate[i] = rating;
                shopOpening[i] = open_now;
                shopType[i] = check_type.getString(0);

                if(check_type.getString(0).equals("cafe"))
                {
                    Cafe.cafeCounter =cafeCounter++;
                    Cafe.cafeName[i] = name;
                    Cafe.cafeRate[i] = rating;
                    Cafe.cafeStatus[i] = open_now;
                    Cafe.cafeType[i] = check_type.getString(0);
                }

                addShopToDatabase(shopID, name, valueOf(open_now)  , business_status, rating, vicinity,type,geometry, check_type);

            }

            //Parse Tables
            recShops.GenerateShops(shopName,shopRate,shopOpening,shopType);
            //cafe.GenerateShops(shopCafeName,shopCafeRate,shopCafeOpening,shopCafeType);
        }
    }

    public static Shop delShopsFromDatabase(){
        Shop shop = null;
        final String DB_URL = "jdbc:mysql://localhost/testing?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn2 = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt2 = conn2.createStatement();
            String sql2 = "DELETE FROM bar;";
            stmt2.execute(sql2);
            sql2 = "DELETE FROM shoe_store;";
            stmt2.execute(sql2);
            sql2 = "DELETE FROM cafe;";
            stmt2.execute(sql2);
            sql2 = "DELETE FROM church;";
            stmt2.execute(sql2);
            sql2 = "DELETE FROM clothing_store;";
            stmt2.execute(sql2);
            sql2 = "DELETE FROM park;";
            stmt2.execute(sql2);
            sql2 = "DELETE FROM restaurant;";
            stmt2.execute(sql2);
            sql2 = "DELETE FROM shoe_store;";
            stmt2.execute(sql2);
            sql2 = "DELETE FROM others;";
            stmt2.execute(sql2);
            sql2 = "DELETE FROM museum;";
            stmt2.execute(sql2);
            System.out.println("Shop Database Deleted");
            stmt2.close();
            conn2.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return shop;
    }

    public static Shop addShopToDatabase(Integer shopID,String name, String open_now , String business_status, double rating,String vicinity,String type,String geometry,JSONArray check_type ) {

        Shop restaurant = null;
        Shop cafe = null;
        Shop bar = null;
        Shop church = null;
        Shop clothing_store = null;
        Shop museum = null;
        Shop park = null;
        Shop shoe_store = null;
        Shop others=null;

        final String DB_URL = "jdbc:mysql://localhost/testing?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";


        if (check_type.getString(0).equals("bar")) {
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                Statement stmt = conn.createStatement();
                String sql = "INSERT INTO bar (ID, name, open_now, business_status, rating, vicinity, type,geometry) " +
                        "VALUES (?, ?, ?, ?, ?, ?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, shopID);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, open_now);
                preparedStatement.setString(4, business_status);
                preparedStatement.setDouble(5, rating);
                preparedStatement.setString(6, vicinity);
                preparedStatement.setString(7, type);
                preparedStatement.setString(8, geometry);
                preparedStatement.executeUpdate();
                //Inserting rows into the table
                int addedRows = preparedStatement.executeUpdate();
                if (addedRows > 0) {

                    bar = new Shop();
                    bar.ID = shopID;
                    bar.name = name;
                    bar.open_now = open_now;
                    bar.business_status = business_status;
                    bar.rating = (float) rating;
                    bar.vicinity = vicinity;
                    bar.check_type = type;
                    bar.geometry = geometry;

                }
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bar;

        } else if (check_type.getString(0).equals("cafe")) {

            try {

                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                Statement stmt = conn.createStatement();
                String sql = "INSERT INTO cafe (ID, name, open_now, business_status, rating, vicinity, type,geometry) " +
                        "VALUES (?, ?, ?, ?, ?, ?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, shopID);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, open_now);
                preparedStatement.setString(4, business_status);
                preparedStatement.setDouble(5, rating);
                preparedStatement.setString(6, vicinity);
                preparedStatement.setString(7, type);
                preparedStatement.setString(8, geometry);
                preparedStatement.executeUpdate();
                //Inserting rows into the table
                int addedRows = preparedStatement.executeUpdate();
                if (addedRows > 0) {
                    cafe = new Shop();
                    cafe.ID = shopID;
                    cafe.name = name;
                    cafe.open_now = open_now;
                    cafe.business_status = business_status;
                    cafe.rating = (float) rating;
                    cafe.vicinity = vicinity;
                    cafe.check_type = type;
                    cafe.geometry = geometry;

                }

                stmt.close();
                conn.close();

            } catch (Exception e) {

                e.printStackTrace();

            }
            return cafe;

        } else if (check_type.getString(0).equals("church")) {

            try {

                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                Statement stmt = conn.createStatement();
                String sql = "INSERT INTO church (ID, name, open_now, business_status, rating, vicinity, type,geometry) " +
                        "VALUES (?, ?, ?, ?, ?, ?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, shopID);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, open_now);
                preparedStatement.setString(4, business_status);
                preparedStatement.setDouble(5, rating);
                preparedStatement.setString(6, vicinity);
                preparedStatement.setString(7, type);
                preparedStatement.setString(8, geometry);
                preparedStatement.executeUpdate();
                //Inserting rows into the table
                int addedRows = preparedStatement.executeUpdate();
                if (addedRows > 0) {

                    church = new Shop();
                    church.ID = shopID;
                    church.name = name;
                    church.open_now = open_now;
                    church.business_status = business_status;
                    church.rating = (float) rating;
                    church.vicinity = vicinity;
                    church.check_type = type;
                    church.geometry = geometry;

                }

                stmt.close();
                conn.close();

            } catch (Exception e) {

                e.printStackTrace();
            }

            return church;

        } else if (check_type.getString(0).equals("clothing_store")) {

            try {

                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                Statement stmt = conn.createStatement();
                String sql = "INSERT INTO clothing_store (ID, name, open_now, business_status, rating, vicinity, type,geometry) " +
                        "VALUES (?, ?, ?, ?, ?, ?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, shopID);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, open_now);
                preparedStatement.setString(4, business_status);
                preparedStatement.setDouble(5, rating);
                preparedStatement.setString(6, vicinity);
                preparedStatement.setString(7, type);
                preparedStatement.setString(8, geometry);
                preparedStatement.executeUpdate();
                //Inserting rows into the table
                int addedRows = preparedStatement.executeUpdate();
                if (addedRows > 0) {

                    clothing_store = new Shop();
                    clothing_store.ID = shopID;
                    clothing_store.name = name;
                    clothing_store.open_now = open_now;
                    clothing_store.business_status = business_status;
                    clothing_store.rating = (float) rating;
                    clothing_store.vicinity = vicinity;
                    clothing_store.check_type = type;
                    clothing_store.geometry = geometry;

                }
                stmt.close();
                conn.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
            return clothing_store;

        }
        else if (check_type.getString(0).equals("museum")) {

            try {

                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                Statement stmt = conn.createStatement();
                String sql = "INSERT INTO museum (ID, name, open_now, business_status, rating, vicinity, type,geometry) " +
                        "VALUES (?, ?, ?, ?, ?, ?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, shopID);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, open_now);
                preparedStatement.setString(4, business_status);
                preparedStatement.setDouble(5, rating);
                preparedStatement.setString(6, vicinity);
                preparedStatement.setString(7, type);
                preparedStatement.setString(8, geometry);
                preparedStatement.executeUpdate();
                //Inserting rows into the table
                int addedRows = preparedStatement.executeUpdate();
                if (addedRows > 0) {

                    museum = new Shop();
                    museum.ID = shopID;
                    museum.name = name;
                    museum.open_now = open_now;
                    museum.business_status = business_status;
                    museum.rating = (float) rating;
                    museum.vicinity = vicinity;
                    museum.check_type = type;
                    museum.geometry = geometry;

                }

                stmt.close();
                conn.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

            return museum;

        }

        else if (check_type.getString(0).equals("park")) {

            try {

                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                Statement stmt = conn.createStatement();
                String sql = "INSERT INTO park (ID, name, open_now, business_status, rating, vicinity, type,geometry) " +
                        "VALUES (?, ?, ?, ?, ?, ?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, shopID);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, open_now);
                preparedStatement.setString(4, business_status);
                preparedStatement.setDouble(5, rating);
                preparedStatement.setString(6, vicinity);
                preparedStatement.setString(7, type);
                preparedStatement.setString(8, geometry);
                preparedStatement.executeUpdate();
                //Inserting rows into the table
                int addedRows = preparedStatement.executeUpdate();
                if (addedRows > 0) {

                    park = new Shop();
                    park.ID = shopID;
                    park.name = name;
                    park.open_now = open_now;
                    park.business_status = business_status;
                    park.rating = (float) rating;
                    park.vicinity = vicinity;
                    park.check_type = type;
                    park.geometry = geometry;

                }

                stmt.close();
                conn.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

            return park;

        }

        else if (check_type.getString(0).equals("restaurant")) {

            try {

                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                Statement stmt = conn.createStatement();
                String sql = "INSERT INTO restaurant (ID, name, open_now, business_status, rating, vicinity, type,geometry) " +
                        "VALUES (?, ?, ?, ?, ?, ?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, shopID);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, open_now);
                preparedStatement.setString(4, business_status);
                preparedStatement.setDouble(5, rating);
                preparedStatement.setString(6, vicinity);
                preparedStatement.setString(7, type);
                preparedStatement.setString(8, geometry);
                preparedStatement.executeUpdate();
                //Inserting rows into the table
                int addedRows = preparedStatement.executeUpdate();
                if (addedRows > 0) {

                    restaurant = new Shop();
                    restaurant.ID = shopID;
                    restaurant.name = name;
                    restaurant.open_now = open_now;
                    restaurant.business_status = business_status;
                    restaurant.rating = (float) rating;
                    restaurant.vicinity = vicinity;
                    restaurant.check_type = type;
                    restaurant.geometry = geometry;

                }

                stmt.close();
                conn.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

            return restaurant;

        }

        else if (check_type.getString(0).equals("shoe_store")) {
            try {

                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                Statement stmt = conn.createStatement();
                String sql = "INSERT INTO shoe_store (ID, name, open_now, business_status, rating, vicinity, type,geometry) " +
                        "VALUES (?, ?, ?, ?, ?, ?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, shopID);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, open_now);
                preparedStatement.setString(4, business_status);
                preparedStatement.setDouble(5, rating);
                preparedStatement.setString(6, vicinity);
                preparedStatement.setString(7, type);
                preparedStatement.setString(8, geometry);
                preparedStatement.executeUpdate();
                //Inserting rows into the table
                int addedRows = preparedStatement.executeUpdate();
                if (addedRows > 0) {

                    shoe_store = new Shop();
                    shoe_store.ID = shopID;
                    shoe_store.name = name;
                    shoe_store.open_now = open_now;
                    shoe_store.business_status = business_status;
                    shoe_store.rating = (float) rating;
                    shoe_store.vicinity = vicinity;
                    shoe_store.check_type = type;
                    shoe_store.geometry = geometry;

                }

                stmt.close();
                conn.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

            return shoe_store;

        }
        else{
            try{
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                Statement stmt = conn.createStatement();
                String sql = "INSERT INTO others (ID, name, open_now, business_status, rating, vicinity, type,geometry) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, shopID);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, open_now);
                preparedStatement.setString(4, business_status);
                preparedStatement.setDouble(5, rating);
                preparedStatement.setString(6, vicinity);
                preparedStatement.setString(7, type);
                preparedStatement.setString(8, geometry);
                preparedStatement.executeUpdate();
                //Inserting rows into the table
                int addedRows = preparedStatement.executeUpdate();
                if (addedRows > 0){
                    others = new Shop();
                    others.ID = shopID;
                    others.name = name;
                    others.open_now = open_now;
                    others.business_status = business_status;
                    others.rating = (float) rating;
                    others.vicinity = vicinity;
                    others.check_type = type;
                    others.geometry = geometry;
                }
                stmt.close();
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            return others;
        }
    }
}

package com.example.tourist_application;
import categories.*;

import java.sql.*;


public class Api {

    public Api()
    {
        new Cafe();
        new Bar();
        new Restaurant();
        new Park();
        new Museum();
        new Church();
        //requests.add("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.088904%2C23.546338&radius=2000&type=shoe_store&key=AIzaSyDK4M6soWgedHy4r6Cf_mLd1lyn2WbRpB8");
        //requests.add("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.088904%2C23.546338&radius=2000&type=clothing_store&key=AIzaSyDK4M6soWgedHy4r6Cf_mLd1lyn2WbRpB8");

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

    public static  void addFavouriteToDb(String name)
    {

    }
}

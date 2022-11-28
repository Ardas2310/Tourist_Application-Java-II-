package com.example.tourist_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Register {

    public static  User user;

    private User addUserToDatabase(Integer id,String name, String email, String phone, String address, String password , String favourites) {
        User user = null;


        final String DB_URL = "jdbc:mysql://localhost/testing?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users (id,name, email, phone, address, password,favourites) " +
                    "VALUES (?,?, ?, ?, ?, ?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, favourites);

            //Inserting rows into the table
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0){
                user = new User();
                user.id = id;
                user.name = name;
                user.email = email;
                user.phone = phone;
                user.address = address;
                user.password = password;
                user.favourites = favourites;
            }
            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }
}

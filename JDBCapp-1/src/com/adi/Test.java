package com.adi;
import java.sql.*;

public class Test {
    public static void main(String[] args) {
        //mysql database url with schema name or db name
        String url = "jdbc:mysql://localhost:3306/students";
        //database credentials
        String username= "root";
        String password= "root";
        //Establish the database connection
        try( Connection connection = DriverManager.getConnection(url,username,password)){
            System.out.println("Connection Establish Successfully..........");
            System.out.println(connection);
        }catch (SQLException e){
            System.out.println("Connection Establish Failed..........");
        }
    }
}

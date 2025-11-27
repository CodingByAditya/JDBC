package com.adi;

import java.sql.*;

public class Employee {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/students";
        String username= "root";
        String password= "root";
        String query = "select * from employee;";

        //Driver Loading Logic
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully....");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        //Establish The Connection
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to database Successfully..........");

            //creating statement
            System.out.println("Statement Created....");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("Statement/Query Executed....");
            System.out.println("Resultset Getting The Result From DB....");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String desg = rs.getString("desg");
                double salary = rs.getDouble("salary");
                System.out.println("------------------------------------------");
                System.out.println("***** Employee details *****");
                System.out.println("Employee-Id: " + id);
                System.out.println("Employee-Name: " + name);
                System.out.println("Employee-Desg: " + desg);
                System.out.println("Employee-Salary: " + salary);
                connection.close();
                statement.close();

            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("Connection Closed....");
    }
}

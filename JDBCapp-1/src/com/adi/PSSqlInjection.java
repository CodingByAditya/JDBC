package com.adi;
import java.sql.*;
import java.util.Scanner;

public class PSSqlInjection {
    public static void main(String[] args) {
        while(true) {
            String url = "jdbc:mysql://localhost:3306/students";
            String username = "root";
            String password = "root";
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter your username: ");
            String instaUserName = scn.nextLine();
            System.out.println("Enter your password: ");
            String instaPassword = scn.nextLine();
            String query = "SELECT COUNT(*) FROM instagram where username= ?  AND password= ? ";
            System.out.println(query);
            Connection connection = null;
            PreparedStatement ps = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
                ps = connection.prepareStatement(query);
                ps.setString(1,instaUserName);
                ps.setString(2,instaPassword);
                ResultSet rs=ps.executeQuery();
                rs.next();
                int status=rs.getInt(1);
                if (status == 0) {
                    System.out.println("Invalid Credentials Sorry....");
                } else {
                    System.out.println("Valid Credentials... Successfully login into insta");
                }
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (SQLException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }
}

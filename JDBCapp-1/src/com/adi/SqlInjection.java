package com.adi;
import java.sql.* ;
import java.util.Scanner;

public class SqlInjection {
    public static void main(String[] args) {

        while(true) {
            String url = "jdbc:mysql://localhost:3306/students";
            String username = "root";
            String password = "root";
            Scanner scn = new Scanner(System.in);

            System.out.println("Enter Your Username");
            String instaUsername = scn.nextLine();
            System.out.println("Enter Your Password");
            String instaPassword = scn.nextLine();

            String query = "SELECT COUNT(*) FROM instagram where username= "+ "'" + instaUsername + "'" + "AND " + "password= " + "'" + instaPassword + "'";
            System.out.println(query);
            Connection connection = null;
            Statement statement = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
                statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query);
                int status = 0;
                if (rs.next()) {
                    status = rs.getInt(1);
                }
                if (status == 0) {
                    System.out.println("Invalid Credential Sorry.....");
                } else {
                    System.out.println("Valid Credential..... Successfully Login Into Instagram....");
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

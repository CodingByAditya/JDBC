package com.adi;
import java.sql.* ;
public class Employee2 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/students";
        String username= "root";
        String password= "root";
        String query ="DELETE FROM employee WHERE id = '3'";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            int status = statement.executeUpdate(query);

            if(status>0){
                System.out.println("Data Deleted Successfully..........");
            }else {
                System.out.println("Ooops.. Something Went Wrong.........");
            }
        }catch (ClassNotFoundException e1){
            e1.printStackTrace();
        }catch (SQLException e2){
            e2.printStackTrace();
        }catch (Exception e3){
            e3.printStackTrace();
        }

    }
}

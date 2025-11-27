package com.adi;
import java.sql.* ;
public class Employee1 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/students";
        String username= "root";
        String password= "root";
        String query = "INSERT INTO employee(id,name,desg,salary) " +
                "VALUES(104,'Babula','business',10000.00)";

        try{
            Class.forName("com.mysql.cjj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            int status = statement.executeUpdate(query);

            if(status>0){
                System.out.println("Data Inserted Successfully..........");
            }else {
                System.out.println("Ooops.. Something Went Wrong.........");
            }
            connection.close();
            statement.close();
        }catch (ClassNotFoundException e1){
            e1.printStackTrace();
        }catch (SQLException e2){
            e2.printStackTrace();
        }catch (Exception e3){
            e3.printStackTrace();
        }

    }
}

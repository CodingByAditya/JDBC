package com.adi;
import java.sql.* ;
public class Employee3 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/students";
        String username= "root";
        String password= "root";
        String query ="UPDATE employee set id=3,name='Bibhuti Ranjan Behera',desg='AI Engineer',salary=500000.00 where id='4'";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            int status = statement.executeUpdate(query);

            if(status>0){
                System.out.println("Data Updated Successfully..........");
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

package com.adi;
import java.sql.* ;
import java.util.Scanner;

public class Employee5 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/students";
        String username= "root";
        String password= "root";
        Scanner scn = new Scanner(System.in);
        System.out.println("Hey please enter employee id :");
        int    id = scn.nextInt();
        scn.nextLine();
        System.out.println("Hey please enter employee name :");
        String name = scn.nextLine();
        System.out.println("Hey please enter employee desg :");
        String desg = scn.nextLine();
        System.out.println("Hey please enter employee salary :");
        double salary = scn.nextDouble();
        String query  ="INSERT INTO employee(id,name,desg,salary) VALUES("+id+","+"'"+name+"'"+","+"'"+desg+"'"+","+salary+")";
        String selectQuery = "Select * from employee";
        System.out.println(query);
        Connection connection = null;
        Statement statement = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
            int status = statement.executeUpdate(query);

            if(status>0){
                System.out.println("Data Updated Successfully..........");
            }else {
                System.out.println("Ooops.. Something Went Wrong.........");
            }
            ResultSet rs = statement.executeQuery(selectQuery);
            while (rs.next()) {
                int printid = rs.getInt("id");
                String printname = rs.getString("name");
                String printdesg = rs.getString("desg");
                double printsalary = rs.getDouble("salary");
                System.out.println("------------------------------------------");
                System.out.println("***** Employee details *****");
                System.out.println("Employee-Id: " + printid);
                System.out.println("Employee-Name: " + printname);
                System.out.println("Employee-Desg: " + printdesg);
                System.out.println("Employee-Salary: " + printsalary);


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

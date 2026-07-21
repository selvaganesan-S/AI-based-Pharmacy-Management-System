package com.pharmacy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Customer {


    public void addCustomer() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();
            
            System.out.println("\n===== Add Customer =====");

            System.out.print("Enter Customer ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();
            
            System.out.print("Enter Address: ");
            String address = sc.nextLine();



            String sql = "INSERT INTO customer VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setString(3,phone);
            ps.setString(4,address);


            int rows = ps.executeUpdate();

            if(rows > 0) {
                System.out.println("Customer Added Successfully");
            }

        }
        catch(Exception e) {
            System.out.println(e);
        }
    }



    public void viewCustomer() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM customer";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();


            System.out.println("\n===== Customer List =====");


            while(rs.next()) {

                System.out.println("Customer ID : " + rs.getInt("customer_id"));
                System.out.println("Customer Name : " + rs.getString("customer_name"));
                System.out.println("Phone : " + rs.getString("phone"));
                System.out.println("address : " + rs.getString("address"));
                System.out.println("------------------------");
            }

        }
        catch(Exception e) {
            System.out.println(e);
        }
    }



    public void deleteCustomer() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();
            
            System.out.println("\n===== Delete Customer =====");

            System.out.print("Enter Customer ID: ");
            int id = sc.nextInt();


            String sql = "DELETE FROM customer WHERE customer_id=?";


            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,id);


            int rows = ps.executeUpdate();


            if(rows > 0) {
                System.out.println("Customer Deleted Successfully");
            }
            else {
                System.out.println("Customer Not Found");
            }

        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void updateCustomer() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n===== Update Customer =====");

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter New Address: ");
        String address = sc.nextLine();

        String query = "UPDATE customer SET phone=?, address=? WHERE customer_id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, phone);
            ps.setString(2, address);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Customer Updated Successfully.");
            } else {
                System.out.println("Customer ID Not Found.");
            }

            ps.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}
package com.pharmacy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Supplier {

    public void addSupplier() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Supplier ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Supplier Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();

            System.out.print("Enter Address: ");
            String address = sc.nextLine();


            String sql = "INSERT INTO supplier VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, address);

            int rows = ps.executeUpdate();

            if(rows > 0) {
                System.out.println("Supplier Added Successfully");
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }


    public void viewSupplier() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM supplier";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== Supplier List =====");

            while(rs.next()) {

                System.out.println("Supplier ID : " + rs.getInt("supplier_id"));
                System.out.println("Supplier Name : " + rs.getString("supplier_name"));
                System.out.println("Phone : " + rs.getString("phone"));
                System.out.println("Address : " + rs.getString("address"));
                System.out.println("-------------------------");
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }


    public void updateSupplier() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();
            
            System.out.println("\n===== Update Supplier =====");

            System.out.print("Enter Supplier ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Phone: ");
            String phone = sc.nextLine();


            String sql = "UPDATE supplier SET phone=? WHERE supplier_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, phone);
            ps.setInt(2, id);


            int rows = ps.executeUpdate();

            if(rows > 0) {
                System.out.println("Supplier Updated Successfully");
            }
            else {
                System.out.println("Supplier Not Found");
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }


    public void deleteSupplier() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();
            
            System.out.println("\n===== Delete Supplier =====");

            System.out.print("Enter Supplier ID: ");
            int id = sc.nextInt();


            String sql = "DELETE FROM supplier WHERE supplier_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,id);


            int rows = ps.executeUpdate();

            if(rows > 0) {
                System.out.println("Supplier Deleted Successfully");
            }
            else {
                System.out.println("Supplier Not Found");
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }

}
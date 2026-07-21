package com.pharmacy;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Medicine {

    public void addMedicine() {
    	Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();
            
            System.out.println("===== ADD MEDICINE =====");

            System.out.print("Enter Medicine Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Company: ");
            String company = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
            String expiry = sc.nextLine();
            
            System.out.print("Enter Medicine ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Enter Sales: ");
            int sales = sc.nextInt();
            sc.nextLine();

            String sql = "INSERT INTO medicine VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            
            ps.setString(1, name);
            ps.setString(2, company);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, expiry);
            ps.setInt(6, id);
            ps.setInt(7, sales);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Medicine Added Successfully");
            } else {
                System.out.println("Failed to Add Medicine");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void viewMedicine() {
    	try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM medicine";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== Medicine List =====");

            while (rs.next()) {

                System.out.println("Medicine ID : " + rs.getInt("medicine_id"));
                System.out.println("Medicine Name : " + rs.getString("medicine_name"));
                System.out.println("Company : " + rs.getString("company"));
                System.out.println("Price : " + rs.getDouble("price"));
                System.out.println("Quantity : " + rs.getInt("quantity"));
                System.out.println("Expiry Date : " + rs.getDate("expiry_date"));
                System.out.println("Sales : " + rs.getInt("sales"));
                System.out.println("--------------------------------");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void updateMedicine() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();
            
            System.out.println("===== Update medicine =====");

            System.out.print("Enter Medicine ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Price: ");
            double price = sc.nextDouble();

            String sql = "UPDATE medicine SET price=? WHERE medicine_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, price);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Medicine Updated Successfully");
            } else {
                System.out.println("Medicine Not Found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void deleteMedicine() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();
            
            System.out.println("===== Delete medicine =====");

            System.out.print("Enter Medicine ID: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM medicine WHERE medicine_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Medicine Deleted Successfully");
            } else {
                System.out.println("Medicine Not Found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void searchMedicine() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();
            
            System.out.println("===== Searh medicine ======");

            System.out.print("Enter Medicine Name: ");
            String name = sc.nextLine();

            String sql = "SELECT * FROM medicine WHERE medicine_name=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Medicine Name : " + rs.getString("medicine_name"));
                System.out.println("Company : " + rs.getString("company"));
                System.out.println("Price : " + rs.getDouble("price"));
                System.out.println("Quantity : " + rs.getInt("quantity"));
                System.out.println("Expiry Date : " + rs.getDate("expiry_date"));
                System.out.println("Sales : " + rs.getInt("sales"));
                System.out.println("Medicine ID : " + rs.getInt("medicine_id"));

            } else {

                System.out.println("Medicine Not Found");

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
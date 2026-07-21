package com.pharmacy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Sales {


    public void billingCounter() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();
            
            System.out.println("===== BillingCounter =====");

            System.out.print("Enter Sale ID: ");
            int saleId = sc.nextInt();


            System.out.print("Enter Customer ID: ");
            int customerId = sc.nextInt();


            System.out.print("Enter Medicine ID: ");
            int medicineId = sc.nextInt();


            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();



            String priceQuery =
            "SELECT price, quantity FROM medicine WHERE medicine_id=?";


            PreparedStatement ps1 = con.prepareStatement(priceQuery);

            ps1.setInt(1, medicineId);

            ResultSet rs = ps1.executeQuery();



            if(rs.next()) {


                double price = rs.getDouble("price");

                int stock = rs.getInt("quantity");


                if(stock >= quantity) {


                    double total = price * quantity;



                    String sql =
                    "INSERT INTO sales VALUES(?,?,?,?,?,CURDATE())";


                    PreparedStatement ps2 =
                    con.prepareStatement(sql);


                    ps2.setInt(1,saleId);
                    ps2.setInt(2,customerId);
                    ps2.setInt(3,medicineId);
                    ps2.setInt(4,quantity);
                    ps2.setDouble(5,total);


                    ps2.executeUpdate();



                    String update =
                    "UPDATE medicine SET quantity=quantity-? WHERE medicine_id=?";


                    PreparedStatement ps3 =
                    con.prepareStatement(update);


                    ps3.setInt(1,quantity);
                    ps3.setInt(2,medicineId);


                    ps3.executeUpdate();



                    System.out.println("Sale Completed Successfully");
                    System.out.println("Total Amount : " + total);


                }
                else {

                    System.out.println("Not Enough Stock");

                }


            }
            else {

                System.out.println("Medicine Not Found");

            }


        }
        catch(Exception e) {

            System.out.println(e);

        }

    }
    public static void viewSalesHistory() {

        String query = "SELECT * FROM sales";

        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\n========== SALES HISTORY ==========");

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println("--------------------------------");
                System.out.println("Sale ID      : " + rs.getInt("sale_id"));
                System.out.println("Customer ID  : " + rs.getInt("customer_id"));
                System.out.println("Medicine ID  : " + rs.getInt("medicine_id"));
                System.out.println("Quantity     : " + rs.getInt("quantity"));
                System.out.println("Total_Price : " + rs.getDouble("total"));
                System.out.println("Sale Date    : " + rs.getDate("sale_date"));
            }

            if (!found) {
                System.out.println("No Sales Records Found.");
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}
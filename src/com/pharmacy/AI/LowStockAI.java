package com.pharmacy.AI;

import com.pharmacy.DBConnection;
import java.sql.*;

public class LowStockAI {

    public static void checkStock() {

        try {

            Connection con = DBConnection.getConnection();
            
            System.out.println("\n========== Check Stock Detials ==========");

            String query = "select medicine_name, quantity from medicine";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);


            while(rs.next()) {

                String name = rs.getString("medicine_name");

                int stock = rs.getInt("quantity");


                if(stock < 10) {

                    System.out.println(
                    "AI Alert: " + name +
                    " stock is low. Order new stock");

                }
                else {

                    System.out.println(
                    name + " stock available");

                }

            }

        }
        catch(Exception e) {

            System.out.println(e);

        }

    }

}
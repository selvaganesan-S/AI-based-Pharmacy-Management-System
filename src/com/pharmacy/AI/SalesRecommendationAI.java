package com.pharmacy.AI;

import com.pharmacy.DBConnection;
import java.sql.*;

public class SalesRecommendationAI {

    public static void checkSales() {

        try {

            Connection con = DBConnection.getConnection();
            
            System.out.println("\n========== Sales Recommend and Analyz ==========");

            String query = "select medicine_name, sales from medicine";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);


            while(rs.next()) {

                String name = rs.getString("medicine_name");

                int sales = rs.getInt("sales");


                if(sales > 100) {

                    System.out.println(
                    "AI Recommendation: " + name +
                    " is high demand. Increase stock");

                }
                else {

                    System.out.println(
                    name + " sales is normal");

                }

            }

        }
        catch(Exception e) {

            System.out.println(e);

        }

    }

}

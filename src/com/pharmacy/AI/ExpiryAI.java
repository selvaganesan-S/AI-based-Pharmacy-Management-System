package com.pharmacy.AI;

import com.pharmacy.DBConnection;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ExpiryAI {

    public static void checkExpiry() {

        try {

            Connection con = DBConnection.getConnection();
            
            System.out.println("\n========== Check Expiry Date ==========");
            
            String query = "select medicine_name, expiry_date from medicine";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);


            LocalDate today = LocalDate.now();


            while(rs.next()) {

                String name = rs.getString("medicine_name");

                Date expiry = rs.getDate("expiry_date");


                LocalDate expiryDate =
                expiry.toLocalDate();


                long days =
                ChronoUnit.DAYS.between(today, expiryDate);


                if(days <= 30) {

                    System.out.println(
                    "AI Alert: " + name +
                    " expires in " + days +
                    " days");

                }
                else {

                    System.out.println(
                    name + " expiry safe");

                }

            }

        }
        catch(Exception e) {

            System.out.println(e);

        }

    }

}
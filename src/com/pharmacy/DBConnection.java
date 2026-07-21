package com.pharmacy;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pharmacy",
                    "root",
                    "selvaselva008");

            System.out.println("Database Connected Successfully");
            return con;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
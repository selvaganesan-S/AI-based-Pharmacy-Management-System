package com.pharmacy.AI;
import com.pharmacy.DBConnection;
import java.sql.*;
import java.util.Scanner;

public class MedicineRecommendation {

public static void recommendMedicine(){

try{

Connection con = DBConnection.getConnection();

Scanner sc = new Scanner(System.in);

System.out.println("\n========== AI Medicine Recommend ==========");

System.out.print("Enter symptom: ");
String symptom = sc.nextLine();


String query =
"select medicine from medicine_recommendation where symptom=?";


PreparedStatement ps = con.prepareStatement(query);

ps.setString(1, symptom);


ResultSet rs = ps.executeQuery();


if(rs.next()){

System.out.println(
"AI Recommended Medicine: "
+ rs.getString("medicine"));

}

else{

System.out.println(
"No recommendation available");

}


}
catch(Exception e){

System.out.println(e);

}

}

}
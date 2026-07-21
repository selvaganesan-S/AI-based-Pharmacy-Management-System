package com.pharmacy;

import com.pharmacy.AI.MedicineRecommendation;
import com.pharmacy.AI.LowStockAI;
import com.pharmacy.AI.ExpiryAI;
import com.pharmacy.AI.SalesRecommendationAI;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Login login = new Login();

        if (login.login()) {

            Scanner sc = new Scanner(System.in);

            Medicine medicine = new Medicine();
            Supplier supplier = new Supplier();
            Customer customer = new Customer();
            Sales sales = new Sales();

            int choice;

            do {

                System.out.println("\n===== Pharmacy Management System =====");
                System.out.println("1. Add Medicine");
                System.out.println("2. View Medicine");
                System.out.println("3. Update Medicine");
                System.out.println("4. Delete Medicine");
                System.out.println("5. Search Medicine");
                System.out.println("6. Add Supplier");
                System.out.println("7. View Supplier");
                System.out.println("8. Update Supplier");
                System.out.println("9. Delete Supplier");
                System.out.println("10. Add Customer");
                System.out.println("11. View Customer");
                System.out.println("12. Delete Customer");
                System.out.println("13. Update Customer");
                System.out.println("14. Billing Counter");
                System.out.println("15. View Sales History");           
                System.out.println("16. AI Medicine Recommendation");
                System.out.println("17. Check Stock");
                System.out.println("18. Analyz Expiry Date");
                System.out.println("19. Analyz Sales ");
                System.out.println("20. Exit");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        medicine.addMedicine();
                        break;

                    case 2:
                        medicine.viewMedicine();
                        break;

                    case 3:
                        medicine.updateMedicine();
                        break;

                    case 4:
                        medicine.deleteMedicine();
                        break;

                    case 5:
                        medicine.searchMedicine();
                        break;
                        
                    case 6:
                    	supplier.addSupplier();
                        break;
                        
                    case 7:
                    	supplier.viewSupplier();
                        break;
                        
                    case 8:
                    	supplier.updateSupplier();
                        break;
                        
                    case 9:
                    	supplier.deleteSupplier();
                        break;
                        
                    case 10:
                        customer.addCustomer();
                        break;
                        
                    case 11:
                        customer.viewCustomer();
                        break;
                        
                    case 12:
                        customer.deleteCustomer();
                        break;
                        
                    case 13:
                        customer.updateCustomer();
                        break;

                    case 14:
                        sales.billingCounter();
                        break;
                    
                    case 15:
                    	sales.viewSalesHistory();
                        break;
                    
                    case 16:
                        MedicineRecommendation.recommendMedicine();
                        break;
                        
                    case 17:
                        LowStockAI.checkStock();
                        break;
                        
                    case 18:
                        ExpiryAI.checkExpiry();
                        break;
                        
                    case 19:
                        SalesRecommendationAI.checkSales();
                        break;
                    
                    case 20:
                        System.out.println("Thank You!");
                        System.out.println("Visit Again!");
                        break;

                    default:
                        System.out.println("Invalid Choice");
                       
                        
                }

            } while (choice != 50);

        } else {

            System.out.println("Login Failed");

        }
        
      
    }

}
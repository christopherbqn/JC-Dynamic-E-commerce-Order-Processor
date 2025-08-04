package org.example;
import java.util.*;

public class InteractiveOrderProcessor {

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Welcome to the Interactive Order Processor! ===\n");
        System.out.println("--- 📋Order Details ---");


        // prompts for user input
        System.out.print("Enter Unit Price: ");
        double unitPrice = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.print("Are you a member? (true/false): ");
        Boolean membership = Boolean.valueOf(scanner.nextLine());

        System.out.print("Enter customer tier (Regular, Silver, Gold): ");
        String customerTier = scanner.nextLine();

        System.out.print("Enter Shipping Zone (ZoneA, ZoneB, ZoneC, Unknown): ");
        String shippingZone = scanner.nextLine();

        System.out.print("Enter Discount Code: ");
        String discountCode = scanner.nextLine();

        // show order summary




    }

}

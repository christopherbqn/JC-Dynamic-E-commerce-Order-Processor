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
        Boolean isMember = Boolean.valueOf(scanner.nextLine());

        System.out.print("Enter customer tier (Regular, Silver, Gold): ");
        String customerTier = scanner.nextLine();

        System.out.print("Enter Shipping Zone (ZoneA, ZoneB, ZoneC, Unknown): ");
        String shippingZone = scanner.nextLine();

        System.out.print("Enter Discount Code: ");
        String discountCode = scanner.nextLine();

        // show order summary
        System.out.println("\n--- ✅ Order Summary ---");
        System.out.println("Unit Price: $" + unitPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Is Member: " + isMember);
        System.out.println("Customer Tier: " + customerTier);
        System.out.println("Shipping Zone: " + shippingZone);
        System.out.println("Discount Code: " + discountCode);
        System.out.println();

        // calculation breakdown
        double subTotal = (unitPrice * quantity);

        System.out.println("--- 💵Order Breakdown ---");
        System.out.println("Order Subtotal: $" + subTotal);

        // tier-based discount
        double tierDiscount;
        if(customerTier.equals("Gold")){
            tierDiscount = 0.15;
        } else if (customerTier.equals("Silver")){
            tierDiscount = 0.10;
        } else {
            tierDiscount = 0.0;
        }
        double totalAfterTierDiscount = subTotal-(tierDiscount * subTotal);
        System.out.println("After " + customerTier + " Tier Discount (" + (tierDiscount*100) +"%): $" + totalAfterTierDiscount);

        // quantity discount
        double quantityDiscount;
        if(quantity >= 5){
            quantityDiscount = 0.10;
        }else{
            quantityDiscount = 0.0;
        }
        double totalAfterQuantityDiscount = totalAfterTierDiscount-(quantityDiscount*totalAfterTierDiscount);
        System.out.println("After Quantity Discount (" + (quantityDiscount*100) +"%): $" + totalAfterQuantityDiscount);

        // promotional code application
        double totalAfterPromotionalDiscount;
        if(discountCode.equals("SAVE10") && totalAfterQuantityDiscount > 75.00) {
            // SAVE10 discount
            totalAfterPromotionalDiscount = (totalAfterQuantityDiscount-10.00);
            System.out.println("After Promotional Code (SAVE10 for >$75): $" + totalAfterPromotionalDiscount);
        } else if (discountCode.equalsIgnoreCase("FREESHIP")) {
            // free shipping code
            totalAfterPromotionalDiscount = totalAfterQuantityDiscount;
            System.out.println("After Promotional Code (FREESHIP): $" + totalAfterPromotionalDiscount);
        }else{
            totalAfterPromotionalDiscount = totalAfterQuantityDiscount;
            System.out.println("After Promotional Code (NONE APPLIED): $" + totalAfterPromotionalDiscount);
        }


        // small order surcharge
        double totalAfterSurcharge = (totalAfterPromotionalDiscount < 25.00) ? totalAfterPromotionalDiscount + 3.00:totalAfterPromotionalDiscount;
        if(totalAfterPromotionalDiscount < 25.00){
            System.out.println("After Small Order Surcharge: $" + totalAfterSurcharge + " [Surcharge Applied]");
        }else{
            System.out.println("After Small Order Surcharge: $" + totalAfterSurcharge + " [No Surcharge Applied]");
        }

        // shipping cost calculation
        double shippingCost = 0.0;
        if(!discountCode.equalsIgnoreCase("FREESHIP")){
            switch(shippingZone){
                case "ZoneA":
                    shippingCost = 5.00;
                    break;
                case "ZoneB":
                    shippingCost = 12.50;
                    break;
                case "ZoneC":
                    shippingCost = 20.00;
                    break;
                default:
                    shippingCost = 25.00;
                    break;
            }
        }

        System.out.println("Shipping Cost for " + shippingZone +": $" + shippingCost);

        // final cost
        double totalOrderCost = totalAfterSurcharge + shippingCost;
        System.out.println("💵 Total Cost: $" + totalOrderCost);








    }

}

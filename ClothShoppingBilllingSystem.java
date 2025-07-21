import java.util.Scanner;

public class ClothShoppingBilllingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Cloth Shopping Billing System!");
        double totalBill=0.0;

        while (true) {
            System.out.println("Enter the price of the item (or type 'exit' to finish):");
            String input=sc.nextLine();

            if (input.equals("exit")) {
                break;
            }


            try{
                double price= Double.parseDouble(input);
                if (price<0) {
                    System.out.println("Invalid price! Price cannot be negative.");
                }
                else{
                    totalBill+=price;
                    System.out.println("Item added. Current total: ₹ " + totalBill);
                }
            }catch(NumberFormatException e){
                System.out.println("Invalid input! Please enter a valid price.");
            }

        }
        sc.close();
        if (totalBill>0) {
            double discountPercent=getDiscountPercent(totalBill);
            double finalBill= totalBill - (totalBill*discountPercent/100);
            System.out.println("=============Bill Summary=============");
            System.out.println("Total Bill: "+totalBill);
            System.out.println("Discount Applied: "+discountPercent+"%");
            System.out.println("Final Price: "+finalBill);
        }
    }
    private static double getDiscountPercent(double n){
        if (n>=10000) {
            return 40.0;
        }
        else if(n>=6000){
            return 30.0;
        }
        else if(n>=3000){
            return 18.0;
        }
        else{
            return 8.0;
        }
    }
}


package com.company;

import java.util.Scanner;

public class Console {


    public static void displayOptions(Store store){
        Scanner scan = new Scanner(System.in);
        System.out.println("\nRegister 1");
        System.out.println("__________");
        System.out.println("Make a selection:\n");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. Sale");
        System.out.println("4. View Inventory");
        System.out.println("5. View Store Balance");
        String input = scan.nextLine();
        if(input.equals("1")){
            addProductInput(store, scan);
        } else if(input.equals("2")){
            expiredProductInput(store, scan);
        } else if(input.equals("3")){
            sellProductInput(store, scan);
        } else if(input.equals("4")){
            viewInventory(store);
        } else if(input.equals("5")){
            System.out.println("\nStore Balance = $" + store.balance);
        }
    }

    private static void viewInventory(Store store) {
        System.out.println("\t        #########################");
        System.out.println("\t        ###     INVENTORY     ###");
        System.out.println("\t        #########################\n");
        for(Product product : store.products)
        System.out.println(product);
    }

    private static void sellProductInput(Store store, Scanner scan) {
        System.out.println("Enter name of product to sell");
        String nameOfSoldProduct = scan.nextLine();
        System.out.println("Enter quantity of " + nameOfSoldProduct + ": ");
        int numProductsSold = scan.nextInt();
        scan.nextLine();
        store.sellProduct(nameOfSoldProduct, numProductsSold);
    }

    private static void expiredProductInput(Store store, Scanner scan) {
        System.out.println("Enter name of expired product: ");
        String expiredProduct = scan.nextLine();
        store.throwAway(expiredProduct);
    }

    private static void addProductInput(Store store, Scanner scan) {
        System.out.println("Enter Product Type (Meat or Fruit): ");
        String productType = scan.nextLine();
        System.out.println("Enter name of product: ");
        String productName = scan.nextLine();
        System.out.println("Enter price: ");
        int productPrice = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter amount of product to add");
        int productAmt = scan.nextInt();
        scan.nextLine();
        store.addProduct(productType, productName, productPrice, productAmt);
    }
}

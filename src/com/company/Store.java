package com.company;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int balance;
    List<Product> products = new ArrayList<>();
    List<Product> sales = new ArrayList<>();
    boolean isStoreOpen = true;


    public Store(int balance){
        this.balance = balance;
    }

    public void addProduct(String productType, String name, int price, int amt){
        if (productType.equals("1")){
            this.products.add(new Meat(name, price, amt));
            this.balance -= ((price * amt)/2);
        }
        if (productType.equals("2")){
            this.products.add(new Fruit(name, price, amt));
            this.balance -= ((price * amt)/2);
        }
    }

    public void sellProduct(String productSold, int amt){
        for(Product product : products){
            if(product.name.equals(productSold) && product.amt > 0){
                this.balance += (product.price * amt);
                product.amt -= amt;
                if(!sales.contains(product.name))
                sales.add(new Product(product.name, product.price, amt));
                else{
                    for (Product product1 : sales)
                        if(product.name == product1.name)
                            product1.amt += amt;
                }
                System.out.println("\nTotal Sale Amount = $" + (product.price * amt) + "\n");
            }
        }
        products.removeIf(product -> product.amt == 0);
    }

    public void throwAway(String expiredProduct){
        products.removeIf(product -> product.name.equals(expiredProduct));
    }

    public void calculateDailySales() {
        int totalSales = 0;
        System.out.println("\n__________________________________________________________");
        System.out.println("                       SALES REPORT                       ");
        System.out.println("----------------------------------------------------------");
        for(Product product : sales){
            System.out.println("Felicia sold " + product.amt + " " + product.name + "(s) for $" + product.price + " each, for a total of $" + (product.amt * product.price));
            totalSales += (product.amt * product.price);
        }
        System.out.println("__________________________________________________________");
        System.out.println("Felicia's total sales amount for the day was $" + totalSales);
        System.out.println("----------------------------------------------------------");
    }

}

package com.company;

import java.util.ArrayList;
import java.util.HashMap;
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
        if(products.get(Integer.parseInt(productSold) - 1).amt >= amt) {
            products.get(Integer.parseInt(productSold) - 1);
            products.get(Integer.parseInt(productSold) - 1).amt -= amt;
            balance += (products.get(Integer.parseInt(productSold) - 1).price * products.get(Integer.parseInt(productSold) - 1).amt);
            sales.add((new Product(products.get(Integer.parseInt(productSold) - 1).name, products.get(Integer.parseInt(productSold) - 1).price, amt)));
            System.out.println("\nTotal Sale Amount = $" + (products.get(Integer.parseInt(productSold) - 1).price * amt) + "\n");
            products.removeIf(product -> product.amt == 0);
        }
    }

    public void throwAway(String expiredProduct){
        products.removeIf(product -> product.name.equals(expiredProduct));
    }

    public void calculateDailySales() {
        HashMap<String, Integer> map = new HashMap<>();
        int totalSales = 0;
        System.out.println("\n__________________________________________________________");
        System.out.println("                       SALES REPORT                       ");
        System.out.println("----------------------------------------------------------");
        for(Product product : sales){
            totalSales += (product.price * product.amt);
            if(!map.containsKey(product.name))
            map.put(product.name, product.amt);
            else if(map.containsKey(product.name)){
                Integer newSale = map.get(product.name) + product.amt;
                map.put(product.name, newSale);
            }
        }

        for(String string : map.keySet()){
            int price = 0;
            for(Product product : sales) {
                if (product.name.equals(string))
                    price = product.price;
            }
            System.out.println("Felicia sold " + map.get(string) + " " + string + "(s) for $" + price + " each, for a total of $" + (price * map.get(string)));
        }
        System.out.println("__________________________________________________________");
        System.out.println("Felicia's total sales amount for the day was $" + totalSales);
        System.out.println("----------------------------------------------------------");
    }

}

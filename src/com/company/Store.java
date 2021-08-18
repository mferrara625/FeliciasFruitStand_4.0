package com.company;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int balance;
    List<Product> products = new ArrayList<>();


    public Store(int balance){
        this.balance = balance;
    }

    public void addProduct(String productType, String name, int price, int amt){
        if (productType.equals("Meat")){
            this.products.add(new Meat(name, price, amt));
            this.balance -= ((price * amt)/2);
        }
        if (productType.equals("Fruit")){
            this.products.add(new Fruit(name, price, amt));
            this.balance -= ((price * amt)/2);
        }
    }

    public void sellProduct(String productSold, int amt){
        for(Product product : products){
            if(product.name.equals(productSold) && product.amt > 0){
                this.balance += (product.price * amt);
                product.amt -= amt;
                System.out.println("\nTotal Sale Amount = $" + (product.price * amt) + "\n");
            }
        }
    }

    public void throwAway(String expiredProduct){
        products.removeIf(product -> product.name.equals(expiredProduct));
    }

}

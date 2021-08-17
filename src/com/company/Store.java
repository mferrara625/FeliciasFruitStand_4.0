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
            this.balance -= (price * amt);
        }
        if (productType.equals("Fruit")){
            this.products.add(new Fruit(name, price, amt));
            this.balance -= (price * amt);
        }
    }

    public void sellProduct(String productSold, int amt){
        for(Product product : products){
            if(product.name.equals(productSold)){
                this.balance += (product.price * amt);
                product.amt -= amt;
            }
        }
    }

    public void throwAway(String expiredProduct){
        products.removeIf(product -> product.name.equals(expiredProduct));
    }

}

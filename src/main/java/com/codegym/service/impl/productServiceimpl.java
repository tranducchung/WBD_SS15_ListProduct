package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.productService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class productServiceimpl implements productService {

    private static Map<Integer,Product> products;
    private static int key;

    static {
        products = new HashMap();
        products.put(1,new Product(1,"Computer",1000));
        products.put(2,new Product(2,"Mobile",500));
        products.put(3,new Product(3,"Television",2000));
        products.put(4,new Product(4,"Fridge",2500));
        products.put(5,new Product(5,"WashingMachine",700));
    }
    static {
        key = products.size();
    }
    @Override
    public List<Product> findAll() {
     return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void Add(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void update(int id,Product product) {
       products.put(id,product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    public static int getKey() {
        return key;
    }

    public static void setKey(int key) {
        productServiceimpl.key = key;
    }

    @Override
    public Product Equals(String str) {
        for(int i=1;i<=products.size();i++){
           String name = findById(i).getName();
           if(str.equals(name)){
               return findById(i);
           }
       }
       return null;
    }
}

package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface productService {
    List<Product> findAll();

    Product findById(int id);

    void Add(Product product);

    void update (int id,Product product);

    void remove(int id);

}

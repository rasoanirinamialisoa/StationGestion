package com.example.stationmanagement.service;

import com.example.stationmanagement.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    List<Product> getAllProduct() throws SQLException;
    Product getProductById(int id) throws SQLException;
    Product createProduct (Product product) throws SQLException;
    Product updateProduct(int id, Product product) throws SQLException;

}

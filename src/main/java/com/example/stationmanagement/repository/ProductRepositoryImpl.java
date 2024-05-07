package com.example.stationmanagement.repository;

import com.example.stationmanagement.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    @Override
    public List<Product> getAllProducts() throws SQLException {
        return null;
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        return null;
    }

    @Override
    public Product createProduct(Product product) throws SQLException {
        return null;
    }

    @Override
    public Product updateProduct(int id, Product product) throws SQLException {
        return null;
    }
}

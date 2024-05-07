package com.example.stationmanagement.service;

import com.example.stationmanagement.model.Product;
import com.example.stationmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAllProduct() throws SQLException {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        return productRepository.getProductById(id);
    }

    @Override
    public Product createProduct(Product product) throws SQLException {
        return productRepository.createProduct(product);
    }

    @Override
    public Product updtateProduct(int id, Product product) throws SQLException {
        return productRepository.updateProduct(id, product);
    }
}

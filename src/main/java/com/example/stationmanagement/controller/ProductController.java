package com.example.stationmanagement.controller;

import com.example.stationmanagement.model.Product;
import com.example.stationmanagement.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() throws SQLException {
        return productService.getAllProduct();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id) throws SQLException {
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) throws SQLException {
        return productService.createProduct(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) throws SQLException {
        return productService.updateProduct(id, product);
    }
}


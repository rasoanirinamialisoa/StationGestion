package com.example.stationmanagement.repository;
import com.example.stationmanagement.model.Product;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface ProductRepository {
    List<Product> getAllProducts() throws SQLException;
    Product getProductById(int id) throws SQLException;
    Product createProduct(Product product) throws SQLException;
    Product updateProduct(int id, Product product) throws SQLException;
}

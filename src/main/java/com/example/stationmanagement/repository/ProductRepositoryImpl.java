package com.example.stationmanagement.repository;

import com.example.stationmanagement.config.ConnectDatabase;
import com.example.stationmanagement.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final ConnectDatabase connectDatabase = ConnectDatabase.getInstance();
    private final Connection connection = connectDatabase.getConnection();

    @Override
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Product product = mapResultSetToProduct(resultSet);
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        String query = "SELECT * FROM product WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToProduct(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Product createProduct(Product product) throws SQLException {
        String query = "INSERT INTO product (id, id_station, id_product_template, id_stock_movement) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setInt(2, product.getIdStation());
            preparedStatement.setInt(3, product.getIdProductTemplate());
            preparedStatement.setInt(4, product.getIdStockMovement());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return product;
            } else {
                throw new SQLException("Failed to insert product into database.");
            }
        }
    }

    @Override
    public Product updateProduct(int id, Product product) throws SQLException {
        String query = "UPDATE product SET id_station = ?, id_product_template = ?, id_stock_movement = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, product.getIdStation());
            preparedStatement.setInt(2, product.getIdProductTemplate());
            preparedStatement.setInt(3, product.getIdStockMovement());
            preparedStatement.setInt(4, id);

            int updatedRows = preparedStatement.executeUpdate();
            if (updatedRows > 0) {
                return product;
            }
        }
        return null;
    }

    private Product mapResultSetToProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt(Product.ID));
        product.setIdStation(resultSet.getInt(Product.ID_STATION));
        product.setIdProductTemplate(resultSet.getInt(Product.ID_PRODUCT_TEMPLATE));
        product.setIdStockMovement(resultSet.getInt(Product.ID_STOCK_MOVEMENT));
        return product;
    }
}

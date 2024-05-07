package com.example.stationmanagement.repository;

import com.example.stationmanagement.config.ConnectDatabase;
import com.example.stationmanagement.model.ProductTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductTemplateRepositoryImpl implements ProductTemplateRepository {

    private final ConnectDatabase connectDatabase = ConnectDatabase.getInstance();
    private final Connection connection = connectDatabase.getConnection();

    @Override
    public List<ProductTemplate> getAllProductTemplate() throws SQLException {
        List<ProductTemplate> productTemplates = new ArrayList<>();
        String query = "SELECT * FROM product_template";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ProductTemplate productTemplate = mapResultSetToProductTemplate(resultSet);
                productTemplates.add(productTemplate);
            }
        }
        return productTemplates;
    }

    @Override
    public ProductTemplate getProductTemplateById(int id) throws SQLException {
        String query = "SELECT * FROM product_template WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToProductTemplate(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public ProductTemplate createProductTemplate(ProductTemplate productTemplate) throws SQLException {
        String query = "INSERT INTO product_template (name, price, evaporation_rate_per_day, id_stock_view, id_stock_movement) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, productTemplate.getName());
            preparedStatement.setDouble(2, productTemplate.getPrice());
            preparedStatement.setDouble(3, productTemplate.getEvaporationRatePerDay());
            preparedStatement.setInt(4, productTemplate.getIdStockView());
            preparedStatement.setInt(5, productTemplate.getIdStockMovement());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        productTemplate.setId(generatedKeys.getInt(1));
                        return productTemplate;
                    } else {
                        throw new SQLException("Failed to retrieve generated ID.");
                    }
                }
            } else {
                throw new SQLException("Failed to insert product template into database.");
            }
        }
    }

    @Override
    public ProductTemplate updateProductTemplate(int id, ProductTemplate productTemplate) throws SQLException {
        String query = "UPDATE product_template SET name = ?, price = ?, evaporation_rate_per_day = ?, id_stock_view = ?, id_stock_movement = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, productTemplate.getName());
            preparedStatement.setDouble(2, productTemplate.getPrice());
            preparedStatement.setDouble(3, productTemplate.getEvaporationRatePerDay());
            preparedStatement.setInt(4, productTemplate.getIdStockView());
            preparedStatement.setInt(5, productTemplate.getIdStockMovement());
            preparedStatement.setInt(6, id);

            int updatedRows = preparedStatement.executeUpdate();
            if (updatedRows > 0) {
                return productTemplate;
            }
        }
        return null;
    }

    private ProductTemplate mapResultSetToProductTemplate(ResultSet resultSet) throws SQLException {
        ProductTemplate productTemplate = new ProductTemplate();
        productTemplate.setId(resultSet.getInt(ProductTemplate.ID));
        productTemplate.setName(resultSet.getString(ProductTemplate.NAME));
        productTemplate.setPrice(resultSet.getDouble(ProductTemplate.PRICE));
        productTemplate.setEvaporationRatePerDay(resultSet.getDouble(ProductTemplate.EVAPORATION_RATE_PER_DAY));
        productTemplate.setIdStockView(resultSet.getInt(ProductTemplate.ID_STOCK_VIEW));
        productTemplate.setIdStockMovement(resultSet.getInt(ProductTemplate.ID_STOCK_MOVEMENT));
        return productTemplate;
    }
}

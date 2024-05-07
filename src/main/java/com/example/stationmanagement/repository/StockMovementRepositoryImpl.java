package com.example.stationmanagement.repository;

import com.example.stationmanagement.config.ConnectDatabase;
import com.example.stationmanagement.model.StockMovement;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StockMovementRepositoryImpl implements StockMovementRepository {

    private final ConnectDatabase connectDatabase = ConnectDatabase.getInstance();
    private final Connection connection = connectDatabase.getConnection();

    @Override
    public List<StockMovement> getAllStockMovements() throws SQLException {
        List<StockMovement> stockMovements = new ArrayList<>();
        String query = "SELECT * FROM stock_movement";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                StockMovement stockMovement = mapResultSetToStockMovement(resultSet);
                stockMovements.add(stockMovement);
            }
        }
        return stockMovements;
    }

    @Override
    public StockMovement getStockMovementById(int id) throws SQLException {
        String query = "SELECT * FROM stock_movement WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToStockMovement(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public StockMovement createStockMovement(StockMovement stockMovement) throws SQLException {
        String query = "INSERT INTO stock_movements (date, type, quantity, id_stock_view) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setTimestamp(1, stockMovement.getDate());
            preparedStatement.setString(2, stockMovement.getType());
            preparedStatement.setDouble(3, stockMovement.getQuantity());
            preparedStatement.setInt(4, stockMovement.getIdStockView());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        stockMovement.setId(generatedKeys.getInt(1));
                        return stockMovement;
                    } else {
                        throw new SQLException("Failed to retrieve generated ID.");
                    }
                }
            } else {
                throw new SQLException("Failed to insert stock movement into database.");
            }
        }
    }

    @Override
    public StockMovement updateStockMovement(int id, StockMovement stockMovement) throws SQLException {
        String query = "UPDATE stock_movements SET date = ?, type = ?, quantity = ?, id_stock_view = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setTimestamp(1, stockMovement.getDate());
            preparedStatement.setString(2, stockMovement.getType());
            preparedStatement.setDouble(3, stockMovement.getQuantity());
            preparedStatement.setInt(4, stockMovement.getIdStockView());
            preparedStatement.setInt(5, id);

            int updatedRows = preparedStatement.executeUpdate();
            if (updatedRows > 0) {
                return stockMovement;
            }
        }
        return null;
    }

    private StockMovement mapResultSetToStockMovement(ResultSet resultSet) throws SQLException {
        StockMovement stockMovement = new StockMovement();
        stockMovement.setId(resultSet.getInt(StockMovement.ID));
        stockMovement.setDate(resultSet.getTimestamp(StockMovement.DATE));
        stockMovement.setType(resultSet.getString(StockMovement.TYPE));
        stockMovement.setQuantity(resultSet.getDouble(StockMovement.QUANTITY));
        stockMovement.setIdStockView(resultSet.getInt(StockMovement.ID_STOCK_VIEW));
        return stockMovement;
    }
}

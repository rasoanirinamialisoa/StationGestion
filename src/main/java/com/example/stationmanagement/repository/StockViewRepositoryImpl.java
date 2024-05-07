package com.example.stationmanagement.repository;

import com.example.stationmanagement.config.ConnectDatabase;
import com.example.stationmanagement.model.StockView;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StockViewRepositoryImpl implements StockViewRepository {

    private final ConnectDatabase connectDatabase = ConnectDatabase.getInstance();
    private final Connection connection = connectDatabase.getConnection();

    @Override
    public List<StockView> getAllStockViews() throws SQLException {
        List<StockView> stockViews = new ArrayList<>();
        String query = "SELECT * FROM stock_view";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                StockView stockView = mapResultSetToStockView(resultSet);
                stockViews.add(stockView);
            }
        }
        return stockViews;
    }

    @Override
    public StockView getStockViewById(int id) throws SQLException {
        String query = "SELECT * FROM stock_view WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToStockView(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public StockView createStockView(StockView stockView) throws SQLException {
        String query = "INSERT INTO stock_view (date, quantity_added, quantity_sold, remaining_quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setTimestamp(1, new Timestamp(stockView.getDate().getTime()));
            preparedStatement.setDouble(2, stockView.getQuantityAdded());
            preparedStatement.setDouble(3, stockView.getQuantitySold());
            preparedStatement.setDouble(4, stockView.getRemainingQuantity());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        stockView.setId(generatedKeys.getInt(1));
                        return stockView;
                    } else {
                        throw new SQLException("Failed to retrieve generated ID.");
                    }
                }
            } else {
                throw new SQLException("Failed to insert stock view into database.");
            }
        }
    }

    @Override
    public StockView updateStockView(int id, StockView stockView) throws SQLException {
        String query = "UPDATE stock_view SET date = ?, quantity_added = ?, quantity_sold = ?, remaining_quantity = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setTimestamp(1, new Timestamp(stockView.getDate().getTime()));
            preparedStatement.setDouble(2, stockView.getQuantityAdded());
            preparedStatement.setDouble(3, stockView.getQuantitySold());
            preparedStatement.setDouble(4, stockView.getRemainingQuantity());
            preparedStatement.setInt(5, id);

            int updatedRows = preparedStatement.executeUpdate();
            if (updatedRows > 0) {
                return stockView;
            }
        }
        return null;
    }


    private StockView mapResultSetToStockView(ResultSet resultSet) throws SQLException {
        StockView stockView = new StockView();
        stockView.setId(resultSet.getInt(StockView.ID));
        stockView.setDate(resultSet.getTimestamp(StockView.DATE));
        stockView.setQuantityAdded(resultSet.getDouble(StockView.QUANTITY_ADDED));
        stockView.setQuantitySold(resultSet.getDouble(StockView.QUANTITY_SOLD));
        stockView.setRemainingQuantity(resultSet.getDouble(StockView.REMAINING_QUANTITY));
        return stockView;
    }
}

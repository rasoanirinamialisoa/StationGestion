package com.example.stationmanagement.service;

import com.example.stationmanagement.model.StockMovement;

import java.sql.SQLException;
import java.util.List;

public interface StockMovementService {
    List<StockMovement> getAllStockMovements() throws SQLException;
    StockMovement getStockMovementById(int id) throws SQLException;
    StockMovement createStockMovement(StockMovement stockMovement) throws SQLException;
    StockMovement updateStockMovement(int id, StockMovement stockMovement) throws SQLException;
}

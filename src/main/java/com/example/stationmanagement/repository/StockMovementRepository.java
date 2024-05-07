package com.example.stationmanagement.repository;
import com.example.stationmanagement.model.StockMovement;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface StockMovementRepository {
    List<StockMovement> getAllStockMovements() throws SQLException;
    StockMovement getStockMovementById(int id) throws SQLException;
    StockMovement createStockMovement(StockMovement stockMovement) throws SQLException;
    StockMovement updateStockMovement(int id, StockMovement stockMovement) throws SQLException;
}

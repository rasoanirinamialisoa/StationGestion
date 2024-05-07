package com.example.stationmanagement.service;

import com.example.stationmanagement.model.StockMovement;
import com.example.stationmanagement.repository.StockMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StockMovementServiceImpl implements StockMovementService {

    private final StockMovementRepository stockMovementRepository;

    @Autowired
    public StockMovementServiceImpl(StockMovementRepository stockMovementRepository) {
        this.stockMovementRepository = stockMovementRepository;
    }

    @Override
    public List<StockMovement> getAllStockMovements() throws SQLException {
        return stockMovementRepository.getAllStockMovements();
    }

    @Override
    public StockMovement getStockMovementById(int id) throws SQLException {
        return stockMovementRepository.getStockMovementById(id);
    }

    @Override
    public StockMovement createStockMovement(StockMovement stockMovement) throws SQLException {
        return stockMovementRepository.createStockMovement(stockMovement);
    }

    @Override
    public StockMovement updateStockMovement(int id, StockMovement stockMovement) throws SQLException {
        return stockMovementRepository.updateStockMovement(id, stockMovement);
    }
}

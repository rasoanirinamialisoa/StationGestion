package com.example.stationmanagement.controller;

import com.example.stationmanagement.model.StockMovement;
import com.example.stationmanagement.service.StockMovementService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StockMovementController {

    private final StockMovementService stockMovementService;

    public StockMovementController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    @GetMapping("/stock-movement")
    public List<StockMovement> getAllStockMovements() throws SQLException {
        return stockMovementService.getAllStockMovements();
    }

    @GetMapping("/stock-movement/{id}")
    public StockMovement getStockMovementById(@PathVariable int id) throws SQLException {
        return stockMovementService.getStockMovementById(id);
    }

    @PostMapping("/stock-movement")
    public StockMovement createStockMovement(@RequestBody StockMovement stockMovement) throws SQLException {
        return stockMovementService.createStockMovement(stockMovement);
    }

    @PutMapping("/stock-movement/{id}")
    public StockMovement updateStockMovement(@PathVariable int id, @RequestBody StockMovement stockMovement) throws SQLException {
        return stockMovementService.updateStockMovement(id, stockMovement);
    }
}

package com.example.stationmanagement.controller;

import com.example.stationmanagement.model.StockView;
import com.example.stationmanagement.service.StockViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StockViewController {

    private final StockViewService stockViewService;

    @Autowired
    public StockViewController(StockViewService stockViewService) {
        this.stockViewService = stockViewService;
    }

    @GetMapping("/stock-view")
    public List<StockView> getAllStockViews() throws SQLException {
        return stockViewService.getAllStockView();
    }

    @GetMapping("/stock-view/{id}")
    public StockView getStockViewById(@PathVariable int id) throws SQLException {
        return stockViewService.getStockViewById(id);
    }

    @PostMapping("/stock-view")
    public StockView createStockView(@RequestBody StockView stockView) throws SQLException {
        return stockViewService.createStockView(stockView);
    }

    @PutMapping("/stock-view/{id}")
    public StockView updateStockView(@PathVariable int id, @RequestBody StockView stockView) throws SQLException {
        return stockViewService.updateStockView(id, stockView);
    }
}


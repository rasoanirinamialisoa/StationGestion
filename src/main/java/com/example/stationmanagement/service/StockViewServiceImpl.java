package com.example.stationmanagement.service;

import com.example.stationmanagement.model.StockView;
import com.example.stationmanagement.repository.StockViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class StockViewServiceImpl implements StockViewService{

    @Autowired
    private final StockViewRepository stockViewRepository;

    public StockViewServiceImpl(StockViewRepository stockViewRepository) {
        this.stockViewRepository = stockViewRepository;
    }

    @Override
    public List<StockView> getAllStockView() throws SQLException {
        return stockViewRepository.getAllStockViews();
    }

    @Override
    public StockView getStockViewById(int id) throws SQLException {
        return stockViewRepository.getStockViewById(id);
    }

    @Override
    public StockView createStockView(StockView stockView) throws SQLException {
        return stockViewRepository.createStockView(stockView);
    }

    @Override
    public StockView updateStockView(int id, StockView stockView) throws SQLException {
        return stockViewRepository.updateStockView(id, stockView);
    }
}

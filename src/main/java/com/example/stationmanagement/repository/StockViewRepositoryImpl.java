package com.example.stationmanagement.repository;

import com.example.stationmanagement.model.StockView;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository

public class StockViewRepositoryImpl implements StockViewRepository{
    @Override
    public List<StockView> getAllStockViews() throws SQLException {
        return null;
    }

    @Override
    public StockView getStockViewById(int id) throws SQLException {
        return null;
    }

    @Override
    public StockView createStockView(StockView stockView) throws SQLException {
        return null;
    }

    @Override
    public StockView updateStockView(int id, StockView stockView) throws SQLException {
        return null;
    }
}

package com.example.stationmanagement.repository;

import com.example.stationmanagement.model.StockView;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository
public interface StockViewRepository {
    List<StockView> getAllStockViews() throws SQLException;
    StockView getStockViewById(int id) throws SQLException;
    StockView createStockView(StockView stockView) throws SQLException;
    StockView updateStockView(int id, StockView stockView) throws SQLException;

}
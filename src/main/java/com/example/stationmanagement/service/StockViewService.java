package com.example.stationmanagement.service;
import com.example.stationmanagement.model.StockView;
import java.sql.SQLException;
import java.util.List;

public interface StockViewService {
        List<StockView> getAllStockView() throws SQLException;
        StockView getStockViewById(int id) throws SQLException;
        StockView createStockView(StockView stockView) throws SQLException;
        StockView updateStockView(int id, StockView stockView) throws SQLException;
}

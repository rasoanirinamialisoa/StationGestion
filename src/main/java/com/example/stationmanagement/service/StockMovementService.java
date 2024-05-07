package com.example.stationmanagement.service;

import com.example.stationmanagement.model.StockMouvement;

import java.sql.SQLException;
import java.util.List;

public interface StockMouvementService {
    List<StockMouvement> getAllStockMouvements() throws SQLException;
    StockMouvement getStockMouvementById(int id) throws SQLException;
    StockMouvement createStockMouvement(StockMouvement stockMouvement) throws SQLException;
    StockMouvement updateStockMouvement(int id, StockMouvement stockMouvement) throws SQLException;
}

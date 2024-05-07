package com.example.stationmanagement.repository;
import com.example.stationmanagement.model.StockMouvement;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface StockMouvementRepository {
    List<StockMouvement> getAllStockMouvements() throws SQLException;
    StockMouvement getStockMouvementById(int id) throws SQLException;
    StockMouvement createStockMouvement(StockMouvement stockMouvement) throws SQLException;
    StockMouvement updateStockMouvement(int id, StockMouvement stockMouvement) throws SQLException;
}

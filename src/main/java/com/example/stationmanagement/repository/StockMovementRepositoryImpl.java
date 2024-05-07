package com.example.stationmanagement.repository;

import com.example.stationmanagement.model.StockMouvement;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class StockMouvementRepositoryImpl implements StockMouvementRepository{
    @Override
    public List<StockMouvement> getAllStockMouvements() throws SQLException {
        return null;
    }

    @Override
    public StockMouvement getStockMouvementById(int id) throws SQLException {
        return null;
    }

    @Override
    public StockMouvement createStockMouvement(StockMouvement stockMouvement) throws SQLException {
        return null;
    }

    @Override
    public StockMouvement updateStockMouvement(int id, StockMouvement stockMouvement) throws SQLException {
        return null;
    }
}

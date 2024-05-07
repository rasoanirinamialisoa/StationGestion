package com.example.stationmanagement.service;

import com.example.stationmanagement.model.StockMouvement;
import com.example.stationmanagement.repository.StockMouvementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class StockMouvementServiceImpl implements StockMouvementService{

    @Autowired
    private final StockMouvementRepository stockMouvementRepository;

    public StockMouvementServiceImpl(StockMouvementRepository stockMouvementRepository) {
        this.stockMouvementRepository = stockMouvementRepository;
    }

    @Override
    public List<StockMouvement> getAllStockMouvements() throws SQLException {
        return stockMouvementRepository.getAllStockMouvements();
    }

    @Override
    public StockMouvement getStockMouvementById(int id) throws SQLException {
        return stockMouvementRepository.getStockMouvementById(id);
    }

    @Override
    public StockMouvement createStockMouvement(StockMouvement stockMouvement) throws SQLException {
        return stockMouvementRepository.createStockMouvement(stockMouvement);
    }

    @Override
    public StockMouvement updateStockMouvement(int id, StockMouvement stockMouvement) throws SQLException {
        return stockMouvementRepository.updateStockMouvement(id, stockMouvement);
    }
}

package com.example.stationmanagement.repository;

import com.example.stationmanagement.model.ProductTemplate;
import com.example.stationmanagement.model.StockView;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface ProductTemplateRepository {
    List<ProductTemplate> getAllProductTemplate() throws SQLException;
    ProductTemplate getProductTemplateById(int id) throws SQLException;
    ProductTemplate createProductTemplate(ProductTemplate productTemplate) throws SQLException;
    ProductTemplate updateProductTemplate(int id, ProductTemplate productTemplate) throws SQLException;

    void updateRemainingQuantity(int id, double newRemainingQuantity);
}

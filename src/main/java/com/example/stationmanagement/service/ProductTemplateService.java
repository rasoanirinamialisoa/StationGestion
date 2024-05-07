package com.example.stationmanagement.service;

import com.example.stationmanagement.model.ProductTemplate;

import java.sql.SQLException;
import java.util.List;

public interface ProductTemplateService {
    List<ProductTemplate> getAllProductTemplate() throws SQLException;
    ProductTemplate getProductTemplateById(int id) throws  SQLException;
    ProductTemplate createProductTemplate(ProductTemplate productTemplate) throws SQLException;
    ProductTemplate updateProductTemplate(int id, ProductTemplate productTemplate) throws SQLException;
}

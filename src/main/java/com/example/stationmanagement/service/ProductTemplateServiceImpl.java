package com.example.stationmanagement.service;

import com.example.stationmanagement.model.ProductTemplate;
import com.example.stationmanagement.repository.ProductTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductTemplateServiceImpl implements ProductTemplateService{

    @Autowired
    private final ProductTemplateRepository productTemplateRepository;

    public ProductTemplateServiceImpl(ProductTemplateRepository productTemplateRepository) {
        this.productTemplateRepository = productTemplateRepository;
    }

    @Override
    public List<ProductTemplate> getAllProductTemplate() throws SQLException {
        return productTemplateRepository.getAllProductTemplate();
    }

    @Override
    public ProductTemplate getProductTemplateById(int id) throws SQLException {
        return productTemplateRepository.getProductTemplateById(id);
    }

    @Override
    public ProductTemplate createProductTemplate(ProductTemplate productTemplate) throws SQLException {
        return productTemplateRepository.createProductTemplate(productTemplate);
    }

    @Override
    public ProductTemplate updateProductTemplate(int id, ProductTemplate productTemplate) throws SQLException {
        return productTemplateRepository.updateProductTemplate(id, productTemplate);
    }

    @Override
    public void updateRemainingQuantity(int id, double newRemainingQuantity) {
        productTemplateRepository.updateRemainingQuantity(id, newRemainingQuantity);
    }


}

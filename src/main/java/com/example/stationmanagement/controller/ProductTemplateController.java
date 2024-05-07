package com.example.stationmanagement.controller;

import com.example.stationmanagement.model.ProductTemplate;
import com.example.stationmanagement.service.ProductTemplateService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductTemplateController {

    private final ProductTemplateService productTemplateService;

    public ProductTemplateController(ProductTemplateService productTemplateService) {
        this.productTemplateService = productTemplateService;
    }

    @GetMapping("/product-template")
    public List<ProductTemplate> getAllProductTemplates() throws SQLException {
        return productTemplateService.getAllProductTemplate();
    }

    @GetMapping("/product-template/{id}")
    public ProductTemplate getProductTemplateById(@PathVariable int id) throws SQLException {
        return productTemplateService.getProductTemplateById(id);
    }

    @PostMapping("/product-template")
    public ProductTemplate createProductTemplate(@RequestBody ProductTemplate productTemplate) throws SQLException {
        return productTemplateService.createProductTemplate(productTemplate);
    }

    @PutMapping("/product-template/{id}")
    public ProductTemplate updateProductTemplate(@PathVariable int id, @RequestBody ProductTemplate productTemplate) throws SQLException {
        return productTemplateService.updateProductTemplate(id, productTemplate);
    }
}

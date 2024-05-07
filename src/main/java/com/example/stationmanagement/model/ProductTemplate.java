package com.example.stationmanagement.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductTemplate {
    private int id;
    private String name;
    private double price;
    private double evaporationRatePerDay;
    private int idStockView;
    private int idStockMouvement;

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String EVAPORATION_RATE_PER_DAY = "evaporationRatePerDay";
    public static final String ID_STOCK_VIEW = "idStockView";
    public static final String ID_STOCK_MOUVEMENT = "idStockMouvement";
}


package com.example.stationmanagement.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    private int id;
    private int idStation;
    private int idProductTemplate;
    private int idStockMovement;

    public static final String ID = "id";
    public static final String ID_STATION = "id_station";
    public static final String ID_PRODUCT_TEMPLATE = "id_product_template";
    public static final String ID_STOCK_MOVEMENT = "id_stock_movement";
}

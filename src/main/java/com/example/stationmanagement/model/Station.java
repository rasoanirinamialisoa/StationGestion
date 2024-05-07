package com.example.stationmanagement.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Station {
    private int id;
    private String name;
    private String address;
    private String listProduct;
    private int idStockMovement;

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String LIST_PRODUCT = "list_product";
    public static final String ID_STOCK_MOVEMENT = "id_stock_movement";
}

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

    public static final String ID = "id";
    public static final String ID_STATION = "idStation";
    public static final String ID_PRODUCT_TEMPLATE = "idProductTemplate";
}

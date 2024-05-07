package com.example.stationmanagement.model;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StockMouvement {
    private int id;
    private Timestamp date;
    private String type;
    private double quantity;
    private int idStockView;

    public static final String ID = "id";
    public static final String DATE = "date";
    public static final String TYPE = "type";
    public static final String QUANTITY = "quantity";
    public static final String ID_STOCK_VIEW = "idStockView";
}


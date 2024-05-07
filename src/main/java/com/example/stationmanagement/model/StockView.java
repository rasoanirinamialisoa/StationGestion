package com.example.stationmanagement.model;

import lombok.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StockView {
    private int id;
    private Timestamp date;
    private double quantityAdded;
    private double quantitySold;
    private double remainingQuantity;

    public static final String ID = "id";
    public static final String DATE = "date";
    public static final String QUANTITY_ADDED = "quantity_added";
    public static final String QUANTITY_SOLD = "quantity_sold";
    public static final String REMAINING_QUANTITY = "remaining_quantity";
}

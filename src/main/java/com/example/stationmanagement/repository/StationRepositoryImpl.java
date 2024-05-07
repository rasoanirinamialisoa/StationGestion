package com.example.stationmanagement.repository;

import com.example.stationmanagement.config.ConnectDatabase;
import com.example.stationmanagement.model.Station;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StationRepositoryImpl implements StationRepository {

    private final ConnectDatabase connectDatabase = ConnectDatabase.getInstance();
    private final Connection connection = connectDatabase.getConnection();

    @Override
    public List<Station> getAllStation() throws SQLException {
        List<Station> stations = new ArrayList<>();
        String query = "SELECT * FROM station";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Station station = mapResultSetToStation(resultSet);
                stations.add(station);
            }
        }
        return stations;
    }

    @Override
    public Station getStationById(int id) throws SQLException {
        String query = "SELECT * FROM station WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToStation(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Station createStation(Station station) throws SQLException {
        String query = "INSERT INTO station (name, address, list_product, id_stock_movement) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, station.getName());
            preparedStatement.setString(2, station.getAddress());
            preparedStatement.setString(3, station.getListProduct());
            preparedStatement.setInt(4, station.getIdStockMovement());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        station.setId(generatedKeys.getInt(1));
                        return station;
                    } else {
                        throw new SQLException("Failed to retrieve generated ID.");
                    }
                }
            } else {
                throw new SQLException("Failed to insert station into database.");
            }
        }
    }

    @Override
    public Station updateStation(int id, Station station) throws SQLException {
        String query = "UPDATE station SET name = ?, address = ?, list_product = ?, id_stock_movement = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, station.getName());
            preparedStatement.setString(2, station.getAddress());
            preparedStatement.setString(3, station.getListProduct());
            preparedStatement.setInt(4, station.getIdStockMovement());
            preparedStatement.setInt(5, id);

            int updatedRows = preparedStatement.executeUpdate();
            if (updatedRows > 0) {
                return station;
            }
        }
        return null;
    }

    private Station mapResultSetToStation(ResultSet resultSet) throws SQLException {
        Station station = new Station();
        station.setId(resultSet.getInt(Station.ID));
        station.setName(resultSet.getString(Station.NAME));
        station.setAddress(resultSet.getString(Station.ADDRESS));
        station.setListProduct(resultSet.getString(Station.LIST_PRODUCT));
        station.setIdStockMovement(resultSet.getInt(Station.ID_STOCK_MOVEMENT));
        return station;
    }
}

package com.example.stationmanagement.repository;

import com.example.stationmanagement.model.Station;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class StationRepositoryImpl implements StationRepository{
    @Override
    public List<Station> getAllStockMouvements() throws SQLException {
        return null;
    }

    @Override
    public Station getStationById(int id) throws SQLException {
        return null;
    }

    @Override
    public Station createStation(Station station) throws SQLException {
        return null;
    }

    @Override
    public Station updateStation(int id, Station station) throws SQLException {
        return null;
    }
}

package com.example.stationmanagement.repository;

import com.example.stationmanagement.model.Station;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository
public interface StationRepository {
    List<Station> getAllStation() throws SQLException;
    Station getStationById(int id) throws SQLException;
    Station createStation (Station station) throws SQLException;
    Station updateStation (int id, Station station) throws SQLException;
}

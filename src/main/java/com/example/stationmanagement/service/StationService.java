package com.example.stationmanagement.service;

import com.example.stationmanagement.model.Station;

import java.sql.SQLException;
import java.util.List;

public interface StationService {
    List<Station> getAllStation() throws SQLException;
    Station getStationById(int id) throws SQLException;
    Station createStation(Station station) throws SQLException;
    Station updateStation(int id, Station station) throws SQLException;
}

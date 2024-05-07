package com.example.stationmanagement.service;

import com.example.stationmanagement.model.Station;
import com.example.stationmanagement.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class StationServiceImpl implements StationService{
    @Autowired
    private final StationRepository stationRepository;

    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public List<Station> getAllStation() throws SQLException {
        return stationRepository.getAllStation();
    }

    @Override
    public Station getStationById(int id) throws SQLException {
        return stationRepository.getStationById(id);
    }

    @Override
    public Station createStation(Station station) throws SQLException {
        return stationRepository.createStation(station);
    }

    @Override
    public Station updateStation(int id, Station station) throws SQLException {
        return stationRepository.updateStation(id, station);
    }
}

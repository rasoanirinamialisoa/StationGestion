package com.example.stationmanagement.controller;

import com.example.stationmanagement.model.Station;
import com.example.stationmanagement.service.StationService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("/station")
    public List<Station> getAllStations() throws SQLException {
        return stationService.getAllStation();
    }

    @GetMapping("/station/{id}")
    public Station getStationById(@PathVariable int id) throws SQLException {
        return stationService.getStationById(id);
    }

    @PostMapping("/station")
    public Station createStation(@RequestBody Station station) throws SQLException {
        return stationService.createStation(station);
    }

    @PutMapping("/station/{id}")
    public Station updateStation(@PathVariable int id, @RequestBody Station station) throws SQLException {
        return stationService.updateStation(id, station);
    }
}

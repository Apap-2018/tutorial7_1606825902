package com.apap.tutorial7.controller;

import java.sql.Date;

import java.util.List;



import com.apap.tutorial7.model.FlightModel;

import com.apap.tutorial7.service.FlightService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

/**
 * FlightController
 */
@RestController
@RequestMapping("/flight")
public class FlightController{
    @Autowired
    private FlightService flightService;
    
    @PostMapping(value="/add")
    public FlightModel addFlightSubmit(@RequestBody FlightModel flight) {
    	return flightService.addFlight(flight);
    }
    
    @PutMapping(value="/update/{flightId}")
    public String updateFlightSubmit(@PathVariable("flightId") long flightId,
    		@RequestParam("destination") String destination,
    		@RequestParam("origin") String origin,
    		@RequestParam("time") Date time) {
    	
    	FlightModel flight = flightService.getFlightById(flightId);
    	if(flight.equals(null)) {
    		return "Couldn't find your flight";
    	}
    	flight.setOrigin(origin);
    	flight.setDestination(destination);
    	flight.setTime(time);
    	flightService.updateFlight(flightId, flight);
    	return "fligt update success";
    }
    
    @GetMapping(value="/view/{flightNumber}")
    public FlightModel flightView(@PathVariable("flightNumber") String flightNumber) {
    	FlightModel flight = flightService.getFlightDetailByFlightNumber(flightNumber).get();
    	return flight;
    }
    
    @GetMapping(value="/all")
    public List<FlightModel> viewAll(){
    	return flightService.getAllFlight();
    }
    
    @DeleteMapping(value="/delete/{flightId}")
    public String deleteFlight(@PathVariable("flightId") long flightId) {
    	FlightModel flight = flightService.getFlightById(flightId);
    	if(flight.equals(null)) {
    		return "Couldn't find your flight";
    	}
    	flightService.deleteFlight(flight);
    	return "flight has been deleted";
    }
}
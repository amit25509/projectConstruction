package com.project1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.project1.model.Locations;


public interface LocationService {

	public List<Locations> getAllLocation();
	public Optional<Locations> getLocationById(int locationid);
	public Locations addLocation(Locations loc);
	public ResponseEntity<Locations> updateLocation(Integer id, Locations loc);
	public boolean deleteLocation(int id);
}

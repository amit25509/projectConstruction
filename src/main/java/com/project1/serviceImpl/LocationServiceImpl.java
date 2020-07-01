package com.project1.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project1.model.Locations;
import com.project1.repository.LocationsRepository;
import com.project1.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	LocationsRepository locationsRepository;
	
	@Override
	public List<Locations> getAllLocation() {
		// TODO Auto-generated method stub
		return locationsRepository.findAll();
	}

	@Override
	public Optional<Locations> getLocationById(int id) {
		// TODO Auto-generated method stub
		return locationsRepository.findById(id);
	}

	@Override
	public Locations addLocation(Locations loc) {
		// TODO Auto-generated method stub
		Locations location = locationsRepository
		.save(new Locations(
		loc.getLocationId(),
		loc.getLocationName()));
		return location;  
	}


	@Override
	public ResponseEntity<Locations> updateLocation(Integer id, Locations updateLocation) {
		// TODO Auto-generated method stub
		Optional<Locations> existingLocations = locationsRepository.findById(id);

		if (existingLocations.isPresent()) {
			Locations tempLocation = existingLocations.get();
			tempLocation.setLocationName(updateLocation.getLocationName());

			return new ResponseEntity<>(locationsRepository.save(tempLocation), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@Override
	public boolean deleteLocation(int locationid) {
		// TODO Auto-generated method stub
		locationsRepository.deleteById(locationid);
		return false;
	}

}

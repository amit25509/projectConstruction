package com.project1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1.model.Locations;
import com.project1.service.LocationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LocationsController {

	@Autowired
	LocationService locationService;

	
	//1. GET ALL LOCATIONS
	
	@GetMapping("/getalllocations")
	public ResponseEntity<List<Locations>> getAlllocation() {
		try {
			List<Locations> location = locationService.getAllLocation();
//				System.out.println(location.isEmpty());

			if (location.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(location, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//2. GET LOCATION BY ID
	@GetMapping("/location/{id}")
	public ResponseEntity<Locations> getlocationById(@PathVariable("id") Integer id) {
		Optional<Locations> location = locationService.getLocationById(id);

		if (location.isPresent()) {
			return new ResponseEntity<>(location.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	//3. ADD NEW LOCATION
	
	@PostMapping("/addlocation")
	public ResponseEntity<Locations> addLocation(@RequestBody Locations loc) {

		try {
			Locations location = locationService.addLocation(loc);

			return new ResponseEntity<>(location, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}


	//4. UPDATE LOCATION BY ID
	
	@PutMapping("/updatelocation/{id}")
	public ResponseEntity<Locations> updateUsers(@PathVariable("id") Integer id, @RequestBody Locations updateLocation) {
		
		return locationService.updateLocation(id, updateLocation);
		
	}
	

	//5. DELETE LOCATION BY ID
	
	@DeleteMapping("/deletelocation/{id}")
	private ResponseEntity<HttpStatus> deleteLocation(@PathVariable("id") Integer id) {
		try {
			locationService.deleteLocation(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

}

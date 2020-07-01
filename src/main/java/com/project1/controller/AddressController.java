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

import com.project1.model.Address;
import com.project1.service.AddressService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AddressController {

	@Autowired
	AddressService addressService;

	
	//1. GET ALL ADDRESS
	@GetMapping("/getalladdress")
	public ResponseEntity<List<Address>> getAllAddress() {
		try {
			List<Address> address = addressService.getAllAddress();
//				System.out.println(address.isEmpty());

			if (address.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(address, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

//2. GET ADDRESS BY ID
	
	@GetMapping("/address/{addid}")
	public ResponseEntity<Address> getAddressById(@PathVariable("addid") Integer addid) {
		Optional<Address> address = addressService.getAddressById(addid);

		if (address.isPresent()) {
			return new ResponseEntity<>(address.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	//3. ADD ADDRESS
	@PostMapping("/addaddress")
	public ResponseEntity<Address> addAddress(@RequestBody Address new_address) {
		try {
			Address address = addressService.addAddress(new_address);

			return new ResponseEntity<>(address, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	
	
	//4. UPDATE ADDRESS BY ID
	
	@PutMapping("/updateaddress/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable("id") Integer id, @RequestBody Address updateAddress) {
		
		return addressService.updateAddress(id, updateAddress);
		
	}

	
	//5. DELETE ADDRESS BY ID
	
	@DeleteMapping("/deleteaddress/{id}")
	private ResponseEntity<HttpStatus> deleteAddress(@PathVariable("id") int id) {
		try {
			addressService.deleteAddress(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}

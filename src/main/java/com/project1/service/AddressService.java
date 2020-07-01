package com.project1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.project1.model.Address;

public interface AddressService {

	public List<Address> getAllAddress();
	public Optional<Address> getAddressById(int id);
	public Address addAddress(Address add);
	public ResponseEntity<Address> updateAddress(Integer id,Address updateAddress);
	public boolean deleteAddress(int addid);
}

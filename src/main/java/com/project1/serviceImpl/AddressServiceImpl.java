package com.project1.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project1.model.Address;
import com.project1.repository.AddressRepository;
import com.project1.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public List<Address> getAllAddress() {
		// TODO Auto-generated method stub
		return addressRepository.findAll();
	}

	//getAddressById
	@Override
	public Optional<Address> getAddressById(int id) {
		// TODO Auto-generated method stub
		return addressRepository.findById(id);
	}

	@Override
	public Address addAddress(Address add) {
		// TODO Auto-generated method stub
		Address address= addressRepository.save(new Address(
				add.getBuildingName(),
				add.getCity(),
				add.getPostalCode(),
				add.getState(),
				add.getStreet())
				);
		return address;
	}

	@Override
	public ResponseEntity<Address> updateAddress(Integer id, Address updateAddress) {
		Optional<Address> existingAddress = addressRepository.findById(id);

		if (existingAddress.isPresent()) {
			Address tempAddress = existingAddress.get();
			tempAddress.setBuildingName(updateAddress.getBuildingName());
			tempAddress.setStreet(updateAddress.getStreet());
			tempAddress.setCity(updateAddress.getCity());
			tempAddress.setState(updateAddress.getCity());
			tempAddress.setPostalCode(updateAddress.getPostalCode());

			return new ResponseEntity<>(addressRepository.save(tempAddress), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public boolean deleteAddress(int addid) {
		// TODO Auto-generated method stub
		addressRepository.deleteById(addid);
		return false;
	}


}

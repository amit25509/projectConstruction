package com.project1.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project1.model.Commissions;
import com.project1.repository.CommissionsRepository;
import com.project1.service.CommissionsService;

@Service
public class CommissionsServiceImpl implements CommissionsService {

	@Autowired
	CommissionsRepository commissionsRepository;
	
	@Override
	public List<Commissions> getAllCommissions() {
		// TODO Auto-generated method stub
		return commissionsRepository.findAll();
	}

	@Override
	public Optional<Commissions> getCommissionsById(int id) {
		// TODO Auto-generated method stub
		return commissionsRepository.findById(id);
	}

	@Override
	public Commissions addCommissions(Commissions add) {
		// TODO Auto-generated method stub
		Commissions newComissions=commissionsRepository.save(new Commissions(
				add.getBookingId(),
				add.getTotalCommissionAmount(),
				add.getDueCommissionAmount(),
				add.getCommissionStatus()
				));
		return newComissions;
	}

	@Override
	public ResponseEntity<Commissions> updateCommissions(Integer id, Commissions newUpdateCommissions) {
		Optional<Commissions> existningCommissions = commissionsRepository.findById(id);

		if (existningCommissions.isPresent()) {
			Commissions tempCommissions = existningCommissions.get();
			tempCommissions.setBookingId(newUpdateCommissions.getBookingId());
			tempCommissions.setCommissionStatus(newUpdateCommissions.getCommissionStatus());
			tempCommissions.setTotalCommissionAmount(newUpdateCommissions.getDueCommissionAmount());
			tempCommissions.setDueCommissionAmount(newUpdateCommissions.getDueCommissionAmount());

			return new ResponseEntity<>(commissionsRepository.save(tempCommissions), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public boolean deleteCommissions(int id) {
		// TODO Auto-generated method stub
		commissionsRepository.deleteById(id);
		return false;
	}

}

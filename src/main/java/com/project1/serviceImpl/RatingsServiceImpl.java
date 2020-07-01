package com.project1.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.model.Ratings;
import com.project1.repository.RatingsRepository;
import com.project1.service.RatingsService;

@Service
public class RatingsServiceImpl implements RatingsService{

	@Autowired
	RatingsRepository ratingsRepository;
	
	@Override
	public List<Ratings> getAllRatings() {
		// TODO Auto-generated method stub
		return ratingsRepository.findAll();
	}

	@Override
	public Optional<Ratings> getRatingsById(int id) {
		// TODO Auto-generated method stub
		return ratingsRepository.findById(id);
	}

	@Override
	public Ratings addRatings(Ratings add) {
		// TODO Auto-generated method stub
		Ratings ratings=ratingsRepository.save(new Ratings(
				add.getRating(),
				add.getUserId(),
				add.getEmployeeId()
				));
		return ratings;
	}

}

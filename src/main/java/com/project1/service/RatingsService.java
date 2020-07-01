package com.project1.service;

import java.util.List;
import java.util.Optional;

import com.project1.model.Ratings;

public interface RatingsService {

	public List<Ratings> getAllRatings();
	public Optional<Ratings> getRatingsById(int id);
	public Ratings addRatings(Ratings add);
}

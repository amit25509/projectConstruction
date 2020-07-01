package com.project1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.project1.model.Commissions;

public interface CommissionsService {

	public List<Commissions> getAllCommissions();
	public Optional<Commissions> getCommissionsById(int id);
	public Commissions addCommissions(Commissions add);
	public ResponseEntity<Commissions> updateCommissions(Integer id, Commissions newUpdateCommissions);
	public boolean deleteCommissions(int id);
}

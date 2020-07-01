package com.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project1.model.Bookings;



@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Integer> 
{

}
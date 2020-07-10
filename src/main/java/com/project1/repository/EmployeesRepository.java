package com.project1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project1.model.Employees;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer>
{
	Optional<Employees> findByPhone(Long phone);
	
}
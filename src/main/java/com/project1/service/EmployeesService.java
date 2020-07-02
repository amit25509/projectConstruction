package com.project1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.project1.model.Employees;

public interface EmployeesService {

	public List<Employees> getAllEmployees();
	public Optional<Employees> getEmployeesById(int id);
	public Employees addEmployees(Employees employee);
	public ResponseEntity<Employees> updateEmployees(Integer id, Employees updateEmployee);
	public boolean deleteEmployees(int id);
}

package com.project1.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project1.model.Employees;
import com.project1.repository.EmployeesRepository;
import com.project1.service.EmployeesService;

@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	EmployeesRepository employeesRepository;

	@Override
	public List<Employees> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeesRepository.findAll();
	}

	@Override
	public Optional<Employees> getEmployeesById(int id) {
		// TODO Auto-generated method stub
		return employeesRepository.findById(id);
	}

	@Override
	public Employees addEmployees(Employees employee) {
		// TODO Auto-generated method stub
		Employees emp = employeesRepository.save(new Employees(
				employee.getName(), 
				employee.getPhone(), 
				employee.getEmail(), 
				employee.getAge(), 
				employee.getExperience(),
				employee.getCommissionRate(),
				employee.isVerified(),
				employee.getOccupation(), 
				employee.getPassword(), 
				employee.getImage(), 
				employee.isAvailability(),
				employee.getJobStartDate(), 
				employee.getAadharFront(), 
				employee.getAadharBack(),
				employee.getLocationId(),
				employee.getAddressId()));
		System.out.println(employee.getCommissionRate());
		return emp;
	}

	@Override
	public ResponseEntity<Employees> updateEmployees(Integer id, Employees updateEmployee) {
		// TODO Auto-generated method stub
		Optional<Employees> existingEmployees = employeesRepository.findById(id);

		if (existingEmployees.isPresent()) {
			Employees tempEmployee = existingEmployees.get();
			tempEmployee.setName(updateEmployee.getName());
			tempEmployee.setPhone(updateEmployee.getPhone());
			tempEmployee.setEmail(updateEmployee.getEmail());
			tempEmployee.setAge(updateEmployee.getAge());
			tempEmployee.setExperience(updateEmployee.getExperience());
			tempEmployee.setVerified(updateEmployee.isVerified());
			tempEmployee.setOccupation(updateEmployee.getOccupation());
			tempEmployee.setPassword(updateEmployee.getPassword());
			tempEmployee.setImage(updateEmployee.getImage());
			tempEmployee.setAvailability(updateEmployee.isAvailability());
			tempEmployee.setJobStartDate(updateEmployee.getJobStartDate());
			tempEmployee.setAadharFront(updateEmployee.getAadharFront());
			tempEmployee.setAadharBack(updateEmployee.getAadharBack());
			tempEmployee.setCommissionRate(updateEmployee.getCommissionRate());
			tempEmployee.setLocationId(updateEmployee.getLocationId());

			return new ResponseEntity<>(employeesRepository.save(tempEmployee), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public boolean deleteEmployees(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Employees registerEmployees(Employees employee) {
		// TODO Auto-generated method stub
		System.out.println(employee.getName());
//		Employees emp = employeesRepository.save(new Employees(
//				employee.getName(), 
//				employee.getPhone(), 
//				employee.getEmail(), 
//				employee.getAge(), 
//				employee.getExperience(),
//				employee.getOccupation(), 
//				employee.getPassword(), 
//				employee.getImage(),
//				employee.getAadharFront(), 
//				employee.getAadharBack(),
//				employee.getLocationId(),
//				employee.getAddressId()));
		
		
		
		System.out.println("Inside");
		return null;
	}

	@Override
	public String getEmployeeByPhone(Long phone, String password) {
		// TODO Auto-generated method stub
		Optional<Employees> employeeData = employeesRepository.findByPhone(phone);
		
		Employees employee=employeeData.get();

		if (employeeData.isPresent()&&employee.getPassword().equals(password)) {
			return "Access Granted";
		} else {
			return "Access Denied";
		}
	}
	
	
}

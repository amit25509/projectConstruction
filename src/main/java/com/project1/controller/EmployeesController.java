package com.project1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project1.model.Employees;
import com.project1.service.EmployeesService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeesController {

	@Autowired
	EmployeesService employeeService;

	// 1. GET ALL EMPLOYEES

	@GetMapping("/getallemployees")
	public ResponseEntity<List<Employees>> getAllemployee() {
		try {
			List<Employees> employee = employeeService.getAllEmployees();
			System.out.println(employee.isEmpty());

			if (employee.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(employee, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// 2. GET EMPLOYEE BY ID

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employees> getemployeeById(@PathVariable("id") Integer id) {
		Optional<Employees> employee = employeeService.getEmployeesById(id);

		if (employee.isPresent()) {
			return new ResponseEntity<>(employee.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// 3. ADD NEW EMPLOYEE
	@PostMapping("/addemployee")
	public ResponseEntity<Employees> addEmployee(@RequestBody Employees employee) {
		try {
			Employees emp = employeeService.addEmployees(employee);

			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	// 4. UPDATE Employees BY ID

	@PutMapping("/updateemployees/{id}")
	public ResponseEntity<Employees> updateEmployees(@PathVariable("id") Integer id,
			@RequestBody Employees newUpdateEmployees) {

		return employeeService.updateEmployees(id, newUpdateEmployees);
	}

	// 5. DELETE EMPLOYEE BY ID

	@DeleteMapping("/deleteemployees/{id}")
	private ResponseEntity<HttpStatus> deleteEmployees(@PathVariable("id") int id) {
		try {
			employeeService.deleteEmployees(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}
	
	//6. REGISTER EMPLOYEE
	
	@PostMapping("/registeremployee")
	public ResponseEntity<Employees> registerEmployee(@RequestBody Employees employee) {
		try {
			System.out.println("1");
			Employees emp = employeeService.registerEmployees(employee);
			System.out.println("2");

			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/signin/{phone}/{password}")
	public ResponseEntity<String> checkEmployee(@PathVariable("phone") Long phone,@PathVariable("password") String password) {
		try {
			String check = employeeService.getEmployeeByPhone(phone, password);

			return new ResponseEntity<>(check, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
}

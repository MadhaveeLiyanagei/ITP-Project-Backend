package com.itp.importexport.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.itp.importexport.exception.ResourceNotFoundException;
import com.itp.importexport.model.Employee;
import com.itp.importexport.repository.EmployeeRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all employee
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	//create Employee rest api
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) { 
	     return	employeeRepository.save(employee);
	}
	
	//get employee id rest api
	@GetMapping("/employee/{employeeid}")
public ResponseEntity<Employee> getEmployeeId(@PathVariable int employeeid) {
		
		Employee employee  = employeeRepository.findById(employeeid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exit with id :"+employeeid));
		return ResponseEntity.ok(employee);
		
	}
	//update employee rest api
	@PutMapping("/employee/{employeeid}")
	public ResponseEntity<Employee> updateEmployee( @PathVariable int employeeid,@RequestBody Employee employeeDetails){
		
		Employee employee  = employeeRepository.findById(employeeid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exit with id :"+employeeid));
		
		
		employee.setEmployeename(employeeDetails.getEmployeename());
		employee.setEmployeeemail(employeeDetails.getEmployeeemail());
		employee.setEmployeephone(employeeDetails.getEmployeephone());
		employee.setEmployeeusername(employeeDetails.getEmployeeusername());
		employee.setEmployeepassword(employeeDetails.getEmployeepassword());
		employee.setEmployeeaddress(employeeDetails.getEmployeeaddress());
		
		Employee updateEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updateEmployee);
		
	}
	
	// delete employee rest api
		@DeleteMapping("/employee/{employeeid}")
		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int employeeid){
			
			Employee employee  = employeeRepository.findById(employeeid)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exit with id :"+employeeid));
			
			employeeRepository.delete(employee);
		    Map<String, Boolean> response = new HashMap<>();
		    response.put("deleted", Boolean.TRUE);
		    return ResponseEntity.ok(response);
			
		}
	
}
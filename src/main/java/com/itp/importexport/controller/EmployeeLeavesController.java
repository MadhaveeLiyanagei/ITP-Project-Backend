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
import com.itp.importexport.model.EmployeeLeaves;
import com.itp.importexport.repository.EmployeeLeavesRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeLeavesController {
	
	@Autowired
	private EmployeeLeavesRepository employeeLeavesRepository;
	
	//get employee leaves
	@GetMapping("/employeeLeaves")
     public List<EmployeeLeaves> getAllEmployeeLeaves(){
         return employeeLeavesRepository.findAll();
     }
	
	//Create employee leaves rest api
	@PostMapping("/employeeLeaves")
	public EmployeeLeaves createEmployeeLeaves(@RequestBody EmployeeLeaves employeeLeaves) {
		return employeeLeavesRepository.save(employeeLeaves);
	}
	
	//get employee leaves by id rest API
		@GetMapping("/employeeLeaves/{leaveNumber}")
		public ResponseEntity<EmployeeLeaves> getEmployeeLeavesByLeaveNumber(@PathVariable int leaveNumber){
			
			EmployeeLeaves employeeLeaves = employeeLeavesRepository.findById(leaveNumber).orElseThrow(() -> new ResourceNotFoundException("Leave does not exist with number: " + leaveNumber));
			return ResponseEntity.ok(employeeLeaves);
		}
		
		//update employee leaves rest API
		@PutMapping("/employeeLeaves/{leaveNumber}")
		public ResponseEntity<EmployeeLeaves> updateEmployeeLeaves(@PathVariable int leaveNumber, @RequestBody EmployeeLeaves employeeLeavesDetails){
			
			EmployeeLeaves employeeLeaves = employeeLeavesRepository.findById(leaveNumber).orElseThrow(() -> new ResourceNotFoundException("Employee leave does not exist with leave number: " + leaveNumber));
			
			employeeLeaves.setAdminID(employeeLeavesDetails.getAdminID());
			employeeLeaves.setStatus(employeeLeavesDetails.getStatus());
			
			EmployeeLeaves updatedemployeeLeaves = employeeLeavesRepository.save(employeeLeaves);
			
			return ResponseEntity.ok(updatedemployeeLeaves);
		}
		
		//Delete employee leaves rest API
		@DeleteMapping("/employeeLeaves/{leaveNumber}")
		public ResponseEntity<Map<String, Boolean>> deleteIEmployeeLeaves(@PathVariable int leaveNumber){
			
			EmployeeLeaves employeeLeaves = employeeLeavesRepository.findById(leaveNumber).orElseThrow(() -> new ResourceNotFoundException("Employee leave not exist with leave number: " + leaveNumber));
			
			employeeLeavesRepository.delete(employeeLeaves);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
			
		}
}


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
import com.itp.importexport.model.Courier;
import com.itp.importexport.repository.CourierRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CourierController {
	
	@Autowired
	private CourierRepository courierRepository;
	
	// get all courier
	@GetMapping("/courier")
	public List<Courier> getAllCourier(){
		return courierRepository.findAll();
	}		
	
	
	// create courier rest API
	@PostMapping("/courier")
	public Courier createcourier (@RequestBody Courier courier) {
		return courierRepository.save(courier);
		}
	
	// get courier by id rest API
	@GetMapping("/courier/{id}")
	public ResponseEntity<Courier> getCourierById(@PathVariable Long id) {
		
		Courier courier = courierRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Courier not exist with id :" + id));
		return ResponseEntity.ok(courier);
	}
	
	// update courier rest API
	
		@PutMapping("/courier/{id}")
		public ResponseEntity<Courier> updateCourier(@PathVariable Long id, @RequestBody Courier courierDetails){
			
			
			Courier courier = courierRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			
			courier.setName(courierDetails.getName());
			courier.setAddress(courierDetails.getAddress());
			courier.setPhone_number(courierDetails.getPhone_number());
			courier.setEmail(courierDetails.getEmail());
			
			Courier updatedCourier = courierRepository.save(courier);
			return ResponseEntity.ok(updatedCourier);
		}
	
		
		
		// delete employee rest API
		@DeleteMapping("/courier/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteCourier(@PathVariable Long id){
			Courier courier = courierRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Courier not exist with id :" + id));
			
			courierRepository.delete(courier);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	
	

		}
 
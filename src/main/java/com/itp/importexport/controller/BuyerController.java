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
import com.itp.importexport.model.Buyer;
import com.itp.importexport.repository.BuyerRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class BuyerController {
	
	@Autowired
	private BuyerRepository buyerRepository;
	
	//get all buyers
	@GetMapping("/buyer")
	public List<Buyer> getAllBuyer(){
		return buyerRepository.findAll();
	}
	
	//create Buyer rest api
	@PostMapping("/buyer")
	public Buyer createBuyer(@RequestBody Buyer buyer) { 
	     return	buyerRepository.save(buyer);
	}
	
	//get buyer id rest api
	@GetMapping("/buyer/{id}")
	public ResponseEntity<Buyer> getBuyerId(@PathVariable int id) {
		
		Buyer buyer = buyerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Buyer not exit with id :"+id));
		return ResponseEntity.ok(buyer);
		
	}
	
	// update buyer rest api
	
	@PutMapping("/buyer/{id}")
	public ResponseEntity<Buyer> updateBuyer( @PathVariable int id,@RequestBody Buyer buyerDetails){
		
		Buyer buyer = buyerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Buyer not exit with id :"+id));
		
		
		buyer.setName(buyerDetails.getName());
		buyer.setEmail(buyerDetails.getEmail());
		buyer.setPhone(buyerDetails.getPhone());
		buyer.setUserName(buyerDetails.getUserName());
		buyer.setPassword(buyerDetails.getPassword());
		buyer.setAddress(buyerDetails.getAddress());
		
		Buyer updateBuyer = buyerRepository.save(buyer);
		return ResponseEntity.ok(updateBuyer);
		
	}
	
	// delete employee rest api
	@DeleteMapping("/buyer/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBuyer(@PathVariable int id){
		
		Buyer buyer = buyerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Buyer not exit with id :"+id));
		
		buyerRepository.delete(buyer);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return ResponseEntity.ok(response);
		
	}
	
}

     
	 
 
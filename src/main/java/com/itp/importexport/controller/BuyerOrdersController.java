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
import com.itp.importexport.model.BuyerOrders;
import com.itp.importexport.repository.BuyerOrdersRepository;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class BuyerOrdersController {
	
	@Autowired
	private BuyerOrdersRepository buyerorderRepository;
	
	// get all buyer orders	
	@GetMapping("/BuyerOrders")
	public List<BuyerOrders> getAllBuyerOrders(){
		return buyerorderRepository.findAll();
	}
	
	// create buyer order rest api
			@PostMapping("/BuyerOrders")
			public BuyerOrders createBuyerOrder(@RequestBody BuyerOrders buyerorders) {
				return buyerorderRepository.save(buyerorders);
			}
			
	//get buyer order id rest api
			@GetMapping("/BuyerOrders/{id}")
			public ResponseEntity <BuyerOrders> getBuyerOrdersId(@PathVariable int id) {
				BuyerOrders BuyerOrders = buyerorderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Orders not excist with id : "+id));
				
				return ResponseEntity.ok(BuyerOrders);
			}
	// update buyer orders rest api
			@PutMapping("/BuyerOrders/{id}")
			public ResponseEntity<BuyerOrders> updateBuyerOrders(@PathVariable Integer id, @RequestBody BuyerOrders BuyerOrdersDetails){
				BuyerOrders BuyerOrders = buyerorderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Orders not excist with id : "+id));
				
				BuyerOrders.setUsername(BuyerOrdersDetails.getUsername());
				BuyerOrders.setAddress(BuyerOrdersDetails.getAddress());
				BuyerOrders.setEmail(BuyerOrdersDetails.getEmail());
				BuyerOrders.setContact(BuyerOrdersDetails.getContact());
				BuyerOrders.setDate(BuyerOrdersDetails.getDate());
				
				BuyerOrders updateBuyerOrders = buyerorderRepository.save(BuyerOrders);
				return ResponseEntity.ok(updateBuyerOrders);
			}
			
	//delete buyer orders rest api
			@DeleteMapping("/BuyerOrders/{id}")
			public ResponseEntity<Map<String, Boolean>> deleteBuyerOrders(@PathVariable int id){
				BuyerOrders BuyerOrders = buyerorderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Orders not excist with id : "+id));
				buyerorderRepository.delete(BuyerOrders);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
			}

}


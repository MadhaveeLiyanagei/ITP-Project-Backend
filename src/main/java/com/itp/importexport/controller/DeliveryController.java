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
import com.itp.importexport.model.Delivery;
import com.itp.importexport.repository.DeliveryRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class DeliveryController {
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	// get all courier
	@GetMapping("/delivery")
	public List<Delivery> getAllDelivery(){
		return deliveryRepository.findAll();
	}		
	
	
	// create courier rest API
	@PostMapping("/delivery")
	public Delivery createdelivery (@RequestBody Delivery delivery) {
		return deliveryRepository.save(delivery);
		}
	
	// get delivery management by id rest API
	@GetMapping("/delivery/{id}")
	public ResponseEntity<Delivery> getDeliveryByid(@PathVariable Long id) {
		
		Delivery delivery = deliveryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("delivery not exist with id :" + id));
		return ResponseEntity.ok(delivery);
	}
	
	
	// update delivery management rest API
		@PutMapping("/delivery/{id}")
		public ResponseEntity<Delivery> updateDelivery(@PathVariable Long  id, @RequestBody Delivery deliveryDetails){
			Delivery delivery = deliveryRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Delivery not exist with id :" +  id));
		
			
			delivery.setOrder_name(deliveryDetails.getOrder_name());
			delivery.setOrder_address(deliveryDetails.getOrder_address());
			delivery.setOrder_phone_number(deliveryDetails.getOrder_phone_number());
		
			Delivery updatedDelivery = deliveryRepository.save(delivery);
			return ResponseEntity.ok(updatedDelivery);
		}
	
			
			
		// delete employee rest API
		@DeleteMapping("/delivery/{id}")
		public ResponseEntity<Map<String, Boolean>> deletedelivery(@PathVariable Long id){
			Delivery delivery = deliveryRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Courier not exist with id :" + id));
			
			deliveryRepository.delete(delivery);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);   
		}
	
	

		}
 
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
import com.itp.importexport.model.Inventory;
import com.itp.importexport.repository.InventoryRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class InventoryController {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	//get all items in the inventory
	@GetMapping("/inventory")
	public List<Inventory> getAllInventory(){
		return inventoryRepository.findAll();
	}
	
	//create inventory rest API
	@PostMapping("/inventory")
	public Inventory createInventory(@RequestBody Inventory inventory) {
		return inventoryRepository.save(inventory);
	}
	
	//get inventory item by id rest API
	@GetMapping("/inventory/{inventoryID}")
	public ResponseEntity<Inventory> getInventoryByID(@PathVariable int inventoryID){
		
		Inventory inventory = inventoryRepository.findById(inventoryID).orElseThrow(() -> new ResourceNotFoundException("Inventory Item does not exist with id: " + inventoryID));
		
		return ResponseEntity.ok(inventory);
	}
	
	//Update inventory rest API
	@PutMapping("/inventory/{inventoryID}")
	public ResponseEntity<Inventory> updateInventroy(@PathVariable int inventoryID, @RequestBody Inventory inventoryDetails){
		
		Inventory inventory = inventoryRepository.findById(inventoryID).orElseThrow(() -> new ResourceNotFoundException("Inventory Item does not exist with id: " + inventoryID));
		
		inventory.setProductID(inventoryDetails.getProductID());
		inventory.setProductName(inventoryDetails.getProductName());
		inventory.setQuantity(inventoryDetails.getQuantity());
		inventory.setReOrder(inventoryDetails.getReOrder());
		inventory.setCostPrice(inventoryDetails.getCostPrice());
		
		Inventory updatedInventory = inventoryRepository.save(inventory);
		
		return ResponseEntity.ok(updatedInventory);
	}
	
	//Delete inventory rest API
	@DeleteMapping("/inventory/{inventoryID}")
	public ResponseEntity<Map<String, Boolean>> deleteInventory(@PathVariable int inventoryID){
		
		Inventory inventory = inventoryRepository.findById(inventoryID).orElseThrow(() -> new ResourceNotFoundException("Inventory Item does not exist with id: " + inventoryID));
		
		inventoryRepository.delete(inventory);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
}


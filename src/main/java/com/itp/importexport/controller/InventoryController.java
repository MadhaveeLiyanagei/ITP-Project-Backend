package com.itp.importexport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//get all items in inventory
	@GetMapping("/inventory")
	public List<Inventory> getAllInventory(){
		return inventoryRepository.findAll();
	}
	
	//create inventory rest API
	@PostMapping("/inventory")
	public Inventory createInventory(@RequestBody Inventory inventory) {
		return inventoryRepository.save(inventory);
	}
	
	//get inventory by id rest API
	@GetMapping("/inventory/{inventoryID}")
	public ResponseEntity<Inventory> getInventoryByID(@PathVariable int inventoryID){
		
		Inventory inventory = inventoryRepository.findById(inventoryID).orElseThrow(() -> new ResourceNotFoundException("Inventory Item does not exist with id: " + inventoryID));
		
		return ResponseEntity.ok(inventory);
	}
}

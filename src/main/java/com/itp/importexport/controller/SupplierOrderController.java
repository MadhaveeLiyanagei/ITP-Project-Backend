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
import com.itp.importexport.model.SupplierOrder;
import com.itp.importexport.repository.SupplierOrderRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class SupplierOrderController {
	
	@Autowired
	private SupplierOrderRepository supplierorderRepository;
	
	// get all supplier orders	
	@GetMapping("/SupplierOrder")
	public List<SupplierOrder> getSupplierOrders(){
		return supplierorderRepository.findAll();
	}
	
	// create supplier order rest API
			@PostMapping("/SupplierOrder")
			public SupplierOrder createSupplierOrder(@RequestBody SupplierOrder supplierorders) {
				return supplierorderRepository.save(supplierorders);
			}
			
	//get supplier supplier id rest API
			@GetMapping("/SupplierOrder/{id}")
			public ResponseEntity <SupplierOrder> getSupplierOrdersId(@PathVariable int id) {
				SupplierOrder supplierorders = supplierorderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order not exist with id : "+id));
				
				return ResponseEntity.ok(supplierorders);
			}
	// update supplier orders rest API
			@PutMapping("/SupplierOrder/{id}")
			public ResponseEntity<SupplierOrder> updateSupplierOrders(@PathVariable Integer id, @RequestBody SupplierOrder supplierorderDetails){
				SupplierOrder supplierorders = supplierorderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order not exist with id : "+id));
				
				supplierorders.setSupplierName(supplierorderDetails.getSupplierName());
				supplierorders.setCompanyName(supplierorderDetails.getCompanyName());
				supplierorders.setCompanyAddress(supplierorderDetails.getCompanyAddress());
				supplierorders.setSupplierContact(supplierorderDetails.getSupplierContact());
				supplierorders.setCompanyEmail(supplierorderDetails.getCompanyEmail());
				supplierorders.setDescription(supplierorderDetails.getDescription());
				
				SupplierOrder updateSupplierOrders = supplierorderRepository.save(supplierorders);
				return ResponseEntity.ok(updateSupplierOrders);
			}
			
	//delete supplier orders rest API
			@DeleteMapping("/SupplierOrder/{id}")
			public ResponseEntity<Map<String, Boolean>> deleteSupplierOrders(@PathVariable int id){
				SupplierOrder suppliereorder =supplierorderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Orders not exist with id : " + id));
				
				supplierorderRepository.delete(suppliereorder);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
			}

}

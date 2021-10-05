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
import com.itp.importexport.model.Supplier;
import com.itp.importexport.repository.SupplierRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class SupplierController {

	@Autowired
	private SupplierRepository supplierRepository;
	
	//get all supplier
	@GetMapping("/supplier")
	public List<Supplier> getAllBuyer(){
		return supplierRepository.findAll();
	}
	
	//create Supplier rest api
	@PostMapping("/supplier")
	public Supplier creatSupplier(@RequestBody Supplier supplier ) { 
	     return supplierRepository.save(supplier);
	}
	//get supplier id rest api
	@GetMapping("/supplier/{supplierid}")
public ResponseEntity<Supplier> getSupplierId(@PathVariable int supplierid) {
		
		Supplier supplier  = supplierRepository.findById(supplierid)
				.orElseThrow(() -> new ResourceNotFoundException("Supplier not exit with id :"+supplierid));
		return ResponseEntity.ok(supplier);
		
	}
	//update supplier rest api
		@PutMapping("/supplier/{supplierid}")
		public ResponseEntity<Supplier> updateSupplier( @PathVariable int supplierid,@RequestBody Supplier supplierDetails){
			
			Supplier supplier  = supplierRepository.findById(supplierid)
					.orElseThrow(() -> new ResourceNotFoundException("Supplier not exit with id :"+supplierid));
			
			
			supplier.setSuppliername(supplierDetails.getSuppliername());
			supplier.setSupplieremail(supplierDetails.getSupplieremail());
			supplier.setSupplierphone(supplierDetails.getSupplierphone());
			supplier.setSupplierusername(supplierDetails.getSupplierusername());
			supplier.setSupplierpassword(supplierDetails.getSupplierpassword());
			supplier.setSupplieraddress(supplierDetails.getSupplieraddress());
			
			Supplier updateSupplier = supplierRepository.save(supplier);
			return ResponseEntity.ok(updateSupplier);
			
		}
		
		// delete employee rest api
		@DeleteMapping("/supplier/{supplierid}")
		public ResponseEntity<Map<String, Boolean>> deleteBuyer(@PathVariable int supplierid){
			
			Supplier supplier  = supplierRepository.findById(supplierid)
					.orElseThrow(() -> new ResourceNotFoundException("Supplier not exit with id :"+supplierid));
			
			supplierRepository.delete(supplier);
		    Map<String, Boolean> response = new HashMap<>();
		    response.put("deleted", Boolean.TRUE);
		    return ResponseEntity.ok(response);
			
		}
}

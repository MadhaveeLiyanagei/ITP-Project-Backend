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
import com.itp.importexport.model.Tax;
import com.itp.importexport.repository.TaxRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TaxController {
	
	@Autowired
	private TaxRepository taxRepository;
	
	//get all taxes
	@GetMapping("/taxes")
	public List<Tax> getAllTaxes() {
		return taxRepository.findAll();
	}
	
	// create tax rest api
	@PostMapping("/taxes")
	public Tax createTax(@RequestBody Tax tax) {
		return taxRepository.save(tax);	
				}
	
	//get tax by id rest api
	@GetMapping("/taxes/{taxID}")
	public ResponseEntity<Tax> getTaxById(@PathVariable Long taxID) {		
		Tax tax = taxRepository.findById(taxID)
				.orElseThrow(() -> new ResourceNotFoundException("Tax not exist with id :" + taxID));
		return ResponseEntity.ok(tax);
	}
	
	//update tax rest api
	@PutMapping("/taxes/{taxID}")
	public ResponseEntity<Tax> updateTax(@PathVariable Long taxID, @RequestBody Tax taxDetails){
		Tax tax = taxRepository.findById(taxID)
				.orElseThrow(() -> new ResourceNotFoundException("Tax not exist with id :" + taxID));
		
		tax.setProductID(taxDetails.getProductID());
		tax.setCountryCode(taxDetails.getCountryCode());
		tax.setPreTaxPrice(taxDetails.getPreTaxPrice());
		tax.setTaxRate(taxDetails.getTaxRate());
		tax.setSubTotal(taxDetails.getSubTotal());
		tax.setVAT(taxDetails.getVAT());
		tax.setTotalPrice(taxDetails.getTotalPrice());
		
		 
		Tax updatedTax = taxRepository.save(tax);
		return ResponseEntity.ok(updatedTax);
	}
	
	// delete tax rest api
	@DeleteMapping("/taxes/{taxID}")
	public ResponseEntity<Map<String, Boolean>> deleteTax(@PathVariable Long taxID){
		Tax tax = taxRepository.findById(taxID)
				.orElseThrow(() -> new ResourceNotFoundException("Tax not exist with id :" + taxID));
		
		taxRepository.delete(tax);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return ResponseEntity.ok(response);
	}
	
}



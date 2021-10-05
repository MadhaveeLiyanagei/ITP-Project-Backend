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
import com.itp.importexport.model.Income;
import com.itp.importexport.repository.IncomeRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class IncomeController {
	
	@Autowired
	private IncomeRepository incomeRepository;
	
	//get all employees
	@GetMapping("/incomes")
	public List<Income> getAllIncomes() {
		return incomeRepository.findAll();
	}
	
	// create income rest api
	@PostMapping("/incomes")
	public Income createIncome(@RequestBody Income income) {
		return incomeRepository.save(income);	
				}
	
	//get income by id rest api
	@GetMapping("/incomes/{incomeID}")
	public ResponseEntity<Income> getIncomeById(@PathVariable Long incomeID) {		
		Income income = incomeRepository.findById(incomeID)
				.orElseThrow(() -> new ResourceNotFoundException("Income not exist with id :" + incomeID));
		return ResponseEntity.ok(income);
	}
	
	//update income rest api
	@PutMapping("/incomes/{incomeID}")
	public ResponseEntity<Income> updateIncome(@PathVariable Long incomeID, @RequestBody Income incomeDetails){
		Income income = incomeRepository.findById(incomeID)
				.orElseThrow(() -> new ResourceNotFoundException("Income not exist with id :" + incomeID));
		
		income.setTransaction(incomeDetails.getTransaction());
		income.setPaymentFrom(incomeDetails.getPaymentFrom());
		income.setDate(incomeDetails.getDate());
		income.setIncomeCategory(incomeDetails.getIncomeCategory());
		income.setDescription(incomeDetails.getDescription());
		income.setAmount(incomeDetails.getAmount());
		
		Income updatedIncome = incomeRepository.save(income);
		return ResponseEntity.ok(updatedIncome);
	}
	
	// delete income rest api
	@DeleteMapping("/incomes/{incomeID}")
	public ResponseEntity<Map<String, Boolean>> deleteIncome(@PathVariable Long incomeID){
		Income income = incomeRepository.findById(incomeID)
				.orElseThrow(() -> new ResourceNotFoundException("Income not exist with id :" + incomeID));
		
		incomeRepository.delete(income);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return ResponseEntity.ok(response);
	}
	
}



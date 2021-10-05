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
import com.itp.importexport.model.Expense;
import com.itp.importexport.repository.ExpenseRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ExpenseController {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	//get all expenses
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}
	
	// create expense rest api
	@PostMapping("/expenses")
	public Expense createExpense(@RequestBody Expense expense) {
		return expenseRepository.save(expense);	
				}
	
	//get expense by id rest api
	@GetMapping("/expenses/{expenseID}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable Long expenseID) {		
		Expense expense = expenseRepository.findById(expenseID)
				.orElseThrow(() -> new ResourceNotFoundException("Expense not exist with id :" + expenseID));
		return ResponseEntity.ok(expense);
	}
	
	//update expense rest api
	@PutMapping("/expenses/{expenseID}")
	public ResponseEntity<Expense> updateExpense(@PathVariable Long expenseID, @RequestBody Expense expenseDetails){
		Expense expense = expenseRepository.findById(expenseID)
				.orElseThrow(() -> new ResourceNotFoundException("Expense not exist with id :" + expenseID));
		
		expense.setTransaction(expenseDetails.getTransaction());
		expense.setPaymentTo(expenseDetails.getPaymentTo());
		expense.setDate(expenseDetails.getDate());
		expense.setExpenseCategory(expenseDetails.getExpenseCategory());
		expense.setDescription(expenseDetails.getDescription());
		expense.setAmount(expenseDetails.getAmount());
		
		Expense updatedExpense = expenseRepository.save(expense);
		return ResponseEntity.ok(updatedExpense);
	}
	
	// delete expense rest api
	@DeleteMapping("/expenses/{expenseID}")
	public ResponseEntity<Map<String, Boolean>> deleteExpense(@PathVariable Long expenseID){
		Expense expense = expenseRepository.findById(expenseID)
				.orElseThrow(() -> new ResourceNotFoundException("Expense not exist with id :" + expenseID));
		
		expenseRepository.delete(expense);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return ResponseEntity.ok(response);
	}
	
}



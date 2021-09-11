package com.itp.importexport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itp.importexport.model.RequestOrder;
import com.itp.importexport.repository.RequestOrderRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class RequestOrderController {
	
	@Autowired
	private RequestOrderRepository requestOrderRepository;
	
	//Get all requested orders
	@GetMapping("/requestOrder")
	public List<RequestOrder> getAllRequestOrder(){
		return requestOrderRepository.findAll();
	}
	
	//create request order rest API
	@PostMapping("/requestOrder")
	public RequestOrder createRequestOrder(@RequestBody RequestOrder requestOrder) {
		return requestOrderRepository.save(requestOrder);
	}

}

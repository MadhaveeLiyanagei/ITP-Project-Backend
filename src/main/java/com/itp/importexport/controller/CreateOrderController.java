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
import com.itp.importexport.model.CreateOrder;
import com.itp.importexport.repository.CreateOrderRepository;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class CreateOrderController {
	
	@Autowired
	private CreateOrderRepository createorderRepository;
	
	// get all supplier orders	
	@GetMapping("/CreateOrder")
	public List<CreateOrder> getCreateOrders(){
		return createorderRepository.findAll();
	}
	
	// create supplier order rest api
			@PostMapping("/CreateOrder")
			public CreateOrder createSupplierOrder(@RequestBody CreateOrder createorders) {
				return createorderRepository.save(createorders);
			}
			
	//get supplier supplier id rest api
			@GetMapping("/CreateOrder/{id}")
			public ResponseEntity <CreateOrder> getCreateOrdersId(@PathVariable int id) {
				CreateOrder createorders = createorderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order not exist with id : "+id));
				
				return ResponseEntity.ok(createorders);
			}
	// update supplier orders rest api
			@PutMapping("/CreateOrder/{id}")
			public ResponseEntity<CreateOrder> updateCreateOrders(@PathVariable Integer id, @RequestBody CreateOrder createorderDetails){
				CreateOrder createorder = createorderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order not exist with id : "+id));
				
				createorder.setOrderno(createorderDetails.getOrderno());
				createorder.setProductName(createorderDetails.getProductName());
				createorder.setQuantity(createorderDetails.getQuantity());
				createorder.setProductPrice(createorderDetails.getProductPrice());
				
				CreateOrder updateCreateOrders = createorderRepository.save(createorder);
				return ResponseEntity.ok(updateCreateOrders);
			}
			
	//delete supplier orders rest api
			@DeleteMapping("/CreateOrder/{id}")
			public ResponseEntity<Map<String, Boolean>> deleteSupplierOrders(@PathVariable int id){
				CreateOrder createorder =createorderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Orders not exist with id : " + id));
				
				createorderRepository.delete(createorder);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
			}

}
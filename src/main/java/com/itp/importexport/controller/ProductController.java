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
import com.itp.importexport.model.Product;
import com.itp.importexport.repository.ProductRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	//get all products
	@GetMapping("/product")
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	//create product rest API
	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
		
	}
	
	
	//get product by id rest API
	@GetMapping("/product/{productID}")
	public ResponseEntity<Product> getProductByID(@PathVariable int productID){
		
		Product product = productRepository.findById(productID).orElseThrow(() -> new ResourceNotFoundException("Product does not exist with id: " + productID));
		return ResponseEntity.ok(product);
		
		
	}
	
	//Update products rest API
	@PutMapping("/product/{productID}")
	public ResponseEntity<Product> updateProduct(@PathVariable int productID, @RequestBody Product productDetails){
		
		Product product = productRepository.findById(productID).orElseThrow(() -> new ResourceNotFoundException("Product does not exist with id: " + productID));
		
		product.setProductName(productDetails.getProductName());
		product.setProductImage(productDetails.getProductImage());
		product.setProductPrice(productDetails.getProductPrice());
		product.setProductDetails(productDetails.getProductDetails());
		
		Product updatedProduct = productRepository.save(product);
		
		return ResponseEntity.ok(updatedProduct);
	}
	
	//Delete product rest API
	@DeleteMapping("/product/{productID}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable int productID){
		
		Product product = productRepository.findById(productID).orElseThrow(() -> new ResourceNotFoundException("Product does not exist with id: " + productID));
		
		productRepository.delete(product);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
}
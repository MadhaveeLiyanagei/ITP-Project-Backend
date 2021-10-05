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
import com.itp.importexport.model.AdNotices;
import com.itp.importexport.repository.AdNoticesRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AdNoticesController {

	
	@Autowired
	private AdNoticesRepository adNoticesRepository;

	//get all notices
	@GetMapping("/adNotices")
	public List<AdNotices>getAllNotices(){
		return adNoticesRepository.findAll();
	}
	
	//create notices rest api
	@PostMapping("/adNotices")
	public AdNotices createNotice(@RequestBody AdNotices adNotices) {
		return adNoticesRepository.save(adNotices);
	}
	
	//get notice by id api
	@GetMapping("/adNotices/{id}")
	public ResponseEntity<AdNotices> getNoticesById(@PathVariable int id){
		AdNotices adNotices = adNoticesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notice does not exist with id : "+id));
		return ResponseEntity.ok(adNotices);
	}
	
	//update notice rest api
	@PutMapping("/adNotices/{id}")
	public  ResponseEntity<AdNotices> updateNotices(@PathVariable int id, @RequestBody AdNotices adNoticesDetails){
		AdNotices adNotices = adNoticesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notice does not exist with id : "+id));
		
		adNotices.setContent(adNoticesDetails.getContent());
		
		AdNotices updateNotices = adNoticesRepository.save(adNotices);
		return ResponseEntity.ok(updateNotices);

		
	}
	
	//Delete notices rest API
		@DeleteMapping("/adNotices/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteAdNotcies(@PathVariable int id){
			
			AdNotices adNotices = adNoticesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notice does not exist with id: " + id));
			
			adNoticesRepository.delete(adNotices);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
			
		}
}


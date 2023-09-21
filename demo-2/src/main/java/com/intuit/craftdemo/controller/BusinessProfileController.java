package com.intuit.craftdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.craftdemo.entity.BusinessProfile;
import com.intuit.craftdemo.service.BusinessProfileService;

@RestController
public class BusinessProfileController {
	
	@Autowired
	BusinessProfileService businessProfileService;
	
	@PostMapping("/businessProfile")
	public ResponseEntity<BusinessProfile> addBusinessProfile(@RequestBody BusinessProfile businessProfile){
		return ResponseEntity.ok(businessProfileService.addBusinessProfile(businessProfile));
	}

	
//	@PutMapping("/businessProfile/{id}")
//	public ResponseEntity<BusinessProfile> updateBusinessProfile(@RequestBody BusinessProfile businessProfile, @PathVariable String id){
//		return ResponseEntity.ok(businessProfileService.updateBusinessProfile(businessProfile, id));
//	}

}


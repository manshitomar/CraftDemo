package com.intuit.craftdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.craftdemo.entity.BusinessProfile;
import com.intuit.craftdemo.entity.UserProductMapping;
import com.intuit.craftdemo.service.BusinessProfileService;


@RestController
public class BusinessProfileController {
	
	@Autowired
	BusinessProfileService businessProfileService;
	
	@PostMapping("/businessProfileService/addBusinessProfile/{username}")
	public ResponseEntity<BusinessProfile> addBusinessProfile(@RequestBody BusinessProfile businessProfile, @PathVariable(value = "username") String username)
	{
		return ResponseEntity.ok(businessProfileService.addBusinessProfile(username, businessProfile));
	}
	
	@GetMapping("/businessProfileService/findByCompanyName/{companyName}")
    public ResponseEntity<BusinessProfile>  findByCompanyName(@PathVariable(value = "companyName") String companyName){
        return ResponseEntity.ok(businessProfileService.getBusinessProfileByCompanyName(companyName));
    }

    @GetMapping("/businessProfileService/findAll")
    public ResponseEntity<List<BusinessProfile>> findAll(){
        return ResponseEntity.ok(businessProfileService.findAll());
    }

    @PutMapping("/businessProfileService/updateBusinessProfile/{username}/{companyName}")
    public ResponseEntity<BusinessProfile> update(@PathVariable(value = "username") String username, @PathVariable(value = "companyName") String companyName,
    @RequestBody BusinessProfile profile){
        return ResponseEntity.ok(businessProfileService.updateBusinessProfile(username, companyName, profile));
    }
    
    @DeleteMapping("/businessProfileService/deleteBusinessProfile/{companyName}")
    public String delete(@PathVariable(value = "companyName") String companyName){
        return businessProfileService.deleteBusinessProfileByCompanyName(companyName);
    }
    

}


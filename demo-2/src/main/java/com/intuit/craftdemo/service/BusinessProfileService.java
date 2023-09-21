package com.intuit.craftdemo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuit.craftdemo.entity.BusinessProfile;
import com.intuit.craftdemo.repo.BusinessProfileRepository;

@Service
public class BusinessProfileService {

	
	@Autowired
	BusinessProfileRepository businessProfileRepository;
	
	public BusinessProfile addBusinessProfile(BusinessProfile profile) {
		return businessProfileRepository.save(profile);	
	}

}

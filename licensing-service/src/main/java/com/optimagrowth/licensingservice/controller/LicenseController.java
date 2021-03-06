package com.optimagrowth.licensingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optimagrowth.licensingservice.model.License;
import com.optimagrowth.licensingservice.service.LicenseService;

@RestController
@RequestMapping(value="v1/organization/{organizationId}/license")
public class LicenseController {
	
	@Autowired
	  private LicenseService licenseService;

	  @GetMapping(value="/{licenseId}")                              
	  public ResponseEntity<License> getLicense(
	     @PathVariable("organizationId") String organizationId,
	     @PathVariable("licenseId") String licenseId) {              

	     License license = licenseService
	         .getLicense(licenseId,organizationId);                  
	       return ResponseEntity.ok(license);
	  }

}

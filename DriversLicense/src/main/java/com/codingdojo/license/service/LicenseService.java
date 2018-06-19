package com.codingdojo.license.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.license.models.License;
import com.codingdojo.license.models.Person;
import com.codingdojo.license.repository.LicenseRepository;
import com.codingdojo.license.repository.PersonRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepo;
	private final PersonRepository personRepo;
	
	public LicenseService(LicenseRepository licenseRepo, PersonRepository personRepo) {
		this.licenseRepo = licenseRepo;
		this.personRepo = personRepo;
	}
	
	public List<Person> allPerson(){
		return personRepo.findAll();
	}
	
	public List<License> allLicense(){
		return licenseRepo.findAll();
	}
	
	public Person createPerson(Person p) {
		return personRepo.save(p);
	}
	
	public License createLicense(License l) {
		return licenseRepo.save(l);
	}
	
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepo.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}else {
			return null;
		}
	}
	
	public License findLicense(Long id) {
		return licenseRepo.findLicenseByPerson_id(id);
	}
	
	public License findLast() {
		return licenseRepo.findFirst1ByOrderByNumberDesc();
	}

}

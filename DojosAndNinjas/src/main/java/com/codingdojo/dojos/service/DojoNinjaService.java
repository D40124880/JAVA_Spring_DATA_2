package com.codingdojo.dojos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojos.models.Dojo;
import com.codingdojo.dojos.models.Ninja;
import com.codingdojo.dojos.repository.DojoRepository;
import com.codingdojo.dojos.repository.NinjaRepository;

@Service
public class DojoNinjaService {
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	public DojoNinjaService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Dojo> allDojo(){
		return dojoRepo.findAll();
	}
	
	public List<Ninja> allNinja(){
		return ninjaRepo.findAll();
	}
	
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
}

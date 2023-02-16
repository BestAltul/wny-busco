package com.wnybusco.depew.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wnybusco.depew.model.Fleet;
import com.wnybusco.depew.repositories.FleetRepository;

@Service
@Transactional(readOnly=true)
public class FleetService {
	
	private final FleetRepository fleetRepository; 
	
	@Autowired
	public FleetService(FleetRepository fleetRepository) {
		this.fleetRepository = fleetRepository;
	}
	
	public List<Fleet> findAll(){
		
		return fleetRepository.findAll();
	}
	
	
}

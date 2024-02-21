package com.wnybusco.depew.services;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.wnybusco.depew.model.BigBus;
import com.wnybusco.depew.model.CP2;
import com.wnybusco.depew.model.CP4;
import com.wnybusco.depew.model.Fleet;
import com.wnybusco.depew.repositories.BusesRepository;
import com.wnybusco.depew.repositories.DashCamRepositoryCP4;
import com.wnybusco.depew.repositories.FleetRepository;
import com.wnybusco.depew.repositories.DashCamRepositoryCP2;

@Service
@Transactional(readOnly=true)
public class BusService {
	
	private final BusesRepository busesRepository; 
	
	private final DashCamRepositoryCP4 dashCamRepositoryCP4;
	
	private final DashCamRepositoryCP2 dashCamRepositoryCP2;
	
	private final FleetRepository fleetRepository;
	
	private CP4 cp4;
	
	private CP2 cp2;
	
	
	
	@Autowired
	public BusService (BusesRepository busesRepository, DashCamRepositoryCP4 dashCamRepositoryCP4, DashCamRepositoryCP2 dashCamRepositoryCP2,FleetRepository fleetRepository) {
		this.busesRepository = busesRepository;
		this.dashCamRepositoryCP4 = dashCamRepositoryCP4;
		this.dashCamRepositoryCP2 = dashCamRepositoryCP2;
		this.fleetRepository = fleetRepository;
	}
	

	public List<BigBus> findAll(){
		return  busesRepository.findAll();
	}
	
	public List<BigBus> findAllDTO(){
		return  busesRepository.findAll();
	}
	
	public BigBus findOne(int id) {

		Optional <BigBus> foundBus = busesRepository.findById(id);
		return foundBus.orElse(null);
	}
	
	@Transactional
	public void save(BigBus bigBus, Fleet fleet,CP4 dashCam){
		bigBus.setOwner(fleet);
		bigBus.setCp4(dashCam);
		busesRepository.save(bigBus);
	}
	
	@Transactional
	public void update(int id, BigBus updatedBigBus,Fleet fleet,CP4 dashCam) {
		updatedBigBus.setCp4(dashCam);
		updatedBigBus.setId(id);
		updatedBigBus.setOwner(fleet);
		
		busesRepository.save(updatedBigBus);
	}
	
	private Optional<BigBus> createBigBus(String[] dashCamArray) {
		
		BigBus bigBus=null;
		Fleet fleetFound = null;
		
		if(dashCamArray[0]!=null) {
			
			if ((dashCamArray[4]!=null) && (dashCamArray[4].equals("WNY Bus"))) {
				fleetFound = fleetRepository.findById(2).orElse(null);					
			}else if((dashCamArray[4]!=null) && (dashCamArray[4].equals("Hamburg"))) {
				fleetFound = fleetRepository.findById(1).orElse(null);
			}else {
				fleetFound = fleetRepository.findById(3).orElse(null);
			}
			
			bigBus = new BigBus(dashCamArray[0].toString().replace(".0",""),fleetFound);
			
			busesRepository.save(bigBus);	
		}
		return Optional.ofNullable(bigBus);
	}
	
	@Transactional
	public void upload(String fileName) {
		
		String[][] dashCamArray = Parser.parse(fileName);
		
		for (int i=0;i<dashCamArray.length;i++) {
			
			 Optional<BigBus> optional = createBigBus(dashCamArray[i]);
			
			if((dashCamArray[i][1]!=null) && (dashCamArray[i][1].toString().startsWith("T0M"))) {
				cp4 = new CP4(dashCamArray[i][3].toString(),dashCamArray[i][1].toString(),dashCamArray[i][2].toString());
				dashCamRepositoryCP4.save(cp4);
				optional.ifPresent(bigBus->bigBus.setCp4(cp4));
				optional.ifPresent(bigBus->busesRepository.save(bigBus));
			}else if((dashCamArray[i][1]!=null) && (dashCamArray[i][1].toString().startsWith("F6"))){
				cp2 = new CP2(dashCamArray[i][3].toString(),dashCamArray[i][1].toString(),dashCamArray[i][2].toString());
				dashCamRepositoryCP2.save(cp2);
				optional.ifPresent(bigBus->bigBus.setCp2(cp2));
				optional.ifPresent(bigBus->busesRepository.save(bigBus));
			}else{
			}
			
		}
	}
	
	@Transactional
	public void delete(int id) {
		busesRepository.deleteById(id);
	}
}





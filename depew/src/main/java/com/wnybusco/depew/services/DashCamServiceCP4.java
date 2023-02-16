package com.wnybusco.depew.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wnybusco.depew.model.CP4;
import com.wnybusco.depew.repositories.DashCamRepositoryCP4;

@Service
@Transactional(readOnly=true)
public class DashCamServiceCP4 {
	
	private final DashCamRepositoryCP4 dashCamRepositoryCP4;
	
	@Autowired
	public DashCamServiceCP4(DashCamRepositoryCP4 dashCamRepositoryCP4) {
		this.dashCamRepositoryCP4=dashCamRepositoryCP4;
	}

	public List<CP4> findAll(){
		return  dashCamRepositoryCP4.findAll();
	}
	
}

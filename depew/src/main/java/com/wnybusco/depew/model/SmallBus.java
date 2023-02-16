package com.wnybusco.depew.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class SmallBus extends Vehicle{

	@OneToOne(targetEntity=com.wnybusco.depew.model.CP2.class)
	@JoinColumn(name="dashcam_id", referencedColumnName="id")	
	private  DashCam dashCam;
		
	@Autowired
	@Qualifier("CP2")
	public DashCam getDashcam() {
		return dashCam;
	}

	public void setDashcam(DashCam dashCam) {
		this.dashCam = dashCam;
	}

	public SmallBus() {}

	public SmallBus(String number,Fleet owner, DashCam dashCam){
		super(number,owner);	
	}
	
	public String getSerialNumber() {
		
		return "";
	}
		
}

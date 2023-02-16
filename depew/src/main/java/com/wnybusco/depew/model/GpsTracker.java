package com.wnybusco.depew.model;

public interface GpsTracker {
	
	public String getSerialNumber();
	
	default public String getIMEI(Fleet fleet) {
		
		return fleet+" 1234567890";
		
	};
}

package com.wnybusco.depew.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="cp4",schema="depew")
public class CP4 extends DVR implements DashCam{
	
	public CP4() {}
	
	public CP4(String name,String drid,String imei) {
		super(name,drid,imei);
	}
}




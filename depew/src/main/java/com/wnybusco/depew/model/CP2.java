package com.wnybusco.depew.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="cp2",schema="depew")
public class CP2 extends DVR implements DashCam{

	public CP2() {}
	
	public CP2(String name,String drid,String imei) {
		super(name,drid,imei);
	}

}
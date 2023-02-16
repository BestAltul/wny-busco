package com.wnybusco.depew.model;



import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="big_bus",schema="depew")
public class BigBus extends Vehicle{
	
	@OneToOne(targetEntity=com.wnybusco.depew.model.CP4.class)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name="cp4_id", referencedColumnName="id")	
	private  DashCam cp4;
	
	@OneToOne(targetEntity=com.wnybusco.depew.model.CP2.class)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name="cp2_id", referencedColumnName="id")	
	private  DashCam cp2;
	
	@Autowired
	public DashCam getCp2() {
		return cp2;
	}
	
	@Autowired
	public void setCp2(DashCam cp2) {
		this.cp2 = cp2;
	}
		
	@Autowired
	public DashCam getCp4() {
		return cp4;
	}
	
	@Autowired
	public void setCp4(DashCam cp4) {
		this.cp4 = cp4;
	}

	public BigBus() {}

	@Autowired
	public BigBus(String number,Fleet owner){
		super(number,owner);		
	}
	
	public String getSerialNumber() {
		
		return "";
	}

	
}

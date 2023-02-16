package com.wnybusco.depew.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;


@MappedSuperclass
public abstract class DVR {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;

	@Column(name="serialnumber")	
	private String serialNumber;
	
	@Column(name="drid")
	private String drid;
	
	@Column(name="imei")
	private String imei;
	
	@OneToOne(targetEntity=com.wnybusco.depew.model.SimCard.class,cascade = CascadeType.ALL)
	@JoinColumn(name="sim_card_id", referencedColumnName="id")
	private SimCard simCard;
	
	public DVR() {}
	
	public DVR(String name,String drid,String imei) {
		this.name = name;
		this.drid = drid;
		this.imei = imei;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDrid() {
		return drid;
	}

	public void setDrid(String drid) {
		this.drid = drid;
	}

	public String getIMEI() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public SimCard getSimCard() {
		return simCard;
	}

	public void setSimCard(SimCard simCard) {
		this.simCard = simCard;
	}

	public String getImei() {
		return imei;
	}
	
	
}

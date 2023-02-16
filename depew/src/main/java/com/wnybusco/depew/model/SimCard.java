package com.wnybusco.depew.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sim_card",schema="depew")
public class SimCard {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="carrier")
	private String carrier;
	
	@Column(name="phone_number")
	private Long phoneNumber;
	
	@Column(name="card_number")
	private String cardNumber;
	
	@Column(name="activated_day")
	private Date activatedDay;
	
	@Column(name="deactivated_day")
	private Date deactivatedDay;

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String carNumber) {
		this.cardNumber = carNumber;
	}

	public Date getActivatedDay() {
		return activatedDay;
	}

	public void setActivatedDay(Date activatedDay) {
		this.activatedDay = activatedDay;
	}

	public Date getDeactivatedDay() {
		return deactivatedDay;
	}

	public void setDeactivatedDay(Date deactivatedDay) {
		this.deactivatedDay = deactivatedDay;
	}	
	
}

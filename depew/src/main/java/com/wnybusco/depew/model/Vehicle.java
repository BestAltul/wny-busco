package com.wnybusco.depew.model;



import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Vehicle {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="number")
	private String number;
		
	@ManyToOne
	@JoinColumn(name="fleet", referencedColumnName="id")	
	private Fleet owner;
	
	/*
	@OneToOne
	@JoinColumn(name="dashcam_id", referencedColumnName="id")	
	@Autowired
	private  DashCam dashCam;
*/
	public Vehicle(){};
	
	public Vehicle(String number){
		this.number = number;
	};
	
	public Vehicle(String number,Fleet owner){
		this.number = number;
		this.owner = owner;		
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Fleet getOwner() {
		return owner;
	}

	public void setOwner(Fleet owner) {
		this.owner = owner;
	}
	
	

}

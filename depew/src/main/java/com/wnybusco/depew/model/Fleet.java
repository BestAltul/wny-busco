package com.wnybusco.depew.model;

import java.util.List;

import jakarta.persistence.*;



//import javax.persistence.GenerationType;
//import HibernateApp.Hibernate_app1.model.buses;

@Entity
@Table(name="fleet",schema="depew")
public class Fleet {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="owner",cascade=CascadeType.PERSIST)
	private List<BigBus> BigBus;
	
	public Fleet() {}
	
	public Fleet(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<BigBus> getBigBus() {
		return BigBus;
	}

	public void setBigBus(List<BigBus> bigBus) {
		BigBus = bigBus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

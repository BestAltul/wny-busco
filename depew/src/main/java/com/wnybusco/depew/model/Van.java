package com.wnybusco.depew.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="van",schema="depew")
public class Van extends Vehicle{
	
	public Van() {}

	public Van(String number,Fleet owner){
		super(number,owner);	
	}
}

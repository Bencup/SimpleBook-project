package com.codingz.simplebook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Statusb {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String statusb_name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatusb_name() {
		return statusb_name;
	}
	public void setStatusb_name(String statusb_name) {
		this.statusb_name = statusb_name;
	}

		

}

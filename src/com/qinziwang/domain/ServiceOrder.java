package com.qinziwang.domain;

import java.util.Date;

public class ServiceOrder {

	private int id;
	
	private String username;
	
	private String shoppingcarids;
	
	private Date creationtime;
	
	private String status;
	
	private double price;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getShoppingcarids() {
		return shoppingcarids;
	}

	public void setShoppingcarids(String shoppingcarids) {
		this.shoppingcarids = shoppingcarids;
	}

	public Date getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(Date creationtime) {
		this.creationtime = creationtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}

package com.qinziwang.domain;

import java.util.Date;

public class ShoppingCar {

	private int id;
	
	private String username;
	
	private int commodityid;
	
	private Date creationtime;
	
	private String type;
	
	private double price;
	
	private int count;
	
	private String status;
	
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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


	public int getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(int commodityid) {
		this.commodityid = commodityid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(Date creationtime) {
		this.creationtime = creationtime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}

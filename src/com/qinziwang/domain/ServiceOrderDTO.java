package com.qinziwang.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceOrderDTO {

	private int id;
	
	private String username;
	
	private List<String> commodities=new ArrayList<String>();
	
	private List<Integer> count=new ArrayList<Integer>();
	
	private Date creationtime;
	
	private String status;
	
	private double price;

	private String shoppingcarids;


	public List<Integer> getCount() {
		return count;
	}

	public void setCount(List<Integer> count) {
		this.count = count;
	}

	public String getShoppingcarids() {
		return shoppingcarids;
	}

	public void setShoppingcarids(String shoppingcarids) {
		this.shoppingcarids = shoppingcarids;
	}

	public List<String> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<String> commodities) {
		this.commodities = commodities;
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

package com.goodsmanage.domain;

import java.util.Date;

public class GiveGoodsRecord {
	
	private int id;
	
	private int goodsid;
	
	private String userno;
	
	private String username;

	private Date give_time;
	
	private String status;
	
	private String goodsname;
	
	
	

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

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

	public int getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}

	public String getUserno() {
		return userno;
	}

	public void setUserno(String userno) {
		this.userno = userno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getGive_time() {
		return give_time;
	}

	public void setGive_time(Date give_time) {
		this.give_time = give_time;
	}
	

	

}

package com.webapp.mmt.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;


@Document(collection = "subscriber")
public class Subscriber {
	
	@Id
	private String id;
	
	@Size(min = 5)
	private String name;
	private String address;
	@Size(max = 10, min = 10, message = "Phone number should consists of 10 digits")
	private String phone;
	@Min(100)
	private double amount;
	
	
	public Subscriber() {}
	

	public Subscriber(String id, String name, String address, String phone, double amount) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	@Override
	public String toString() {
		return "Subscriber [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", amount="
				+ amount + "]";
	}
	
	
	
}

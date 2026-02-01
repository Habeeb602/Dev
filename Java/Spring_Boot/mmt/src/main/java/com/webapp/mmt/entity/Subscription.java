package com.webapp.mmt.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;

import org.springframework.data.annotation.Id;
@Document (collection = "subscription")
public class Subscription {
	
	@Id
	private String id;
	
	@Min(100)
	private double subAmount;
	
	private String comments;
	
	@DBRef
	private Subscriber subscriber;
	
	public Subscription() {}

	public Subscription(String id, double subAmount, String comments, Subscriber subscriber) {
		super();
		this.id = id;
		this.subAmount = subAmount;
		this.comments = comments;
		this.subscriber = subscriber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getSubAmount() {
		return subAmount;
	}

	public void setSubAmount(double subAmount) {
		this.subAmount = subAmount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	@Override
	public String toString() {
		return "Subscription [Id=" + id + ", subAmount=" + subAmount + ", comments=" + comments + ", subscriber="
				+ subscriber + "]";
	}
	
	
	
	
	
}

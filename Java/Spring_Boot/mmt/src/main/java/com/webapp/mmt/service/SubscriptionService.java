package com.webapp.mmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webapp.mmt.entity.Subscription;
import com.webapp.mmt.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
	private SubscriptionRepository subscriptionRepository;
	
	public SubscriptionService(SubscriptionRepository subscriptionRepository) {
		this.subscriptionRepository = subscriptionRepository;
	}
	
	
	public Subscription saveSubscription(Subscription subscription) {
		Subscription savedSubscription = subscriptionRepository.save(subscription);		
		return savedSubscription;
	}
	
	public List<Subscription> getSubscriptions(){
		return subscriptionRepository.findAll();
	}
	
	
	public void deleteSubscription(String id) {
		subscriptionRepository.deleteById(id);
	}
	
	
	
}

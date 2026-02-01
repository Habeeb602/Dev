package com.webapp.mmt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.mmt.entity.Subscription;
import com.webapp.mmt.service.SubscriptionService;

@RestController
public class SubscriptionController {
	private SubscriptionService subscriptionService;
	
	public SubscriptionController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}
	
	
	@GetMapping("/subscriptions")
	public List<Subscription> getSubscriptions(){
		return subscriptionService.getSubscriptions();
	}
	
	@PostMapping("/subscriptions")
	public Subscription createSubscription(@RequestBody Subscription subscription) {
		return subscriptionService.saveSubscription(subscription);
	}
	
	@DeleteMapping("/subscriptions/{id}")
	public void deleteSubscription(@PathVariable String id) {
		subscriptionService.deleteSubscription(id);
	}
}

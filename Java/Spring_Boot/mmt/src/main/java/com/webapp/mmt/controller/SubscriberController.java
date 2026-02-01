package com.webapp.mmt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.mmt.entity.Subscriber;
import com.webapp.mmt.entity.Subscription;
import com.webapp.mmt.service.SubscriberService;

import jakarta.validation.Valid;

@RestController
public class SubscriberController {

	private SubscriberService subscriberService;
	
	public SubscriberController(SubscriberService subscriberService) {
		this.subscriberService = subscriberService;
	}
	
	@GetMapping("/subscribers")
	public List<Subscriber> getSubscribers(){
		return subscriberService.getSubscribers();
	}
	
	@PostMapping("/subscribers")
	public Subscriber addSubscriber(@Valid @RequestBody Subscriber subscriber) {
		return subscriberService.saveSubscriber(subscriber);
	}
	
	@DeleteMapping("/subscribers/{id}")
	public void deleteSubscriber(@PathVariable String id) {
		subscriberService.delete(id);
	}
	
	@PatchMapping("/subscribers/{id}")
	public Subscriber updateSubscriber(@PathVariable String id, @Valid @RequestBody Subscriber subscriber) {
		System.out.println("I Came Inside Patch");
		return	subscriberService.updateById(id, subscriber);
	}
	
	@GetMapping("/subscribers/{id}/subscriptions")
	public List<Subscription> getSubscriptionsBySubscriber(@PathVariable String id){
		return subscriberService.getSubscriptions(id);
	}
	
	
	
	
}

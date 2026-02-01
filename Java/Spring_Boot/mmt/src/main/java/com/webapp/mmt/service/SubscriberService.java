package com.webapp.mmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.mmt.entity.Subscriber;
import com.webapp.mmt.entity.Subscription;
import com.webapp.mmt.exceptions.SubscriberNotFoundException;
import com.webapp.mmt.repository.SubscriberRepository;



@Service
public class SubscriberService {
	
	@Autowired
	private SubscriberRepository subscriberRepository;
	private SubscriptionService subscriptionService;
	
	public SubscriberService(SubscriberRepository subscriberRepository, SubscriptionService subscriptionService) {
		this.subscriberRepository = subscriberRepository;
		this.subscriptionService = subscriptionService;
	}
	
	public Subscriber saveSubscriber(Subscriber subscriber) {
		return subscriberRepository.save(subscriber);
	}
	
	public List<Subscriber> getSubscribers(){
		return subscriberRepository.findAll();
	}
	
	public void delete(String id) {
		findById(id);
		subscriberRepository.deleteById(id);
	}
	
	public Subscriber findById(String id){
		Optional<Subscriber> subscriber = subscriberRepository.findById(id);
		if(subscriber.isEmpty()) {
			throw new SubscriberNotFoundException("Subscriber with this ID: " + id + " not found!");
		}
		return subscriber.get();	
	}
	
	public Subscriber updateById(String id, Subscriber newSubscriber) {
		Subscriber subscriber = findById(id);
		subscriber.setName(newSubscriber.getName());
		subscriber.setAddress(newSubscriber.getAddress());
		subscriber.setPhone(newSubscriber.getPhone());
		subscriber.setAmount(newSubscriber.getAmount());
		
		return subscriberRepository.save(subscriber);
	}
	
	public List<Subscription> getSubscriptions(String id){
		List<Subscription> subscriptions = subscriptionService.getSubscriptions();
		subscriptions.removeIf(sub -> !sub.getSubscriber().getId().equals(id));
		
		return subscriptions;
	}
	
	
}

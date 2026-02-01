package com.webapp.mmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webapp.mmt.entity.Subscription;

public interface SubscriptionRepository extends MongoRepository<Subscription, String> {

}

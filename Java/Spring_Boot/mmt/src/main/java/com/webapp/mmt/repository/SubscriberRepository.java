package com.webapp.mmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webapp.mmt.entity.Subscriber;

public interface SubscriberRepository extends MongoRepository<Subscriber, String>{

}

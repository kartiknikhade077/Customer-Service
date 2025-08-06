package com.customer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.customer.entity.Contacts;

public interface ContactsRepository  extends MongoRepository<Contacts, String>{

	List<Contacts> findByCustomerId(String customerId);
}

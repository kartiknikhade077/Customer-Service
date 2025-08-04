package com.customer.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.customer.entity.Customers;

public interface CustomerRepository extends MongoRepository<Customers, String>{
	
	Page<Customers> findByCompanyIdAndCompanyNameRegexIgnoreCase(String companyId,String name,Pageable pageable);
	Page<Customers> findByEmployeeIdAndCompanyNameRegexIgnoreCase(String companyId,String name ,Pageable pageable);
	
	
	List<Customers> findByCompanyId(String companyId);



}

package com.customer.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.customer.entity.Customers;

public interface CustomerRepository extends MongoRepository<Customers, String>{
	
	Page<Customers> findByCompanyIdAndCustomerNameRegexIgnoreCase(long companyId,String name,Pageable pageable);
	Page<Customers> findByEmployeeIdAndCustomerNameRegexIgnoreCase(long companyId,String name ,Pageable pageable);

}

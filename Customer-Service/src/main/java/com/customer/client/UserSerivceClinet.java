package com.customer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.customer.dto.Company;
import com.customer.dto.Employee;



@FeignClient(name="USER-SERVICE")
public interface UserSerivceClinet {
	
	@GetMapping("/company/getCompanyInfo")
	public Company getCompanyInfo();
	
	@GetMapping("/employee/getEmployeeInfo")
	public Employee getEmployeeInfo();

}

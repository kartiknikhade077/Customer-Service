package com.customer.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.client.UserSerivceClinet;
import com.customer.dto.Company;
import com.customer.entity.Customers;
import com.customer.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private UserSerivceClinet userSerivceClinet;

	@Autowired
	private CustomerRepository customerRepository;

	

	Company company;

	@ModelAttribute
	public void companyDetails() {

		company = userSerivceClinet.getCompanyInfo();

	}

	@PostMapping("/createCustomer")
	public ResponseEntity<?> createCustomer(@RequestBody Customers customer) {

		try {

			customer.setCompanyId(company.getCompanyId());
			customer.setStatus(true);
			customer.setCreatedDate(LocalDateTime.now());
			customerRepository.save(customer);

			return ResponseEntity.ok(customer);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error  " + e.getMessage());
		}

	}

	@GetMapping("/getAllCustomer/{page}/{size}")
	public ResponseEntity<?> getAllCustomer(@PathVariable int page, @PathVariable int size,
			@RequestParam(defaultValue = "") String name) {

		try {

			Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
			String regex = ".*" + Pattern.quote(name) + ".*";
			Page<Customers> customerList = customerRepository
					.findByCompanyIdAndCompanyNameRegexIgnoreCase(company.getCompanyId(), regex, pageable);

			Map<String, Object> response = new HashMap<>();
			response.put("customerList", customerList.getContent());
			response.put("currentPage", customerList.getNumber());
			response.put("totalPages", customerList.getTotalPages());
			return ResponseEntity.ok(response);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error  " + e.getMessage());
		}

	}

	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity<?> getAllCustomer(@PathVariable String id) {

		try {

			Optional<Customers> customer = customerRepository.findById(id);

			return ResponseEntity.ok(customer);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error  " + e.getMessage());
		}

	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<?> updateCustomer(@RequestBody Customers customer) {

		try {
			customer.setCompanyId(company.getCompanyId());
			customerRepository.save(customer);
			return ResponseEntity.ok(customer);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error  " + e.getMessage());
		}

	}
	
	
	@GetMapping("/getCustomerList")
	public ResponseEntity<?> getCustomerList() {

		try {                       
			List<Customers> list = customerRepository.findByCompanyId(company.getCompanyId());
			return ResponseEntity.ok(list);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error  " + e.getMessage());
		}

	}
	

}

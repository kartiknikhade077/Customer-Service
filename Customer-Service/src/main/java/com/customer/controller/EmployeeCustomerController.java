package com.customer.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

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
import com.customer.dto.Employee;
import com.customer.entity.Customers;
import com.customer.repository.CustomerRepository;

@RestController
@RequestMapping("/customer/employee")
public class EmployeeCustomerController {

	@Autowired
	private UserSerivceClinet userSerivceClinet;

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping
	public void testing() {

		System.err.println("Setting ");
	}

	Company company;
	Employee employee;

	@ModelAttribute
	public void companyDetails() {

		company = userSerivceClinet.getCompanyInfo();
		

	}

	@ModelAttribute
	public Employee employeeInfo() {

		employee = userSerivceClinet.getEmployeeInfo();
		return employee;

	}

	@PostMapping("/createCustomer")
	public ResponseEntity<?> createCustomer(@RequestBody Customers customer) {

		try {

			customer.setCompanyId(Long.valueOf(employee.getCompanyId()));
			customer.setEmployeeId(Long.valueOf(employee.getEmployeeId()));
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
	public ResponseEntity<?> getAllCustomer(@PathVariable int page, @PathVariable int size,@RequestParam(defaultValue = "") String name) {

		try {


			Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
			String regex = ".*" + Pattern.quote(name) + ".*";  // Escape special characters
			Page<Customers> customerList = customerRepository
			    .findByEmployeeIdAndCompanyNameRegexIgnoreCase(
			        employee.getEmployeeId(),
			        regex,
			        pageable
			    );


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
			customer.setCompanyId(Long.valueOf(employee.getCompanyId()));
			customer.setEmployeeId(Long.valueOf(employee.getEmployeeId()));
			return ResponseEntity.ok(customer);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error  " + e.getMessage());
		}

	}

}

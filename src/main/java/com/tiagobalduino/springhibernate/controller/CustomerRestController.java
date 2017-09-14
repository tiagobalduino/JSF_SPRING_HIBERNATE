package com.tiagobalduino.springhibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tiagobalduino.springhibernate.bean.Customer;
import com.tiagobalduino.springhibernate.dao.CustomerDAO;

@RestController
public class CustomerRestController {

	
	@Autowired
	private CustomerDAO customerDAO;

	
	@RequestMapping("/customers")
	public List getCustomers() {
		return customerDAO.list();
	}

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity getCustomer(@PathVariable("id") Long id) {

		Customer customer = customerDAO.get(id);
		if (customer == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST, headers = "Accept=application/json" )
	public ResponseEntity createCustomer(@RequestBody Customer customer) {

		customerDAO.create(customer);

		return new ResponseEntity(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json" )
	public ResponseEntity deleteCustomer(@PathVariable Long id) {

		if (null == customerDAO.delete(id)) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT, headers = "Accept=application/json" )
	public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {

		customer = customerDAO.update(id, customer);

		if (null == customer) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}

}
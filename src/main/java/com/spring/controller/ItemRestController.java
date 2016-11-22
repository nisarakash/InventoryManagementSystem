package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dao.ItemDAO;
import com.spring.model.Item;


@RestController
public class ItemRestController {
	
	@Autowired
	private ItemDAO itemDAO;

	
	@GetMapping("/items")
	public List getCustomers() {
		return itemDAO.list();
	}

	@GetMapping("/items/{id}")
	public ResponseEntity getCustomer(@PathVariable("id") Long id) {

		Item customer = itemDAO.get(id);
		if (customer == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}

	@PostMapping(value = "/items")
	public ResponseEntity createCustomer(@RequestBody Item item) {

		itemDAO.create(item);

		return new ResponseEntity(item, HttpStatus.OK);
	}

	@DeleteMapping("/items/{id}")
	public ResponseEntity deleteCustomer(@PathVariable Long id) {

		if (null == itemDAO.delete(id)) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	
	@PutMapping("/items/{id}")
	public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Item item) {

		item = itemDAO.update(id, item);

		if (null == item) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(item, HttpStatus.OK);
	}

}

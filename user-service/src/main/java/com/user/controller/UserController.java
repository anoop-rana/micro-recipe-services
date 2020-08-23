package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.bean.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAllUser() {
		List<User> list = service.findAll();
		return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Optional<User> user = service.findUserById(id);
		return validateUser(user);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Object> findByName(@PathVariable String name) {
		Optional<User> user = service.findUserByName(name);
		return validateUser(user);
	}

	@PostMapping
	public ResponseEntity<User> createOrUpdate(@RequestBody User user) {
		User updated = service.createOrUpdate(user);
		return new ResponseEntity<User>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable long id) {
		Optional<User> user = service.findUserById(id);
		if (user.isPresent()) {
			service.deleteUser(id);
			return new ResponseEntity<Object>("Deleted", new HttpHeaders(), HttpStatus.FORBIDDEN);
		} else {
			return new ResponseEntity<Object>("Not Found", new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	private ResponseEntity<Object> validateUser(Optional<User> user) {
		if (user.isPresent())
			return new ResponseEntity<Object>(user.get(), new HttpHeaders(), HttpStatus.OK);
		else
			return new ResponseEntity<Object>("User Not Found", new HttpHeaders(), HttpStatus.OK);
	}
}

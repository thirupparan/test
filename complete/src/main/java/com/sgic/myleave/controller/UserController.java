package com.sgic.myleave.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.myleave.criteria.UserCriteria;
import com.sgic.myleave.entity.User;
import com.sgic.myleave.service.UserService;

@RestController

public class UserController {

	@Autowired
	public UserService userService;

	@GetMapping("/users")
//	public List<User> getUser() {
//		return userService.getUser();
//	}
	public ResponseEntity<Iterable<User>> viewUser() {
		Iterable<User> role = userService.viewUser();
		return new ResponseEntity<>(role, HttpStatus.OK);
	}

	@PostMapping("/users")
//	public List<User> createUsers(@Valid@RequestBody User user) {
//		return userService.createUsers(user);
//	}
	public ResponseEntity<String> addUser(@RequestBody User user) {
		boolean success = userService.saveUser(user);
		String result = "Add user failed";
		ResponseEntity<String> status = new ResponseEntity<>(result, HttpStatus.FORBIDDEN);
		if (success) {
			result = "Add user succesfully";
			status = new ResponseEntity<>(result, HttpStatus.OK);
		}
		return status;

	}

	@PutMapping("/users/{id}") // update
	public boolean update(@RequestBody User user, @PathVariable("id") Integer id) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/users/{id}") // delete
	public boolean delete(@PathVariable("id") Integer id) {
		return userService.deleteUser(id);
	}
	@GetMapping("/users/{name}")
	public User findByName(@PathVariable("name")String name) {
		return userService.findByName(name);
		
	}
	@GetMapping("users/{userName}")
	public List<User>findAllByName(@RequestParam(value ="userName",required =false)String name){
		List<User> users;
		if (name == null) {
			users = userService.viewUser();
		}
		else {
			users=userService.findAllByName(name);
		}
		return users;
		
	}
	@GetMapping("users/search")
	public ResponseEntity<List<User>>getUsers(UserCriteria userCriteria){
		List<User> users = userService.search(userCriteria);
		ResponseEntity<List<User>>response = new ResponseEntity<>(users,HttpStatus.OK); 
		return response;
		
	}

}

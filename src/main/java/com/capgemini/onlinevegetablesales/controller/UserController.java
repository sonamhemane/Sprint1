package com.capgemini.onlinevegetablesales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevegetablesales.dto.OrderDTO;
import com.capgemini.onlinevegetablesales.dto.UserDTO;
import com.capgemini.onlinevegetablesales.dto.VegetablesDTO;
import com.capgemini.onlinevegetablesales.entity.User;
import com.capgemini.onlinevegetablesales.service.UserService;

@CrossOrigin("http://localhost:63849/")
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userservice;

	@PostMapping("/add-user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User result = userservice.saveUser(user);
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// http://localhost:9091/api/user/1
	@GetMapping("/{id}")
	public UserDTO getuserById(@PathVariable int id) {
		UserDTO dto = userservice.getById(id);
		return dto;
	}

	// http://localhost:9091/api/user
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllOrder() {
		List<UserDTO> list = userservice.findAll();
		return ResponseEntity.ok(list);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
		UserDTO user = userservice.updateUser(userDTO);
		return new ResponseEntity<UserDTO>(user, HttpStatus.ACCEPTED);

	}

}

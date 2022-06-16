package com.dio.project.micro.azure.micro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.project.micro.azure.micro.dto.UserDTO;
import com.dio.project.micro.azure.micro.model.UserModel;
import com.dio.project.micro.azure.micro.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {
	@Autowired
	private final UserService userService;
	
	@GetMapping
	public ResponseEntity<Iterable<UserModel>> getUsers(){
		return ResponseEntity.ok(userService.getUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserModel> getUser(Long id){
		return ResponseEntity.ok(userService.getUser(id));
	}
	
	@PostMapping
	public ResponseEntity<UserModel> create(UserDTO userDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserModel> update(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO){
		return ResponseEntity.ok(userService.update(id, userDTO)); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserModel> delete(@PathVariable Long id){
		return ResponseEntity.ok(userService.delete(id));
	}
}

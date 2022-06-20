package com.dio.project.micro.azure.micro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.project.micro.azure.micro.dto.UserDTO;
import com.dio.project.micro.azure.micro.model.UserModel;
import com.dio.project.micro.azure.micro.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Iterable<UserModel> getUsers(){
		return userRepository.findAll();
	}
	
	public UserModel getUser(Long id) {
		return userRepository.findById(id).orElseThrow(() ->{
			log.error("User not found with id {}",id);
			return new RuntimeException("User not found with id {}" + id);
		});
	}
	
	public UserModel create(UserDTO userDTO) {
		UserModel userModel = UserModel.builder().name(userDTO.getName()).email(userDTO.getEmail()).build();
		return userRepository.save(userModel);
	}
	
	public UserModel update(Long id, UserDTO userDTO) {
		UserModel userModel = userRepository.findById(id).orElseThrow(() ->{
			log.error("User not found with id {}",id);
			return new RuntimeException("User not found with id {}" + id);
		});
		userModel.setName(userDTO.getName());
		userModel.setEmail(userDTO.getEmail());
		return userRepository.save(userModel);
	}
	
	public UserModel delete(Long id) {
		UserModel userModel = userRepository.findById(id).orElseThrow(() ->{
			log.error("User not found with id {}",id);
			return new RuntimeException("User not found with id {}" + id);
		});
		userRepository.delete(userModel);
		return userModel;
	}
}

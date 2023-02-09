package com.capgemini.onlinevegetablesales.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevegetablesales.dto.OrderDTO;
import com.capgemini.onlinevegetablesales.dto.UserDTO;
import com.capgemini.onlinevegetablesales.entity.User;
import com.capgemini.onlinevegetablesales.repository.UserRepository;
import com.capgemini.onlinevegetablesales.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		User user= new User();
		BeanUtils.copyProperties(userDTO, user);
		repository.save(user);
		return userDTO;
	}

	@Override
	public boolean deleteUser(UserDTO userDTO) {
		User user= new User();
		BeanUtils.copyProperties(userDTO, user);
		repository.delete(user);
		return true;
	}

	@Override
	public UserDTO getById(int id) {
		Optional<User> user=repository.findById(id);
		if(user.isPresent()) {
			UserDTO dto=new UserDTO();
			BeanUtils.copyProperties(user.get(), dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<UserDTO> getAllOrder() {
		Iterable<User> list=repository.findAll();
		List<UserDTO> dtos= new ArrayList<>();
		for(User usr:list) {
			UserDTO dto=new UserDTO();
			BeanUtils.copyProperties(usr, dto);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<UserDTO> findAll() {
		// TODO Auto-generated method stub
		Iterable<User> list=repository.findAll();
		List<UserDTO> dtos= new ArrayList<>();
		for(User usr:list) {
			UserDTO dto=new UserDTO();
			BeanUtils.copyProperties(usr, dto);
			dtos.add(dto);
		}
		return dtos;
	}

	
}

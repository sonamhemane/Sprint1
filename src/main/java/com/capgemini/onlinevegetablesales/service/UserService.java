package com.capgemini.onlinevegetablesales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.onlinevegetablesales.dto.AdminDTO;
import com.capgemini.onlinevegetablesales.dto.OrderDTO;
import com.capgemini.onlinevegetablesales.dto.UserDTO;
import com.capgemini.onlinevegetablesales.entity.User;
import com.capgemini.onlinevegetablesales.exception.UserNotFoundException;

@Service
public interface UserService {

	public User saveUser(User user);
	public UserDTO updateUser(UserDTO userDTO);
    public boolean deleteUser(UserDTO userDTO);
    public UserDTO getById(int userId); // throws UserNotFoundException;
    public List<UserDTO> getAllOrder();
	public List<UserDTO> findAll();
}

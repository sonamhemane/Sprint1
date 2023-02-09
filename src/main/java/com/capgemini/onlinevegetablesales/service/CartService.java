package com.capgemini.onlinevegetablesales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.onlinevegetablesales.dto.AdminDTO;
import com.capgemini.onlinevegetablesales.dto.CartDTO;
import com.capgemini.onlinevegetablesales.dto.OrderDTO;
import com.capgemini.onlinevegetablesales.entity.Cart;
import com.capgemini.onlinevegetablesales.exception.ItemNotAvailableException;

@Service
public interface CartService {
	public Cart addToCart(int userId, int vegId,CartDTO cartDTO)throws ItemNotAvailableException;
	 
	//public CartDTO saveCart(CartDTO cartDTO);
	public CartDTO updateCart(CartDTO cartDTO);
	public boolean deleteCart(CartDTO cartDTO);
	public CartDTO getById(int id);
	public List<CartDTO> findAll();
	public Cart updateCart(Cart cart) throws ItemNotAvailableException;
}

package com.capgemini.onlinevegetablesales.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevegetablesales.dto.AdminDTO;
import com.capgemini.onlinevegetablesales.dto.CartDTO;
import com.capgemini.onlinevegetablesales.entity.Admin;
import com.capgemini.onlinevegetablesales.entity.Cart;
import com.capgemini.onlinevegetablesales.entity.User;
import com.capgemini.onlinevegetablesales.entity.Vegetables;
import com.capgemini.onlinevegetablesales.exception.ItemNotAvailableException;
import com.capgemini.onlinevegetablesales.repository.CartRepository;
import com.capgemini.onlinevegetablesales.repository.UserRepository;
import com.capgemini.onlinevegetablesales.repository.VegetablesRepository;
import com.capgemini.onlinevegetablesales.service.CartService;
import com.capgemini.onlinevegetablesales.service.UserService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRrepository;

	@Autowired
	private VegetablesRepository vegetablesRepository;

	public List<Cart> listCart(int userId) {
		return cartRepository.findCartItemsByUserId(userId);
	}
	public double price(int userId) {
		return cartRepository. findPriceByUserId( userId);
	}

	/*
	 * @Override public CartDTO saveCart(Cart cart) { int userId=
	 * cartDTO.getUserId(); int vegetablesId= cartDTO.getVegId(); User user =
	 * userRrepository.findById(userId).get(); List<Vegetables> vegetables =
	 * vegetablesRepository.findById(vegetablesId).get();
	 * 
	 * if(user != null || vegetables != null) { Cart cart= new Cart();
	 * BeanUtils.copyProperties(cartDTO, cart); cart.setUser(user);
	 * cart.setVegetables(vegetables); cart.setQuantity(cartDTO.getQuantity());
	 * 
	 * cartRepository.save(cart); } return cartDTO; }
	 */

	public List<Vegetables> allVegetables() {
		List<Vegetables> vegetablesList = (List<Vegetables>) vegetablesRepository.findAll();
		return vegetablesList;
	}

	@Override
	public CartDTO updateCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		BeanUtils.copyProperties(cartDTO, cart);
		cartRepository.save(cart);
		return cartDTO;
	}

	@Override
	public boolean deleteCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		BeanUtils.copyProperties(cartDTO, cart);
		cartRepository.delete(cart);
		return true;
	}

	@Override
	public CartDTO getById(int id) {
		Optional<Cart> cart = cartRepository.findById(id);
		if (cart.isPresent()) {
			// convert the entity to DTO
			CartDTO dto = new CartDTO();
			BeanUtils.copyProperties(cart.get(), dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<CartDTO> findAll() {
		Iterable<Cart> list = cartRepository.findAll();
		List<CartDTO> dtos = new ArrayList<>();
		for (Cart crt : list) {
			CartDTO dto = new CartDTO();
			BeanUtils.copyProperties(crt, dto);
			dtos.add(dto);
		}
		return dtos;

	}

	@Override
	public Cart addToCart(int userId, int vegId, CartDTO cartDTO) throws ItemNotAvailableException {
		User user = userRrepository.findById(userId).get();
		Vegetables vegetables = vegetablesRepository.findById(vegId).get();
		Cart cart = new Cart();
		if (user != null && vegetables != null) {
			cart.setUserId(user.getUserId());
			cart.setVegName(vegetables.getVegName());
			cart.setVegPrice(vegetables.getPrice() * cartDTO.getQuantity());
			cart.setQuantity(cartDTO.getQuantity());
			return cartRepository.save(cart);

		} else
			throw new ItemNotAvailableException("Item not found");

	}

	@Override
	public Cart updateCart(Cart cart) throws ItemNotAvailableException {
		try {
			Cart cartResult = cartRepository.findById(cart.getCrtId()).get();
			if (cartResult != null) {
				cart.setVegPrice((cartResult.getVegPrice() / cartResult.getQuantity()) * cart.getQuantity());
				return cartRepository.save(cart);
			}
		} catch (NoSuchElementException e) {
			throw new ItemNotAvailableException("Cart With cart Id " + cart.getCrtId() + " Not Found");
		}
		return null;
	}

}

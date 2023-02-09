package com.capgemini.onlinevegetablesales.controller;

import java.util.List;

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

import com.capgemini.onlinevegetablesales.dto.AdminDTO;
import com.capgemini.onlinevegetablesales.dto.CartDTO;
import com.capgemini.onlinevegetablesales.dto.VegetablesDTO;
import com.capgemini.onlinevegetablesales.entity.Cart;
import com.capgemini.onlinevegetablesales.exception.ItemNotAvailableException;
import com.capgemini.onlinevegetablesales.service.CartService;
import com.capgemini.onlinevegetablesales.service.UserService;

@RestController
@RequestMapping("/api/Cart")
public class CartController {

	@Autowired
	private CartService cartservice;

	@PostMapping("/add-to-cart/{userId}/{vegId}")
	public ResponseEntity<Cart> saveCart(@RequestBody CartDTO cartDTO, @PathVariable("userId") int userId,
			@PathVariable("vegId") int vegId) throws ItemNotAvailableException {
		Cart cart = cartservice.addToCart(userId, vegId, cartDTO);
		if (cart != null) {
			return new ResponseEntity<>(cart, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(cart, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update-cart")
	public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) throws ItemNotAvailableException{
		Cart result= cartservice.updateCart(cart);
		if(result != null) {
			return new ResponseEntity<Cart>(cart,HttpStatus.OK);
		}else {
			return new ResponseEntity<Cart>(cart,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// http://localhost:9091/api/cart/1
	@GetMapping("/get-cart-by-id/{id}")
	public CartDTO getCartById(@PathVariable int id) {
		CartDTO dto = cartservice.getById(id);
		return dto;
	}

	// http://localhost:9091/api/cart
	@GetMapping("/get-all-cart")
	public List<CartDTO> getAllCart() {
		List<CartDTO> list = cartservice.findAll();
		return list;
	}

	@PutMapping("/update-cart/{id}")
	public ResponseEntity<CartDTO> updateCart(@RequestBody CartDTO cartDTO) {
		CartDTO cart = cartservice.updateCart(cartDTO);
		return new ResponseEntity<CartDTO>(cart, HttpStatus.ACCEPTED);
	}
}

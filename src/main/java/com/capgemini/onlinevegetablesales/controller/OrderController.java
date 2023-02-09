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

import com.capgemini.onlinevegetablesales.dto.CartDTO;
import com.capgemini.onlinevegetablesales.dto.OrderDTO;
import com.capgemini.onlinevegetablesales.dto.VegetablesDTO;
import com.capgemini.onlinevegetablesales.entity.Cart;
import com.capgemini.onlinevegetablesales.entity.Order;
import com.capgemini.onlinevegetablesales.exception.ItemNotAvailableException;
import com.capgemini.onlinevegetablesales.service.OrderService;

@RestController
@RequestMapping("/api/Order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping
	public ResponseEntity<Order> saveOrder(@RequestBody OrderDTO orderDTO, @PathVariable("userId") int userId) throws ItemNotAvailableException {
		Order order = service.placeOrder(userId);
		if (order != null) {
			return new ResponseEntity<>(order, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(order, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//public OrderDTO saveOrder(@RequestBody OrderDTO orderDTO) {
	
	//return orderDTO;
	//}
	
	
	//http://localhost:9091/api/order/1
	@GetMapping("/{id}")
	public OrderDTO getOrderById(@PathVariable int id) throws ItemNotAvailableException {
		OrderDTO dto=service.getById(id);
		return dto;
	}
	//http://localhost:9091/api/order
	@GetMapping
	public List<OrderDTO> getAllOrder(){
		List<OrderDTO> list=service.findAll();
		return list;
	}
	
	@PostMapping("/place-order/{userId}")
	public ResponseEntity<Order> placeOrder(@PathVariable int userId) throws ItemNotAvailableException {
		Order result = service.placeOrder(userId);
		if(result!=null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

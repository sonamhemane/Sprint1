package com.capgemini.onlinevegetablesales.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevegetablesales.dto.OrderDTO;
import com.capgemini.onlinevegetablesales.entity.Cart;
import com.capgemini.onlinevegetablesales.entity.Order;
import com.capgemini.onlinevegetablesales.entity.User;
import com.capgemini.onlinevegetablesales.entity.Vegetables;
import com.capgemini.onlinevegetablesales.exception.ItemNotAvailableException;
import com.capgemini.onlinevegetablesales.repository.CartRepository;
import com.capgemini.onlinevegetablesales.repository.OrderRepository;
import com.capgemini.onlinevegetablesales.repository.UserRepository;
import com.capgemini.onlinevegetablesales.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	@Override
	public OrderDTO saveOrder(OrderDTO orderDTO) {
		Order order = new Order();
		BeanUtils.copyProperties(orderDTO, order);
		orderRepository.save(order);
		return orderDTO;
	}

	@Override
	public OrderDTO updateOrder(OrderDTO orderDTO) {
		Order order = new Order();
		BeanUtils.copyProperties(orderDTO, order);
		orderRepository.save(order);
		return orderDTO;
	}

	@Override
	public boolean deleteOrder(OrderDTO orderDTO) {
		Order order = new Order();
		BeanUtils.copyProperties(orderDTO, order);
		orderRepository.delete(order);
		return true;
	}

	@Override
	public OrderDTO getById(int id) throws ItemNotAvailableException {
		Optional<Order> order = orderRepository.findById(id);
		if (order.isPresent()) {
			OrderDTO dto = new OrderDTO();
			BeanUtils.copyProperties(order.get(), dto);
			return dto;
		}

		throw new ItemNotAvailableException("Item not available at this time");
	}

	@Override
	public List<OrderDTO> findAll() {
		Iterable<Order> list = orderRepository.findAll();
		List<OrderDTO> dtos = new ArrayList<>();
		for (Order ord : list) {
			OrderDTO dto = new OrderDTO();
			BeanUtils.copyProperties(ord, dtos);
			dtos.add(dto);
		}

		return null;
	}

	@Override
	public Order placeOrder(int userId) throws ItemNotAvailableException {
		try {
			List<Vegetables> veg = new ArrayList<>();
			Order order = new Order();
			List<Cart> cartItems = cartRepository.findCartItemsByUserId(userId);
			if (cartItems != null) {
				cartItems.stream().forEach(c -> {
					Vegetables v = new Vegetables();
					v.setVegName(c.getVegName());
					v.setPrice(c.getVegPrice());
					veg.add(v);
				});
			}
			User user = userRepository.findById(userId).get();
			if (user != null) {
				order.setUser(user);
				order.setTotalprice(cartRepository.findPriceByUserId(userId));
				order.setVegetables(veg);
				order.setDate(LocalDate.now());
				
				Order result= orderRepository.save(order);
				
				return result;
			}

		} catch (NoSuchElementException e) {

			throw new ItemNotAvailableException("Item not found");
		}
		return null;

	}

}

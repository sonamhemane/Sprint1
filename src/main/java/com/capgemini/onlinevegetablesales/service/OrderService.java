/**
 * 
 */
package com.capgemini.onlinevegetablesales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.onlinevegetablesales.dto.CartDTO;
import com.capgemini.onlinevegetablesales.dto.OrderDTO;
import com.capgemini.onlinevegetablesales.entity.Cart;
import com.capgemini.onlinevegetablesales.entity.Order;
import com.capgemini.onlinevegetablesales.exception.ItemNotAvailableException;

/**
 * @author sovilash
 *
 */
@Service
public interface OrderService {

	public OrderDTO saveOrder(OrderDTO orderDTO);
   public OrderDTO updateOrder(OrderDTO orderDTO);
    public boolean deleteOrder(OrderDTO orderDTO);
    public OrderDTO getById(int id) throws ItemNotAvailableException;
    public List<OrderDTO> findAll();
   // public Order placeOrder(int userId, OrderDTO orderDTO) throws ItemNotAvailableException;
	//Order placeOrder(int userId, CartDTO cartDTO);
	public Order placeOrder(int userId) throws ItemNotAvailableException;
	
	
	
}

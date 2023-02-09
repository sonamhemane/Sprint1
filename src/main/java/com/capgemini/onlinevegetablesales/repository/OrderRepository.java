package com.capgemini.onlinevegetablesales.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevegetablesales.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
	
	

}

package com.capgemini.onlinevegetablesales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevegetablesales.entity.Cart;
import com.capgemini.onlinevegetablesales.entity.User;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
	
	@Query(value="select * from cart_tbl where user_id=?1",nativeQuery = true)
	public List<Cart> findCartItemsByUserId(int userId);
	
	@Query(value="select sum(veg_price) from cart_tbl where user_id=?1",nativeQuery = true)
	public double findPriceByUserId(int userId);
	
	@Query(value="Delete * from cart_tbl where user_id=?1",nativeQuery = true)
	public void deleteByUserId(int userId);


	
	

}

package com.capgemini.onlinevegetablesales.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevegetablesales.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}

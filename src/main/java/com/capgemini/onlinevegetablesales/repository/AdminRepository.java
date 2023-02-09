package com.capgemini.onlinevegetablesales.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevegetablesales.entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer>{

}

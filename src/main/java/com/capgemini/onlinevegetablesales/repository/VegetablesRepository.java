package com.capgemini.onlinevegetablesales.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevegetablesales.entity.Vegetables;

@Repository
public interface VegetablesRepository extends CrudRepository<Vegetables, Integer>{

	
}

package com.capgemini.onlinevegetablesales.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevegetablesales.dto.UserDTO;
import com.capgemini.onlinevegetablesales.dto.VegetablesDTO;
import com.capgemini.onlinevegetablesales.entity.User;
import com.capgemini.onlinevegetablesales.entity.Vegetables;
import com.capgemini.onlinevegetablesales.repository.VegetablesRepository;
import com.capgemini.onlinevegetablesales.service.VegetablesService;

@Service
public class VegetablesServiceImpl implements VegetablesService {

	@Autowired
	private VegetablesRepository repository;
	
	@Override
	public VegetablesDTO saveVegetables(VegetablesDTO vegetablesDTO) {
		Vegetables vegetables = new Vegetables();
		BeanUtils.copyProperties(vegetablesDTO, vegetables);
		repository.save(vegetables);
		return vegetablesDTO;
	
	}

	@Override
	public VegetablesDTO updateVegetables(VegetablesDTO vegetablesDTO) {
		Vegetables vegetables = new Vegetables();
		BeanUtils.copyProperties(vegetablesDTO, vegetables);
		repository.save(vegetables);
		return vegetablesDTO;
	}

	@Override
	public boolean deleteVegetables(VegetablesDTO vegetablesDTO) {
		Vegetables vegetables = new Vegetables();
		BeanUtils.copyProperties(vegetablesDTO, vegetables);
		repository.delete(vegetables);
		return true;
	}

	@Override
	public VegetablesDTO getById(int id) {
		Optional<Vegetables> vegetables =repository.findById(id);
		if(vegetables.isPresent()) {
			VegetablesDTO dto=new VegetablesDTO();
			BeanUtils.copyProperties(vegetables.get(), dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<VegetablesDTO> findAll() {
		Iterable<Vegetables> list=repository.findAll();
		List<VegetablesDTO> dtos=new ArrayList<>();
		for(Vegetables vegis:list) {
			VegetablesDTO dto=new VegetablesDTO();
			BeanUtils.copyProperties(vegis, dtos);
			dtos.add(dto);
	}
		return null;

}
}

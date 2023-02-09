package com.capgemini.onlinevegetablesales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.onlinevegetablesales.dto.VegetablesDTO;

@Service
public interface VegetablesService {

	public VegetablesDTO saveVegetables(VegetablesDTO vegetablesDTO);
	public VegetablesDTO updateVegetables(VegetablesDTO vegetablesDTO);
    public boolean deleteVegetables(VegetablesDTO vegetablesDTO);
    public VegetablesDTO getById(int id);
    public List<VegetablesDTO> findAll();
	
}

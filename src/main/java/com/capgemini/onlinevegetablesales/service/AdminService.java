package com.capgemini.onlinevegetablesales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.onlinevegetablesales.dto.AdminDTO;
import com.capgemini.onlinevegetablesales.dto.OrderDTO;

@Service
public interface AdminService {

	public AdminDTO saveAdmin(AdminDTO adminDTO);
	public AdminDTO updateAdmin(AdminDTO adminDTO);
	public boolean deleteAdmin(AdminDTO adminDTO);
	public AdminDTO getById(int id);
    public List<AdminDTO> findAll();
	
}

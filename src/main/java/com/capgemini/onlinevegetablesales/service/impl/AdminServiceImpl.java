package com.capgemini.onlinevegetablesales.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevegetablesales.dto.AdminDTO;
import com.capgemini.onlinevegetablesales.entity.Admin;
import com.capgemini.onlinevegetablesales.repository.AdminRepository;
import com.capgemini.onlinevegetablesales.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository repository;
	
	@Override
	public AdminDTO saveAdmin(AdminDTO adminDTO) {
		Admin admin=new Admin();
		BeanUtils.copyProperties(adminDTO, admin);
		repository.save(admin);
		return adminDTO;
	}

	@Override
	public AdminDTO updateAdmin(AdminDTO adminDTO) {
		Admin admin=new Admin();
		BeanUtils.copyProperties(adminDTO, admin);
		repository.save(admin);
		return adminDTO;
	}

	@Override
	public boolean deleteAdmin(AdminDTO adminDTO) {
		Admin admin=new Admin();
		BeanUtils.copyProperties(adminDTO, admin);
		repository.delete(admin);
		return true;
	}

	@Override
	public AdminDTO getById(int id) {
		Optional<Admin> admin=repository.findById(id);
		if(admin.isPresent()) {
			//convert the entity to DTO
			AdminDTO dto= new AdminDTO();
			BeanUtils.copyProperties(admin.get(), dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<AdminDTO> findAll() {
		Iterable<Admin>list=repository.findAll();
		List<AdminDTO> dtos=new ArrayList<>();
		for(Admin adm:list) {
			AdminDTO dto=new AdminDTO();
			BeanUtils.copyProperties(adm, dto);
			dtos.add(dto);
			
		}
		return dtos;
	}
	
	

}

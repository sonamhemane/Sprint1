package com.capgemini.onlinevegetablesales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevegetablesales.dto.AdminDTO;
import com.capgemini.onlinevegetablesales.dto.CartDTO;
import com.capgemini.onlinevegetablesales.service.AdminService;

@RestController //It is combination of  @Controller and @ResponseBody
@RequestMapping("/api/Admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping
	public AdminDTO saveAdmin(@RequestBody AdminDTO adminDTO) {
		adminService.saveAdmin(adminDTO);
		return adminDTO;
	}
	//http://localhost:9091/api/admin/1
	@GetMapping("/{id}")
	public AdminDTO getAdminById(@PathVariable int id) {
		AdminDTO dto=adminService.getById(id);
		return dto;
	}
	//http://localhost:9091/api/admin
	@GetMapping
	public List<AdminDTO> getAllAdmin(){
		List<AdminDTO> list=adminService.findAll();
		return list;
	}
	@PutMapping("/{id}")
    public ResponseEntity<AdminDTO> updateCart(@RequestBody AdminDTO adminDTO) {
		AdminDTO admin = adminService.updateAdmin(adminDTO);
        return new ResponseEntity<AdminDTO>(admin, HttpStatus.ACCEPTED);
}
}

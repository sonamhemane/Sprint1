package com.capgemini.onlinevegetablesales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevegetablesales.dto.UserDTO;
import com.capgemini.onlinevegetablesales.dto.VegetablesDTO;
import com.capgemini.onlinevegetablesales.service.VegetablesService;

@RestController
@RequestMapping("/api/vegetables")
public class VegetablesController {
	
	@Autowired
	private VegetablesService vegatablesService;
	
	@PostMapping
	public VegetablesDTO saveVegetables(@RequestBody VegetablesDTO vegetablesDTO) {
		vegatablesService.saveVegetables(vegetablesDTO);
		return vegetablesDTO;
	}
	
	//http://localhost:9091/api/user/1
	@GetMapping("/{id}")
	public VegetablesDTO getvegetablesById(@PathVariable int id) {
		VegetablesDTO dto=vegatablesService.getById(id);
		return dto;
	}
	
	//http://localhost:9091/api/user
	@GetMapping
	public List<VegetablesDTO> getAllOrder() {
		List<VegetablesDTO> list=vegatablesService.findAll();
		return list;
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<VegetablesDTO> update(@RequestBody VegetablesDTO vegetablesDTO) {
		VegetablesDTO vegetables = vegatablesService.updateVegetables(vegetablesDTO);
        return new ResponseEntity<VegetablesDTO>(vegetables, HttpStatus.ACCEPTED);

    }

	@DeleteMapping("/{Id}")
    public ResponseEntity<VegetablesDTO> deleteVegetablesById(@PathVariable int id) {
        VegetablesDTO vegetablesDTO = vegatablesService.getById(id);
        if(vegetablesDTO!=null) {
        	vegatablesService.deleteVegetables(vegetablesDTO);
            return new ResponseEntity<VegetablesDTO>(vegetablesDTO, HttpStatus.ACCEPTED);
        }else
        	return new ResponseEntity<VegetablesDTO>(vegetablesDTO, HttpStatus.NOT_FOUND);
}
}

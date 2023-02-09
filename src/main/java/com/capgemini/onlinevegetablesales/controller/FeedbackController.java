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
import com.capgemini.onlinevegetablesales.dto.FeedbackDTO;
import com.capgemini.onlinevegetablesales.dto.UserDTO;
import com.capgemini.onlinevegetablesales.service.FeedbackService;

@RestController
@RequestMapping
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping
	public FeedbackDTO saveFeedback(@RequestBody FeedbackDTO feedbackDTO) {
		feedbackService.saveFeedback(feedbackDTO);
		return feedbackDTO;
	}
	//http://localhost:9091/api/feedback/1
	@GetMapping("/{id}")
	public FeedbackDTO getFeedbackById(@PathVariable int id) {
		FeedbackDTO dto=feedbackService.getById(id);
		return dto;
	}
	//http://localhost:9091/api/feedback
	@GetMapping
	public List<FeedbackDTO> getAllFeedback(){
		List<FeedbackDTO> list=feedbackService.findAll();
		return list;
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<FeedbackDTO> updateFeedback(@RequestBody FeedbackDTO feedbackDTO) {
		FeedbackDTO feedback = feedbackService.updateFeedback(feedbackDTO);
        return new ResponseEntity<FeedbackDTO>(feedback, HttpStatus.ACCEPTED);

 

    }

}

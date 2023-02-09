package com.capgemini.onlinevegetablesales.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevegetablesales.dto.AdminDTO;
import com.capgemini.onlinevegetablesales.dto.CartDTO;
import com.capgemini.onlinevegetablesales.dto.FeedbackDTO;
import com.capgemini.onlinevegetablesales.entity.Cart;
import com.capgemini.onlinevegetablesales.entity.Feedback;
import com.capgemini.onlinevegetablesales.repository.CartRepository;
import com.capgemini.onlinevegetablesales.repository.FeedbackRepository;
import com.capgemini.onlinevegetablesales.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackRepository repository;
	
	@Override
	public FeedbackDTO saveFeedback(FeedbackDTO feedbackDTO) {
		Feedback feedback= new Feedback();
		BeanUtils.copyProperties(feedbackDTO, feedback);
		repository.save(feedback);
		return feedbackDTO;
	}

	@Override
	public FeedbackDTO updateFeedback(FeedbackDTO feedbackDTO) {
		Feedback feedback= new Feedback();
		BeanUtils.copyProperties(feedbackDTO, feedback);
		repository.save(feedback);
		return feedbackDTO;
	}

	@Override
	public boolean deleteFeedback(FeedbackDTO feedbackDTO) {
		Feedback feedback= new Feedback();
		BeanUtils.copyProperties(feedbackDTO, feedback);
		repository.delete(feedback);
		return true;
	}

	@Override
	public FeedbackDTO getById(int id) {
		Optional<Feedback> feedback=repository.findById(id);
		if(feedback.isPresent()) {
			//convert the entity to DTO
			FeedbackDTO dto= new FeedbackDTO();
			BeanUtils.copyProperties(feedback.get(), dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<FeedbackDTO> findAll() {
		Iterable<Feedback>list=repository.findAll();
		List<FeedbackDTO> dtos= new ArrayList<>();
		for(Feedback feed:list) {
			FeedbackDTO dto=new FeedbackDTO();
			BeanUtils.copyProperties(feed, dto);
			dtos.add(dto);
		}
		return null;
	}

	
}

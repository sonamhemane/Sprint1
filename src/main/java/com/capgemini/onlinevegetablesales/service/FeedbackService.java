package com.capgemini.onlinevegetablesales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.onlinevegetablesales.dto.AdminDTO;
import com.capgemini.onlinevegetablesales.dto.FeedbackDTO;
import com.capgemini.onlinevegetablesales.dto.OrderDTO;

@Service
public interface FeedbackService {

	public FeedbackDTO saveFeedback(FeedbackDTO feedbackDTO);
	public FeedbackDTO updateFeedback(FeedbackDTO feedbackDTO);
    public boolean deleteFeedback(FeedbackDTO feedbackDTO);
    public FeedbackDTO getById(int id);
    public List<FeedbackDTO> findAll();
}

package com.blood.donors.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.blood.donors.dao.bean.Feedback;
import com.blood.donors.dao.bean.User;
import com.blood.donors.service.FeedbackService;
import com.blood.donors.service.UserService;

@RestController
public class FeedbackController {
	
	@Autowired
	private FeedbackService<Feedback, Integer> feedbackService;
	
	@GetMapping(path="/feedbacks")
	public ResponseEntity<List<Feedback>> loadFeedbacks()
	{
		return new ResponseEntity<List<Feedback>>(feedbackService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path="/feedbacks/{feedbackId}")
	public ResponseEntity<Feedback> getFeetBackById(@PathVariable("feedbackId") Integer feedbackId)
	{
		return new ResponseEntity<Feedback>(feedbackService.getById(feedbackId),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/feedbacks/{feedbackId}")
	public ResponseEntity<Feedback> delteFeetBackById(@PathVariable("feedbackId") Integer feedbackId)
	{
		return new ResponseEntity<Feedback>(feedbackService.deleteById(feedbackId),HttpStatus.OK);
	}
	
	@PostMapping(path="/feedbacks")
	public ResponseEntity<Feedback> postFeedBack(@RequestBody Feedback feedback)
	{
		return new ResponseEntity<Feedback>(feedbackService.saveOrUpdate(feedback),HttpStatus.OK);
	}
	
	@PutMapping(path="/feedbacks")	
	public ResponseEntity<Feedback> updateUser(@RequestBody Feedback feedback)
	{
		return new ResponseEntity<Feedback>(feedbackService.saveOrUpdate(feedback),HttpStatus.OK);
	}
}

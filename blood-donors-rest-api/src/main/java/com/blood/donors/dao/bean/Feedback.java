package com.blood.donors.dao.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="USERS_FEEDBACK")
public class Feedback {

	@Id
	@GenericGenerator(name="increment",strategy="increment")
	@GeneratedValue(generator="increment")
	@Column(name="FEEDBACK_ID")
	private String feedbackId = null;
	
	@Column(name="FEEDBACK_Message")
	private String feedbackMessage = null;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "POSTED_BY")
	@JsonManagedReference
	private User postedUser = null;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DONOR_ID")
	@JsonBackReference
	private User  donor = null;
	
	public Feedback()
	{
		
	}

	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackMessage() {
		return feedbackMessage;
	}

	public void setFeedbackMessage(String feedbackMessage) {
		this.feedbackMessage = feedbackMessage;
	}

	public User getPostedUser() {
		return postedUser;
	}

	public void setPostedUser(User postedUser) {
		this.postedUser = postedUser;
	}

	public User getDonor() {
		return donor;
	}

	public void setDonor(User donor) {
		this.donor = donor;
	}
	
	
	
}

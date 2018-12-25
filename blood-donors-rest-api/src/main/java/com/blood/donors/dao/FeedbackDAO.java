package com.blood.donors.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.blood.donors.dao.BaseDAO;
import com.blood.donors.dao.bean.Feedback;

@Repository
public class FeedbackDAO extends BaseDAO<Feedback, Serializable> {

	public FeedbackDAO()
	{
		super(Feedback.class);
	}
}

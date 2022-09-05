package com.saad.service;

import com.saad.entity.Answer;
import com.saad.repository.AnswerRepository;
import com.saad.utility.MyFactoryService;

public class AnswerService extends MyFactoryService<AnswerRepository, Answer, Long> {

	public AnswerService() {
		super(new AnswerRepository());

	}

}

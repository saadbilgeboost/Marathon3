package com.saad.service;

import com.saad.entity.Question;
import com.saad.repository.QuestionRepository;
import com.saad.utility.MyFactoryService;

public class QuestionService extends MyFactoryService<QuestionRepository, Question, Long> {

	public QuestionService() {
		super(new QuestionRepository());

	}

}

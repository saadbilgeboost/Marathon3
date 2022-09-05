package com.saad.repository;

import com.saad.entity.Answer;
import com.saad.utility.MyFactoryRepository;

public class AnswerRepository extends MyFactoryRepository<Answer, Long> {
	public AnswerRepository() {
		super(new Answer());

	}
}

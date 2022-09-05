package com.saad.repository;

import com.saad.entity.Question;
import com.saad.utility.MyFactoryRepository;

public class QuestionRepository extends MyFactoryRepository<Question, Long> {
	public QuestionRepository() {
		super(new Question());

	}
}
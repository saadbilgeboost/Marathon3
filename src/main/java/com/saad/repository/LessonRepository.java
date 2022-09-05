package com.saad.repository;

import com.saad.entity.Lesson;
import com.saad.utility.MyFactoryRepository;

public class LessonRepository extends MyFactoryRepository<Lesson, Long> {
	public LessonRepository() {
		super(new Lesson());

	}
}

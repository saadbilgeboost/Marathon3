package com.saad.service;

import com.saad.entity.Lesson;
import com.saad.repository.LessonRepository;
import com.saad.utility.MyFactoryService;

public class LessonService extends MyFactoryService<LessonRepository, Lesson, Long> {

	public LessonService() {
		super(new LessonRepository());

	}
}

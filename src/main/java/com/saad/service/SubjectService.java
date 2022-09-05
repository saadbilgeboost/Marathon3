package com.saad.service;

import com.saad.entity.Subject;
import com.saad.repository.SubjectRepository;
import com.saad.utility.MyFactoryService;

public class SubjectService extends MyFactoryService<SubjectRepository, Subject, Long> {

	public SubjectService() {
		super(new SubjectRepository());

	}

}

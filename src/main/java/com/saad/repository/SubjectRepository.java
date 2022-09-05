package com.saad.repository;

import com.saad.entity.Subject;
import com.saad.utility.MyFactoryRepository;

public class SubjectRepository extends MyFactoryRepository<Subject, Long> {

	public SubjectRepository() {
		super(new Subject());
	}
}

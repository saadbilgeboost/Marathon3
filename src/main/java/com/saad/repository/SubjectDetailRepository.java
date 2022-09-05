package com.saad.repository;

import com.saad.entity.SubjectDetail;
import com.saad.utility.MyFactoryRepository;

public class SubjectDetailRepository extends MyFactoryRepository<SubjectDetail, Long> {

	public SubjectDetailRepository() {
		super(new SubjectDetail());
	}
}

package com.saad.service;

import com.saad.entity.SubjectDetail;
import com.saad.repository.SubjectDetailRepository;
import com.saad.utility.MyFactoryService;

public class SubjectDetailService extends MyFactoryService<SubjectDetailRepository, SubjectDetail, Long> {

	public SubjectDetailService() {
		super(new SubjectDetailRepository());

	}
}

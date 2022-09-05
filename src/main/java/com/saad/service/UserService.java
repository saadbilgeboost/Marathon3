package com.saad.service;

import com.saad.entity.User;
import com.saad.repository.UserRepository;
import com.saad.utility.MyFactoryService;

public class UserService extends MyFactoryService<UserRepository, User, Long> {

	public UserService() {
		super(new UserRepository());

	}

}

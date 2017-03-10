package com.websystique.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.UserProfileDao;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.UserProfileService;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{
	
	@Autowired
	UserProfileDao userProfileDao;
	
	public UserProfile findById(int id) {
		return userProfileDao.findById(id);
	}

	public UserProfile findByType(String type){
		return userProfileDao.findByType(type);
	}

	public List<UserProfile> findAll() {
		return userProfileDao.findAll();
	}
}

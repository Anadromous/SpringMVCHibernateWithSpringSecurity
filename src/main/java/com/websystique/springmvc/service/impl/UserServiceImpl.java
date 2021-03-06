package com.websystique.springmvc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.UserDao;
import com.websystique.springmvc.model.Customer;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.CustomerService;
import com.websystique.springmvc.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;
	
	@Autowired
	CustomerService customerService;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public User findById(int id) {
		return userDao.findById(id);
	}

	public User findBySSO(String sso) {
		User user = userDao.findBySSO(sso);
		return user;
	}

	public void saveUser(User user) {
		
		logger.info("User:newUser- "+user.toString());
		logger.info("Customer:User -"+user.getCustomer().toString());
		
		//add the customer to get it's id...
		
		user.getCustomer().setSsoId(user.getSsoId());
		Customer c = customerService.addCustomer(user.getCustomer());
		user.setCustomer(c);
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(User user) {
		User entity = userDao.findById(user.getId());
		if(entity!=null){
			entity.setSsoId(user.getSsoId());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			
			entity.setUserProfiles(user.getUserProfiles());
		}
	}

	
	public void deleteUserBySSO(String sso) {
		userDao.deleteBySSO(sso);
	}

	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		User user = findBySSO(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
}

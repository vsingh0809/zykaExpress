package com.zykaExpress.service;
 

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.zykaExpress.model.User;
import com.zykaExpress.repository.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	/*
	 * @Override public Optional<User> getUser(String email, String password) {
	 * 
	 * return userRepository.findbyEmailAndPassword(email, password); }
	 */
	@Override
	public String DeleteUser(Long id) {
		userRepository.deleteById(id);
		return "user removed";
	}

	@Override
	public User createUser(User user) {
	
		return userRepository.save(user);
	}

}

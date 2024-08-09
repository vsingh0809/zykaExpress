package com.zykaExpress.service;

import java.util.Optional;

import com.zykaExpress.model.User;

import antlr.collections.List;

public interface UserService {
 //Optional<User> getUser(String email,String password);
 String DeleteUser(Long id);
 User createUser(User user);
 Optional<User> GetUSer(Long id);
  
	
	

}

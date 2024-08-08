package com.zykaExpress.service;

import com.zykaExpress.model.User;

public interface UserService {
 //Optional<User> getUser(String email,String password);
 String DeleteUser(Long id);
 User createUser(User user);
	
	

}

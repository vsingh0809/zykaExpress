package com.zykaExpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zykaExpress.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

	//Optional<User> findbyEmailAndPassword(String email,String password);

	//User save(User user);
}

package com.zykaExpress.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zykaExpress.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

//Optional<User> findbyemailAndpassword(String email,String password);


}

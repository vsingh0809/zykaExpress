package com.zykaExpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zykaExpress.model.User;
import com.zykaExpress.service.UserService;


@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService useService;
	
	@PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = useService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }
	
	 
	/*
	 * @GetMapping("/login") public ResponseEntity<User>
	 * getUserByEmailAndPassword(@RequestParam String email, @RequestParam String
	 * password) { Optional<User> user = userService.getUser(email, password);
	 * return user.map(ResponseEntity::ok).orElseGet(() ->
	 * ResponseEntity.status(401).build()); }
	 */   
}
